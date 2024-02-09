package com.marceloluiz.PokeAPITeamBuilder.gui;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import com.marceloluiz.PokeAPITeamBuilder.models.entities.PokemonPokedex;
import com.marceloluiz.PokeAPITeamBuilder.models.enums.PokeType;
import com.marceloluiz.PokeAPITeamBuilder.services.PokemonPokedexDeserializer;
import com.marceloluiz.PokeAPITeamBuilder.util.Constraints;
import com.marceloluiz.PokeAPITeamBuilder.util.Utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

@Component
public class PokedexController implements Initializable{
	
	//FXML Controls
	@FXML
	private Button rightArrowBtn;
	@FXML
	private Button leftArrowBtn;
	@FXML
	private Button startBtn;
	
	@FXML
	private Pane paneBg;
	
	@FXML
	private ImageView photoFrame;
	
	@FXML
	private Button closeBtn;
	
	@FXML
	private ImageView typeOneImg;
	@FXML
	private ImageView typeTwoImg;
	
	@FXML
	private Label weaknessesTitleLabel;
	@FXML
	private Label weaknessesOneLabel;
	@FXML
	private Label weaknessesTwoLabel;
	@FXML
	private Label weaknessesThreeLabel;
	@FXML
	private Label weaknessesFourLabel;
	@FXML
	private Label weaknessesFiveLabel;
	@FXML
	private Label weaknessesSixLabel;
	
	@FXML
	private ImageView weaknessesOneImg;
	@FXML
	private ImageView weaknessesTwoImg;
	@FXML
	private ImageView weaknessesThreeImg;
	@FXML
	private ImageView weaknessesFourImg;
	@FXML
	private ImageView weaknessesFiveImg;
	@FXML
	private ImageView weaknessesSixImg;
	@FXML
	private ImageView regionImg;
	
	@FXML
	private Label regionLabel;
	@FXML
	private Label generationLabel;
	
	@FXML
	private Button shinyBtn;
	
	@FXML
	private Label nameLabel;
	@FXML
	private Label numberLabel;
	@FXML
	private Label typeOneLabel;
	@FXML
	private Label typeTwoLabel;
	
	@FXML
	private Label heightTxt;
	@FXML
	private Label weightTxt;
	@FXML
	private Label genderTxt;
	@FXML
	private Label heightLabel;
	@FXML
	private Label genderLabel;
	@FXML
	private Label weightLabel;
	
	@FXML
	private TextField searchTxt;
	
	@FXML
	private Button searchBtn;
	
	@FXML
	private Button infoBtn;
	
	@FXML
	private ImageView startImg;
	@FXML
	private ImageView closeImg;
	
	@FXML
	private Button statsBtn;
	
	//non JavaFx controlls
	private PokemonPokedexDeserializer pokemonPokedexDeserializer;
	private PokemonPokedex pokemon;
	private boolean shinyOn = false;
	
	
	@FXML
	public void onActionRightArrowBtn() {
		int index = pokemon.getId();
		
		if(pokemon.getId() == 1025) {
			System.out.println("cannot go any further");
		}
		else {
			pokemonPokedexDeserializer.setJson(index + 1);
			pokemon = pokemonPokedexDeserializer.createPokemon(pokemon);
			
			shinyOn = false;
			pokemonLabelUpdate();
			pokemonImgUpdate();
			
			searchTxt.setText("0");
		}
	}
	@FXML
	public void onActionLeftArrowBtn() {
		int index = pokemon.getId();
		
		if(pokemon.getId() == 1) {
			System.out.println("cannot go behind");
		}
		else {
			pokemonPokedexDeserializer.setJson(index - 1);
			pokemon = pokemonPokedexDeserializer.createPokemon(pokemon);
			
			shinyOn = false;
			pokemonLabelUpdate();
			pokemonImgUpdate();
			
			searchTxt.setText("0");
		}
	}
	
	@FXML
	public void onActionStartBtn(ActionEvent event) {
		initializeControls();
		
		pokemonPokedexDeserializer = new PokemonPokedexDeserializer();
		pokemonPokedexDeserializer.setJson(1);
		
		pokemon = pokemonPokedexDeserializer.createPokemon(pokemon);
		
		pokemonImgUpdate();
		pokemonLabelUpdate();
		
//		System.out.println(pokemon.toString());
	}
	
