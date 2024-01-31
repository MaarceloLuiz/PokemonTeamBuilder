package com.marceloluiz.PokeAPITeamBuilder.gui;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import com.marceloluiz.PokeAPITeamBuilder.models.entities.Pokemon;
import com.marceloluiz.PokeAPITeamBuilder.services.PokemonService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

@Component
public class PokedexController implements Initializable{
	
	private PokemonService service;

	@FXML
	private TableView<Pokemon> tableViewPokedex;
	@FXML
	private TableColumn<Pokemon, BufferedImage> tableColumnPicture;
	@FXML
	private TableColumn<Pokemon, Integer> tableColumnID;
	@FXML
	private TableColumn<Pokemon, String> tableColumnName;
	@FXML
	private TableColumn<Pokemon, Integer> tableColumnType;
	@FXML
	private TableColumn<Pokemon, Integer> tableColumnStats;
	
//	@FXML
//	private BarChart<?, ?> statsBarChart;

	private ObservableList<Pokemon> obsList;
	
	public void setPokemonService(PokemonService service) {
		this.service = service;
	}
	
	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}

		List<Pokemon> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewPokedex.setItems(obsList);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
}
