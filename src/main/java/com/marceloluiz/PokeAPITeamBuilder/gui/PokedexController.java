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
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

@Component
public class PokedexController implements Initializable{
	
	private PokemonService service;
	
	@FXML
	private TextField pokeSearch;
	@FXML
	private Button searchBtn;

	@FXML
	private TableView<Pokemon> tableViewPokedex;
	@FXML
	private ImageView pokeImage;
	@FXML
	private TableColumn<Pokemon, Integer> tableColumnID;
	@FXML
	private TableColumn<Pokemon, String> tableColumnName;
	@FXML
	private TableColumn<Pokemon, Integer> tableColumnType;
	
	@FXML
	private ProgressBar statsProgressBar;

	private ObservableList<Pokemon> obsList;
	
	@FXML
	private void onActionSearchBtn() {
		System.out.println("searchBtn");
	}
	
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
		initializeNodes();
	}
	
	
	private void initializeNodes() {
		Stage stage = (Stage) ChartApplication.getMainScene().getWindow();
		tableViewPokedex.prefHeightProperty().bind(stage.heightProperty());
		tableViewPokedex.prefHeightProperty().bind(stage.widthProperty());
		
	}
}
