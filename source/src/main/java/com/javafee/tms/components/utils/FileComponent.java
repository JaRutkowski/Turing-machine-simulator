package com.javafee.tms.components.utils;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

@Component
public class FileComponent {

	private FileChooser fileChooser;

	public File chooseFile() {
		fileChooser.setTitle("Otwórz plik");
		fileChooser.getExtensionFilters().addAll( //
				new ExtensionFilter("Graph Files", "*.graph"), //
				new ExtensionFilter("All Files", "*.*"));

		return fileChooser.showOpenDialog(new Stage());
	}

	@Autowired
	private void initFields() {
		fileChooser = new FileChooser();
	}

	public void saveFile() {
		fileChooser.setTitle("Zapisz plik");
		File file = fileChooser.showSaveDialog(new Stage());

		if (file != null) {

		}
	}

}
