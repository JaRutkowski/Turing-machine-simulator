package com.javafee.tms.controllers.tm;

import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

@Component
public class TMConfigurationPaneController {

	@FXML
	private TextField textFieldInitialState;

	@FXML
	private TextField textFieldFinalState;

	@FXML
	private TextArea textAreaStates;

	@FXML
	private TextField textFieldAlphabetSymbols;

	@FXML
	private TextField textFieldBlankSymbol;

}
