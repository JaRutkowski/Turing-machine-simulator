package com.javafee.tms.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.logging.Level;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.javafee.tms.components.utils.FileComponent;
import com.javafee.tms.graph.Graph;
import com.javafee.tms.services.mapper.TuringGraphMapper;
import com.javafee.tms.utils.Dialog;
import com.javafee.tms.utils.Params;
import com.javafee.tms.utils.SystemProperties;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lombok.extern.java.Log;

@Log
@Component
public class MainFxmlController {

	@FXML
	private MenuItem menuItemExit;

	@Autowired
	private ApplicationContext springContext;

	@Autowired
	private FileComponent fileComponent;

	@Autowired
	private TuringGraphMapper turingGraphMapper;

	@FXML
	public void initialize() {
		menuItemExit.setOnAction(e -> {
			Platform.exit();
			System.exit(0);
		});
	}

	@FXML
	public void onClickMenuAbout() {

	}

	@FXML
	public void onClickMenuItemCreate() {
		openGraphEditorPane();
	}

	@FXML
	public void onClickMenuItemEdit() {

	}

	@FXML
	public void onClickMenuItemJumpToStep() {

	}

	@FXML
	public void onClickMenuItemLoad() {
		File file = fileComponent.chooseFile();

		if (file != null) {
			try {
				Graph graph = turingGraphMapper.getGraph(file);
				if (graph != null)
					Params.getInstance().add("CURRENT_GRAPH", graph);
				else
					Dialog.displayErrorDialog(
							SystemProperties.getResourceBundle().getString("dialog.errorDialogLoadHeader"),
							SystemProperties.getResourceBundle().getString("dialog.errorDialogLoadContent"));
			} catch (IOException e) {
				log.log(Level.SEVERE, "Error while loading graph to Params", e);
				Dialog.displayExceptionDialog(
						SystemProperties.getResourceBundle().getString("dialog.exceptionDialogHeader"), null,
						e.getMessage());
			}
		}
	}

	@FXML
	public void onClickMenuItemReset() {

	}

	@FXML
	public void onClickMenuItemRunPause() {

	}

	@FXML
	public void onClickMenuItemStepBack() {

	}

	@FXML
	public void onClickMenuItemStepForward() {

	}

	private void openGraphEditorPane() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/GraphEditorPane.fxml"),
					ResourceBundle.getBundle("language.messages_pl_PL"));
			fxmlLoader.setControllerFactory(springContext::getBean);
			Stage stage = new Stage();
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/icon/tree-icon.png")));
			stage.setTitle(ResourceBundle.getBundle("language.messages").getString("config.graphEditorName"));
			stage.setScene(new Scene((Parent) fxmlLoader.load()));
			stage.show();
		} catch (IOException e) {
			log.log(Level.SEVERE, "Error while loading resources GraphEditorPane.fxml", e);
		}
	}

}
