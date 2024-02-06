package com.marceloluiz.PokeAPITeamBuilder.gui;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import com.marceloluiz.PokeAPITeamBuilder.util.Constraints;
import com.marceloluiz.PokeAPITeamBuilder.util.Utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

@Component
public class PokedexController implements Initializable{
	
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
	private Label categoryTxt;
	@FXML
	private Label genderTxt;
	@FXML
	private Label heightLabel;
	@FXML
	private Label genderLabel;
	@FXML
	private Label weightLabel;
	@FXML
	private Label categoryLabel;
	
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
	public void onActionRightArrowBtn() {
		System.out.println("rightArrowBtn");
	}
	@FXML
	public void onActionLeftArrowBtn() {
		System.out.println("leftArrowBtn");
	}
	
	@FXML
	public void onActionStartBtn(ActionEvent event) {
		System.out.println("startBtn");
	}
	
	@FXML
	private void onActionSearchBtn() {
		System.out.println("searchBtn");
	}
	
	@FXML
	private void onActionShinyBtn() {
		System.out.println("shinyBtn");
	}
	
	@FXML
	private void onActionInfoBtn() {
		System.out.println("infoBtn");
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
}
