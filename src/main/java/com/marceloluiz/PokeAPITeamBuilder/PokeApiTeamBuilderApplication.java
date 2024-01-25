package com.marceloluiz.PokeAPITeamBuilder;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javafx.application.Application;

@SpringBootApplication
public class PokeApiTeamBuilderApplication {

	public static void main(String[] args) {
		//SpringApplication.run(PokeApiTeamBuilderApplication.class, args);
		Application.launch(ChartApplication.class, args); // javaFX init
	}

}
