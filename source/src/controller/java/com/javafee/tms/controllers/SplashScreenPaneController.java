package com.javafee.tms.controllers;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import lombok.extern.java.Log;

@Log
@Component
public class SplashScreenPaneController {

	class SplashScreenSleeper extends Thread {

		@Override
		public void run() {
			try {
				Thread.sleep(2000);

				javafx.application.Platform.runLater(new Runnable() {

					@Override
					public void run() {
						try {
							FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"),
									ResourceBundle.getBundle("language.messages_pl_PL"));
							fxmlLoader.setControllerFactory(springContext::getBean);
							Parent rootNode = null;
							rootNode = fxmlLoader.load();
							Stage stage = new Stage();
							stage.getIcons().add(new Image(getClass().getResourceAsStream("/icon/tree-icon.png")));
							stage.setTitle(ResourceBundle.getBundle("language.messages").getString("config.appName"));
							stage.setScene(new Scene(rootNode));
							stage.show();

							stackPaneSplashScreenPane.getScene().getWindow().hide();
						} catch (IOException e) {
							log.log(Level.SEVERE, "Error while loading resources GraphEditorPane.fxml", e);
						}
					}
				});

			} catch (InterruptedException e) {
				log.log(Level.SEVERE, "Error while loading Splash Screen", e);
			}
		}

	}

	@FXML
	private StackPane stackPaneSplashScreenPane;

	@Autowired
	private ApplicationContext springContext;

	@FXML
	public void initialize() {
		new SplashScreenSleeper().start();
	}
}
