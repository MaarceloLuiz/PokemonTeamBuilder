package com.marceloluiz.PokeAPITeamBuilder.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import org.springframework.stereotype.Component;

import com.marceloluiz.PokeAPITeamBuilder.services.PokemonService;
import com.marceloluiz.PokeAPITeamBuilder.util.Alerts;
import com.marceloluiz.PokeAPITeamBuilder.util.Utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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
		loadView("../gui/TeamBuilder.fxml", "TeamBuilderView", (TeamBuilderController controller) -> {
			controller.setPokemonService(new PokemonService());
			controller.updateTableView();
		});
	}
	
	@FXML
	public void onBtnPokedexAction() {
		loadView("../gui/Pokedex.fxml", "PokedexView", x -> {});
	}

	@FXML
	public void onBtnCloseAction(ActionEvent event) {
		Utils.currentStage(event).close();
	}
	

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
	}
	
	private synchronized <T> void loadView(String absoluteName, String title, Consumer<T> initializingAction) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Parent root = (Parent) loader.load();
			
			Stage stage = new Stage();
			
			stage.setTitle(title);
			stage.setScene(new Scene(root));
			stage.show();

			T controller = loader.getController();
			initializingAction.accept(controller);
			
		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}
}
