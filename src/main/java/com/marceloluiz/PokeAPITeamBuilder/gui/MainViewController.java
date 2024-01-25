package com.marceloluiz.PokeAPITeamBuilder.gui;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import com.marceloluiz.PokeAPITeamBuilder.services.APIConsumption;

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
	private ImageView logoImg;

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
		var json = apiConsumption.gettingData("https://pokeapi.co/api/v2/pokemon?limit=10&offset=0");
		
		System.out.println(json);
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
