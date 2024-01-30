package com.marceloluiz.PokeAPITeamBuilder.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import com.marceloluiz.PokeAPITeamBuilder.enums.PokeType;
import com.marceloluiz.PokeAPITeamBuilder.models.PokeData;
import com.marceloluiz.PokeAPITeamBuilder.services.APIConsumption;
import com.marceloluiz.PokeAPITeamBuilder.services.ConvertData;
import com.marceloluiz.PokeAPITeamBuilder.util.Utils;

import javafx.event.ActionEvent;
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
		
		for(int i = 1; i <= PokeType.values().length; i++) {
			find = "/type/" + i + "/";
			found = testType.contains(find);
			
			if(found == true) {
				type.add(i);
			}
			
		}

		for(int typeNumber : type) {
			System.out.println(PokeType.getById(typeNumber)); //instead of calling the api again, we can just use our Enum class
			
		}
		
//		PokeStats[] stats = new PokeStats[data.getStatsList().size()];
//		for(int i = 0; i < data.getStatsList().size(); i++) {
//			JsonNode stat = (JsonNode) data.getStatsList().get(i);
//			stats[i] = new PokeStats(PokeStats.Stats.getById(i+1),
//					stat.get("effort").asInt(),
//					stat.get("base_stat").asInt());
//		}
//			
//		System.out.println(stats);
	}

	@FXML
	public void onBtnCloseAction(ActionEvent event) {
		Utils.currentStage(event).close();
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