	private void pokemonImgUpdate() {
		Image pokemonImg = new Image(pokemon.getImage());
		photoFrame.setImage(pokemonImg);
	}
	
	private void pokemonLabelUpdate() {
		nameLabel.setText(pokemon.getName());
		numberLabel.setText("N° " + Integer.toString(pokemon.getId()));
		regionLabel.setText(pokemon.getRegion());
		generationLabel.setText(Integer.toString(pokemon.getGeneration()) + " GENERATION");
		heightLabel.setText(pokemon.getHeight());
		weightLabel.setText(pokemon.getWeight());
		//STATS BUTTON NOT READY YET
		
		pokemonTypeUpdate();
		pokemonWeaknessUpdate();
	}
	
	private void pokemonWeaknessUpdate() {
		// TODO Auto-generated method stub
		
	}
	private void pokemonTypeUpdate() {
//		PokeType type = pokemon.getPokeType().get(0);
//		String imgPath = type.getImage();
		
		String imgPath = pokemon.getPokeType().stream().map(PokeType::getImage).findFirst().orElse(null).toString();
		Image pokemonImg = new Image(imgPath);
		
		typeOneImg.setImage(pokemonImg);
		typeOneLabel.setText(pokemon.getPokeType().stream().findFirst().orElse(null).toString().toLowerCase());
		typeOneLabel.setStyle(pokemon.getPokeType().stream().map(PokeType::getColor).findFirst().orElse(null));
		
		if(pokemon.getPokeType().size() == 1) {
			typeTwoImg.setImage(null);
			typeTwoLabel.setText("");
		}
		else {
			imgPath = pokemon.getPokeType().stream().map(PokeType::getImage).skip(1).findFirst().orElse(null).toString();
			Image pokemonImgTwo = new Image(imgPath);
			typeTwoImg.setImage(pokemonImgTwo);
			typeTwoLabel.setText(pokemon.getPokeType().stream().skip(1).findFirst().orElse(null).toString().toLowerCase());
			typeTwoLabel.setStyle(pokemon.getPokeType().stream().map(PokeType::getColor).skip(1).findFirst().orElse(null));
		}
	}
	@FXML
	private void onActionSearchBtn() {
		String idNumber = searchTxt.getText();
		if(!idNumber.equals("")) {
			int number = Integer.parseInt(idNumber);
			if(number > 0 && number <= 1025) {		
				pokemonPokedexDeserializer.setJson(number);
				pokemon = pokemonPokedexDeserializer.createPokemon(pokemon);
				
				shinyOn = false;
				pokemonLabelUpdate();
				pokemonImgUpdate();
				
				searchTxt.setText(idNumber);
			}
			else searchTxt.setText("0");
		}
	}
	
	@FXML
	private void onActionShinyBtn() {
		if(!shinyOn && pokemon.getShinyImg() != null) {
			Image pokemonImg = new Image(pokemon.getShinyImg());
			photoFrame.setImage(pokemonImg);
			
			shinyOn = true;
		}
		else {
			pokemonImgUpdate();	
			shinyOn = false;
		}
	}
	
	@FXML
	private void onActionInfoBtn() {
		System.out.println("infoBtn");
	}
	
	@FXML
	private void onActionStatsBtn() {
		System.out.println("statsBtn");
	}
	
	@FXML
	public void onBtnCloseAction(ActionEvent event) {
		Utils.currentStage(event).close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeNodes();	
	}
	
	
	private void initializeNodes() {
		Constraints.setTextFieldNumericOnly(searchTxt);
	}
	
	private void initializeControls() {
		leftArrowBtn.setVisible(true);
		rightArrowBtn.setVisible(true);
		shinyBtn.setVisible(true);

		regionImg.setVisible(true);

        heightTxt.setVisible(true);
        weightTxt.setVisible(true);
        genderTxt.setVisible(true);
        
        weaknessesTitleLabel.setVisible(true);

        searchBtn.setVisible(true);
        searchTxt.setVisible(true);
        searchTxt.setText("0");

        closeBtn.setVisible(true);
        startBtn.setVisible(false);
        startImg.setVisible(false);
        closeImg.setVisible(true);
        
        statsBtn.setVisible(true);
	}
}