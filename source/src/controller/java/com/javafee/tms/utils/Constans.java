package com.javafee.tms.utils;

import java.text.SimpleDateFormat;

public final class Constans {

	public enum Context {
		ADDITION, MODIFICATION, CANCELED, LOAN, READING_ROOM;
	}

	public static final String MAIN_SPLASH_SCREEN_IMAGE = "/fxml/SplashScreenPane.fxml";
	public static final String MAIN_ICON_IMAGE = "/icon/tree-icon.png";

	public static final String APPLICATION_NAME = "Turing Machine Simulator";
	public static final String APPLICATION_LANGUAGE = "pl";
	public static final SimpleDateFormat APPLICATION_DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
	public static final SimpleDateFormat APPLICATION_DATE_TIME_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

	public static final String LANGUAGE_RESOURCE_BUNDLE = "language.messages";
	public static final String PL_LANGUAGE_RESOURCE_BUNDLE = "language.messages_pl_PL";
	public static final String EN_LANGUAGE_RESOURCE_BUNDLE = "language.messages_en_GB";

}
