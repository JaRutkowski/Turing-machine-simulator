package com.javafee.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class TuringMachineSimulator extends Application {

	private ConfigurableApplicationContext springContext;
	private Parent rootNode;

	public static void main(final String[] args) {
		Application.launch(args);
	}

	@Override
	public void init() throws Exception {
		springContext = SpringApplication.run(TuringMachineSimulator.class);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/TestFxml.fxml"));
		fxmlLoader.setControllerFactory(springContext::getBean);
		rootNode = fxmlLoader.load();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(rootNode));
		stage.show();
	}

	@Override
	public void stop() throws Exception {
		springContext.close();
	}

}
