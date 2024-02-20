package com.marceloluiz.PokeAPITeamBuilder.gui;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import com.marceloluiz.PokeAPITeamBuilder.models.PokeStats;
import com.marceloluiz.PokeAPITeamBuilder.models.entities.Pokemon;
import com.marceloluiz.PokeAPITeamBuilder.models.entities.PokemonPokedex;
import com.marceloluiz.PokeAPITeamBuilder.services.PokemonPokedexDeserializer;
import com.marceloluiz.PokeAPITeamBuilder.services.PokemonService;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

@Component
public class TeamBuilderController implements Initializable{
	
	@FXML
	private ImageView addImgOne;
	@FXML
	private ImageView addImgTwo;
	@FXML
	private ImageView addImgThree;
	@FXML
	private ImageView addImgFour;
	@FXML
	private ImageView addImgFive;
	@FXML
	private ImageView addImgSix;
	
	//PANE 1
	@FXML
	private Label nameLabel;
	@FXML
	private Label idLabel;
	
	@FXML
	private ImageView mainImage;
	
	@FXML
	private ImageView firstTypeImg;
	@FXML
	private ImageView secondTypeImg;
	
	@FXML
	private Label hpLabel;
	@FXML
	private ProgressBar hpProgressBar;
	@FXML
	private Label hpValueLabel;
	
	@FXML
	private Label atkLabel;
	@FXML
	private ProgressBar atkProgressBar;
	@FXML
	private Label atkValueLabel;
	
	@FXML
	private Label defLabel;
	@FXML
	private ProgressBar defProgressBar;
	@FXML
	private Label defValueLabel;
	
	@FXML
	private Label spAtkLabel;
	@FXML
	private ProgressBar spAtkProgressBar;
	@FXML
	private Label spAtkValueLabel;
	
	@FXML
	private Label spDefLabel;
	@FXML
	private ProgressBar spDefProgressBar;
	@FXML
	private Label spDefValueLabel;
	
	@FXML
	private ImageView changeImg;
	
	//PANE 2
	@FXML
	private Label nameLabelTwo;
	@FXML
	private Label idLabelTwo;
	
	@FXML
	private ImageView mainImageTwo;
	
	@FXML
	private ImageView firstTypeImg2;
	@FXML
	private ImageView secondTypeImg2;
	
	@FXML
	private Label hpLabelTwo;
	@FXML
	private ProgressBar hpProgressBarTwo;
	@FXML
	private Label hpValueLabelTwo;
	
	@FXML
	private Label atkLabelTwo;
	@FXML
	private ProgressBar atkProgressBarTwo;
	@FXML
	private Label atkValueLabelTwo;
	
	@FXML
	private Label defLabelTwo;
	@FXML
	private ProgressBar defProgressBarTwo;
	@FXML
	private Label defValueLabelTwo;
	
	@FXML
	private Label spAtkLabelTwo;
	@FXML
	private ProgressBar spAtkProgressBarTwo;
	@FXML
	private Label spAtkValueLabelTwo;
	
	@FXML
	private Label spDefLabelTwo;
	@FXML
	private ProgressBar spDefProgressBarTwo;
	@FXML
	private Label spDefValueLabelTwo;

	@FXML
	private ImageView changeImgTwo;
	
	//PANE 3
	@FXML
	private Label nameLabelThree;
	@FXML
	private Label idLabelThree;
	
	@FXML
	private ImageView mainImageThree;
	
	@FXML
	private ImageView firstTypeImg3;
	@FXML
	private ImageView secondTypeImg3;
	
	@FXML
	private Label hpLabelThree;
	@FXML
	private ProgressBar hpProgressBarThree;
	@FXML
	private Label hpValueLabelThree;
	
	@FXML
	private Label atkLabelThree;
	@FXML
	private ProgressBar atkProgressBarThree;
	@FXML
	private Label atkValueLabelThree;
	
	@FXML
	private Label defLabelThree;
	@FXML
	private ProgressBar defProgressBarThree;
	@FXML
	private Label defValueLabelThree;
	
	@FXML
	private Label spAtkLabelThree;
	@FXML
	private ProgressBar spAtkProgressBarThree;
	@FXML
	private Label spAtkValueLabelThree;
	
	@FXML
	private Label spDefLabelThree;
	@FXML
	private ProgressBar spDefProgressBarThree;
	@FXML
	private Label spDefValueLabelThree;

