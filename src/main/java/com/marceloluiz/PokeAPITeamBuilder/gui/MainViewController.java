package com.marceloluiz.PokeAPITeamBuilder.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import com.marceloluiz.PokeAPITeamBuilder.models.PokeData;
import com.marceloluiz.PokeAPITeamBuilder.models.PokeDataType;
import com.marceloluiz.PokeAPITeamBuilder.services.APIConsumption;
import com.marceloluiz.PokeAPITeamBuilder.services.ConvertData;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;

@Component
public class MainViewController implements Initializable{
	
	@FXML
	private MenuItem menuItemPokedex;
	@FXML
	private MenuItem menuItemTeamBuilder;
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	private Button teamBuilderBtn;
	@FXML
	private Button pokedexBtn;
	@FXML
	private Button closeBtn;
	
	@FXML
	private ImageView logoImg; //using "file:*filepath*" instead of "@*filepath*" makes the img show up in JavaFX

	@FXML
	public void onMenuItemPokedexAction() {
		System.out.println("pokedex");
	}

	@FXML
	public void onMenuItemDTeamBuilderAction() {
		System.out.println("teambuilder");
	}

	@FXML
	public void onMenuItemAboutAction() {
		System.out.println("about");
	}

	@FXML
	public void onBtnTeamBuilderAction() {
		System.out.println("teambuilder btn");
	}
	
	@FXML
	public void onBtnPokedexAction() {
		System.out.println("pokedex btn");
		
		//API class test
		var apiConsumption = new APIConsumption();
		var json = apiConsumption.gettingData("https://pokeapi.co/api/v2/pokemon/zekrom");
		
		ConvertData convert = new ConvertData();
		PokeData data = convert.getData(json, PokeData.class);
		
		System.out.println(data);
			
		System.out.println("----------------type test ----------------");
		
		String testType = data.getTypeList().toString();
		
		boolean found;
		String find = "";
		List<Integer> type = new ArrayList<>();
		
		for(int i = 1; i<=18; i++) {
			find = "/type/" + i + "/";
			found = testType.contains(find);
			
			if(found == true) {
				type.add(i);
			}
			
		}

		for(int typeNumber : type) {
			var jsonTypeURL = apiConsumption.gettingData("https://pokeapi.co/api/v2/type/" + typeNumber + "/");
			PokeDataType dataType = convert.getData(jsonTypeURL, PokeDataType.class);
			
			System.out.println(dataType);
		}
			
	}

	@FXML
	public void onBtnCloseAction() {
		System.out.println("close btn");
	}
	
//	@FXML
//	public void displayImage() {
//		try {
//			logoImg.setImage(new Image(getClass().getResourceAsStream("/assets/img/pokemonPokeball.png")));
//			logoImg.setCache(true);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
	}
}
