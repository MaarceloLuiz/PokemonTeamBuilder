package com.marceloluiz.PokeAPITeamBuilder;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class ChartApplication extends Application {

	private ConfigurableApplicationContext applicationContext;
	
	private static Scene mainScene;
	
	private ScrollPane scrollPane;

	@Override
	public void init() throws Exception {
		applicationContext = new SpringApplicationBuilder(PokeApiTeamBuilderApplication.class).run();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("gui/MainView.fxml"));
		loader.setControllerFactory(applicationContext::getBean);
		
		scrollPane = loader.load();
		scrollPane.setFitToHeight(true);
		scrollPane.setFitToWidth(true);
	}

	@Override
	public void start(Stage stage) throws Exception {
		applicationContext.publishEvent(new StageReadyEvent(stage));
		 
		mainScene = new Scene(scrollPane);
		
		stage.setScene(mainScene);
		stage.setTitle("PokeAPI JavaFX application");
		stage.show();
	}
	
	public static Scene getMainScene() {
		return mainScene;
	}

	@Override
	public void stop() throws Exception {
		applicationContext.close();
		Platform.exit();
	}

	// inner class
	public static class StageReadyEvent extends ApplicationEvent {
		private static final long serialVersionUID = 1L;

		public StageReadyEvent(Stage stage) {
			super(stage);
		}

		public Stage getStage() {
			return ((Stage) getSource());
		}
	}

}