	@FXML
	private ImageView changeImgThree;
	
	//PANE 4
	@FXML
	private Label nameLabelFour;
	@FXML
	private Label idLabelFour;
	
	@FXML
	private ImageView mainImageFour;
	
	@FXML
	private ImageView firstTypeImg4;
	@FXML
	private ImageView secondTypeImg4;
	
	@FXML
	private Label hpLabelFour;
	@FXML
	private ProgressBar hpProgressBarFour;
	@FXML
	private Label hpValueLabelFour;
	
	@FXML
	private Label atkLabelFour;
	@FXML
	private ProgressBar atkProgressBarFour;
	@FXML
	private Label atkValueLabelFour;
	
	@FXML
	private Label defLabelFour;
	@FXML
	private ProgressBar defProgressBarFour;
	@FXML
	private Label defValueLabelFour;
	
	@FXML
	private Label spAtkLabelFour;
	@FXML
	private ProgressBar spAtkProgressBarFour;
	@FXML
	private Label spAtkValueLabelFour;
	
	@FXML
	private Label spDefLabelFour;
	@FXML
	private ProgressBar spDefProgressBarFour;
	@FXML
	private Label spDefValueLabelFour;

	@FXML
	private ImageView changeImgFour;
	
	//PANE 5
	@FXML
	private Label nameLabelFive;
	@FXML
	private Label idLabelFive;
	
	@FXML
	private ImageView mainImageFive;
	
	@FXML
	private ImageView firstTypeImg5;
	@FXML
	private ImageView secondTypeImg5;
	
	@FXML
	private Label hpLabelFive;
	@FXML
	private ProgressBar hpProgressBarFive;
	@FXML
	private Label hpValueLabelFive;
	
	@FXML
	private Label atkLabelFive;
	@FXML
	private ProgressBar atkProgressBarFive;
	@FXML
	private Label atkValueLabelFive;
	
	@FXML
	private Label defLabelFive;
	@FXML
	private ProgressBar defProgressBarFive;
	@FXML
	private Label defValueLabelFive;
	
	@FXML
	private Label spAtkLabelFive;
	@FXML
	private ProgressBar spAtkProgressBarFive;
	@FXML
	private Label spAtkValueLabelFive;
	
	@FXML
	private Label spDefLabelFive;
	@FXML
	private ProgressBar spDefProgressBarFive;
	@FXML
	private Label spDefValueLabelFive;

	@FXML
	private ImageView changeImgFive;
	
	//PANE 6
	@FXML
	private Label nameLabelSix;
	@FXML
	private Label idLabelSix;
	
	@FXML
	private ImageView mainImageSix;
	
	@FXML
	private ImageView firstTypeImg6;
	@FXML
	private ImageView secondTypeImg6;
	
	@FXML
	private Label hpLabelSix;
	@FXML
	private ProgressBar hpProgressBarSix;
	@FXML
	private Label hpValueLabelSix;
	
	@FXML
	private Label atkLabelSix;
	@FXML
	private ProgressBar atkProgressBarSix;
	@FXML
	private Label atkValueLabelSix;
	
	@FXML
	private Label defLabelSix;
	@FXML
	private ProgressBar defProgressBarSix;
	@FXML
	private Label defValueLabelSix;
	
	@FXML
	private Label spAtkLabelSix;
	@FXML
	private ProgressBar spAtkProgressBarSix;
	@FXML
	private Label spAtkValueLabelSix;
	
	@FXML
	private Label spDefLabelSix;
	@FXML
	private ProgressBar spDefProgressBarSix;
	@FXML
	private Label spDefValueLabelSix;

	@FXML
	private ImageView changeImgSix;
	
	//non javaFX components
	private PokemonService service;
	private ObservableList<Pokemon> obsList;
	
	private PokemonPokedexDeserializer pokemonPokedexDeserializer;
	private PokemonPokedex pokemon;
	
	public void setPokemonService(PokemonService service) {
		this.service = service;
	}
	
