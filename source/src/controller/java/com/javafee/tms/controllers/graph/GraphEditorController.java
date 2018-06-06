package com.javafee.tms.controllers.graph;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javafee.tms.components.utils.FileComponent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

@Component
public class GraphEditorController {

	@FXML
	private Label labelFileName;

	@FXML
	private ComboBox<String> comboBoxGraphKind;

	@FXML
	private TextArea textAreaFileContent;

	@FXML
	private Label labelInfo;

	@Autowired
	private FileComponent fileComponent;

	@FXML
	public void onClickButtonCancel(ActionEvent event) {
		((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
	}

	@FXML
	public void onClickButtonSave() {
		fileComponent.saveFile();
	}

	@FXML
	public void onClickButtonSaveAs() {
		fileComponent.saveFile();
	}

}
