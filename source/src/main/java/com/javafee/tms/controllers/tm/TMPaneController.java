package com.javafee.tms.controllers.tm;

import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

@Component
public class TMPaneController {

	@FXML
	private CheckBox checkBoxShowMachineConfiguration;

	@FXML
	private AnchorPane anchorPaneGraphPane;

	@FXML
	private Parent tmConfigurationPane;

	@FXML
	private Parent tmTypePane;

	@FXML
	private Parent tmNavigationPane;

	@FXML
	public void onChangeCheckBoxShowMachineConfiguration() {
		tmConfigurationPane.setVisible(checkBoxShowMachineConfiguration.isSelected());
		setGraphPaneColumnSpane();
	}

	private void setGraphPaneColumnSpane() {
		if (!checkBoxShowMachineConfiguration.isSelected())
			GridPane.setColumnSpan(anchorPaneGraphPane, 5);
		else
			GridPane.setColumnSpan(anchorPaneGraphPane, 3);
	}

}
