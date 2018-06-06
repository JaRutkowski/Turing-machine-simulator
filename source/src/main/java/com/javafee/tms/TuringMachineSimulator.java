package com.javafee.tms;

import java.util.ResourceBundle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.javafee.tms.utils.Constans;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;

@SpringBootApplication
public class TuringMachineSimulator extends Application {

	public static void main(final String[] args) {
		Application.launch(args);
	}

	private ConfigurableApplicationContext springContext;

	private Parent rootNode;

	@Override
	public void init() throws Exception {

		springContext = SpringApplication.run(TuringMachineSimulator.class);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constans.MAIN_SPLASH_SCREEN_IMAGE),
				ResourceBundle.getBundle(Constans.PL_LANGUAGE_RESOURCE_BUNDLE));
		fxmlLoader.setControllerFactory(springContext::getBean);
		rootNode = fxmlLoader.load();

		FadeTransition fadeOut = new FadeTransition(Duration.seconds(2), rootNode);
		fadeOut.setFromValue(0.5);
		fadeOut.setToValue(1);
		fadeOut.setCycleCount(1);
		fadeOut.play();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.getIcons().add(new Image(getClass().getResourceAsStream(Constans.MAIN_ICON_IMAGE)));
		stage.setTitle(ResourceBundle.getBundle(Constans.PL_LANGUAGE_RESOURCE_BUNDLE).getString("config.appName"));
		stage.setScene(new Scene(rootNode));
		stage.show();
	}

	@Override
	public void stop() throws Exception {
		springContext.close();
	}

}