	//First Image Click Events
	@FXML
	public void onActionImgOneClick() {
		updatePokemonData(448, mainImage, firstTypeImg, secondTypeImg, nameLabel, idLabel);
		
		updatePokemonInfoControls(addImgOne, hpLabel, hpProgressBar, hpValueLabel, 
				atkLabel, atkProgressBar, atkValueLabel,
				defLabel, defProgressBar, defValueLabel,
				spAtkLabel, spAtkProgressBar, spAtkValueLabel,
				spDefLabel, spDefProgressBar, spDefValueLabel, changeImg);
	}
	@FXML
	public void onActionImgTwoClick() {
		updatePokemonData(6, mainImageTwo, firstTypeImg2, secondTypeImg2, nameLabelTwo, idLabelTwo);
		
		updatePokemonInfoControls(addImgTwo, hpLabelTwo, hpProgressBarTwo, hpValueLabelTwo, 
				atkLabelTwo, atkProgressBarTwo, atkValueLabelTwo,
				defLabelTwo, defProgressBarTwo, defValueLabelTwo,
				spAtkLabelTwo, spAtkProgressBarTwo, spAtkValueLabelTwo,
				spDefLabelTwo, spDefProgressBarTwo, spDefValueLabelTwo, changeImgTwo);
	}
	@FXML
	public void onActionImgThreeClick() {	
		updatePokemonData(149, mainImageThree, firstTypeImg3, secondTypeImg3, nameLabelThree, idLabelThree);
		
		updatePokemonInfoControls(addImgThree, hpLabelThree, hpProgressBarThree, hpValueLabelThree, 
				atkLabelThree, atkProgressBarThree, atkValueLabelThree,
				defLabelThree, defProgressBarThree, defValueLabelThree,
				spAtkLabelThree, spAtkProgressBarThree, spAtkValueLabelThree,
				spDefLabelThree, spDefProgressBarThree, spDefValueLabelThree, changeImgThree);
	}
	@FXML
	public void onActionImgFourClick() {	
		updatePokemonData(445, mainImageFour, firstTypeImg4, secondTypeImg4, nameLabelFour, idLabelFour);
		
		updatePokemonInfoControls(addImgFour, hpLabelFour, hpProgressBarFour, hpValueLabelFour, 
				atkLabelFour, atkProgressBarFour, atkValueLabelFour,
				defLabelFour, defProgressBarFour, defValueLabelFour,
				spAtkLabelFour, spAtkProgressBarFour, spAtkValueLabelFour,
				spDefLabelFour, spDefProgressBarFour, spDefValueLabelFour, changeImgFour);
	}
	@FXML
	public void onActionImgFiveClick() {	
		updatePokemonData(373, mainImageFive, firstTypeImg5, secondTypeImg5, nameLabelFive, idLabelFive);
		
		updatePokemonInfoControls(addImgFive, hpLabelFive, hpProgressBarFive, hpValueLabelFive, 
				atkLabelFive, atkProgressBarFive, atkValueLabelFive,
				defLabelFive, defProgressBarFive, defValueLabelFive,
				spAtkLabelFive, spAtkProgressBarFive, spAtkValueLabelFive,
				spDefLabelFive, spDefProgressBarFive, spDefValueLabelFive, changeImgFive);	
	}
	@FXML
	public void onActionImgSixClick() {	
		updatePokemonData(248, mainImageSix, firstTypeImg6, secondTypeImg6, nameLabelSix, idLabelSix);
		
		updatePokemonInfoControls(addImgSix, hpLabelSix, hpProgressBarSix, hpValueLabelSix, 
				atkLabelSix, atkProgressBarSix, atkValueLabelSix,
				defLabelSix, defProgressBarSix, defValueLabelSix,
				spAtkLabelSix, spAtkProgressBarSix, spAtkValueLabelSix,
				spDefLabelSix, spDefProgressBarSix, spDefValueLabelSix, changeImgSix);
	}
	
	//Change Pokemon Image Click Events
	@FXML
	public void onActionChangeImgClick() {
		System.out.println("onActionChangeImgClick");
	}
	@FXML
	public void onActionChangeImgTwoClick() {
		System.out.println("onActionChangeImgTwoClick");
	}
	@FXML
	public void onActionChangeImgThreeClick() {
		System.out.println("onActionChangeImgThreeClick");
	}
	@FXML
	public void onActionChangeImgFourClick() {
		System.out.println("onActionChangeImgFourClick");
	}
	@FXML
	public void onActionChangeImgFiveClick() {
		System.out.println("onActionChangeImgFiveClick");
	}
	@FXML
	public void onActionChangeImgSixClick() {
		System.out.println("onActionChangeImgSixClick");
	}
	
	private void pokemonImgUpdate(ImageView mainImage) {
		Image pokemonImg = new Image(pokemon.getImage());
		mainImage.setImage(pokemonImg);
	}

