package com.marceloluiz.PokeAPITeamBuilder.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import com.marceloluiz.PokeAPITeamBuilder.ChartApplication;
import com.marceloluiz.PokeAPITeamBuilder.models.entities.Pokemon;
import com.marceloluiz.PokeAPITeamBuilder.services.PokemonService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

@Component
public class TeamBuilderController implements Initializable{
	
	private PokemonService service;
	
	private ObservableList<Pokemon> obsList;
	
	@FXML
	private TableView<Pokemon> tableViewTeamBuilder;
	
	public void setPokemonService(PokemonService service) {
		this.service = service;
	}

	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}

		List<Pokemon> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewTeamBuilder.setItems(obsList);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeNodes();
	}
	
	private void initializeNodes() {
		Stage stage = (Stage) ChartApplication.getMainScene().getWindow();
		tableViewTeamBuilder.prefHeightProperty().bind(stage.heightProperty());
		tableViewTeamBuilder.prefHeightProperty().bind(stage.widthProperty());
		
	}
}
