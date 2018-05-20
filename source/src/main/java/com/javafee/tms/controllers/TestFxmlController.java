package com.javafee.tms.controllers;

import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

@Component
public class TestFxmlController {

	@FXML
	private Button btnTest;

	@FXML
	private TextField textFieldTest;

	@FXML
	public void onClickBtnTest() {
		textFieldTest.setText("Test success!");
	}
}