	private void pokemonTypeUpdate(ImageView imageOne, ImageView imageTwo) {
		imageOne.setImage(new Image(pokemon.getPokeType().get(0).getImage()));
		
		if(pokemon.getPokeType().size() == 1) {
			imageTwo.setImage(null);
		}
		else {	
			imageTwo.setImage(new Image(pokemon.getPokeType().get(1).getImage()));
		}
	}
	
	private void pokemonLabelUpdate(Label name, Label id) {
		name.setText(pokemon.getName());
		id.setText("N° " + Integer.toString(pokemon.getId()));
	}
	
//	private void updatePokemonStatsData() {
//		Label[] label = {hpLabel, atkLabel, defLabel, spAtkLabel, spDefLabel};
//		ProgressBar[] progressBar = {hpProgressBar, atkProgressBar, defProgressBar, spAtkProgressBar, spDefProgressBar};
//		Label[] labelValue = {hpValueLabel, atkValueLabel, defValueLabel, spAtkValueLabel, spDefValueLabel};
//		
//		for(int i = 0; i< pokemon.getStats().size() -1; i++) {
//			updateStatsInfo(pokemon.getStats().get(i), label[i], progressBar[i], labelValue[i]);
//		}
//	}
	
	private void updateStatsInfo(PokeStats stats, Label label, ProgressBar progressBar, Label labelValue) {
		label.setText(stats.getStat().toString().replace("_", " "));
		progressBar.setProgress((double) stats.getBaseStat() / 255);
		labelValue.setText(stats.getBaseStat().toString());
	}
	
	private void updatePokemonInfoControls(ImageView image, Label hp, ProgressBar hpBar, Label hpValue,
											Label atk, ProgressBar atkbar, Label atkValue,
											Label def, ProgressBar defBar, Label defValue,
											Label spAtk, ProgressBar spAtkBar, Label spAtkValue,
											Label spDef, ProgressBar spDefBar, Label spDefValue,
											ImageView changeImg) {
		image.setVisible(false);
		
		hp.setVisible(true);
		hpBar.setVisible(true);
		hpValue.setVisible(true);
		
		atk.setVisible(true);
		atkbar.setVisible(true);
		atkValue.setVisible(true);
		
		def.setVisible(true);
		defBar.setVisible(true);
		defValue.setVisible(true);
		
		spAtk.setVisible(true);
		spAtkBar.setVisible(true);
		spAtkValue.setVisible(true);
		
		spDef.setVisible(true);
		spDefBar.setVisible(true);
		spDefValue.setVisible(true);
		
		changeImg.setImage(new Image("file:assets/img/teams/pokemonChange.png"));
		
		Label[] label = {hp, atk, def, spAtk, spDef};
		ProgressBar[] progressBar = {hpBar, atkbar, defBar, spAtkBar, spDefBar};
		Label[] labelValue = {hpValue, atkValue, defValue, spAtkValue, spDefValue};
		
		for(int i = 0; i< pokemon.getStats().size() -1; i++) {
			updateStatsInfo(pokemon.getStats().get(i), label[i], progressBar[i], labelValue[i]);
		}
		
	}
	
	private void updatePokemonData(Integer jsonNumber, ImageView mainImage,
									ImageView firstType, ImageView secondtype,
									Label name, Label id){
		
		pokemonPokedexDeserializer = new PokemonPokedexDeserializer();
		pokemonPokedexDeserializer.setJson(jsonNumber);
		pokemon = pokemonPokedexDeserializer.createPokemon(pokemon);

		pokemonImgUpdate(mainImage);
		pokemonTypeUpdate(firstType, secondtype);
		pokemonLabelUpdate(name, id);
//		updatePokemonStatsData();
	}
	
	public void addPokemon() {
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}

//		List<Pokemon> list = service.findAll();
//		obsList = FXCollections.observableArrayList(list);
//		tableViewTeamBuilder.setItems(obsList);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeNodes();
	}
	
	private void initializeNodes() {
		Image addIcon = new Image("file:assets/img/teams/pokeball.png");
		addImgOne.setImage(addIcon);
		addImgTwo.setImage(addIcon);
		addImgThree.setImage(addIcon);
		addImgFour.setImage(addIcon);
		addImgFive.setImage(addIcon);
		addImgSix.setImage(addIcon);
	}
}
