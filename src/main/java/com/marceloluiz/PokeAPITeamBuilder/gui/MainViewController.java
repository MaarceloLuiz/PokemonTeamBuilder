package com.marceloluiz.PokeAPITeamBuilder.gui;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

@Component
public class MainViewController implements Initializable{
	@FXML
	private MenuItem menuItemPokedex;

	@FXML
	private MenuItem menuItemTeamBuilder;

	@FXML
	private MenuItem menuItemAbout;

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

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
	}
}
