package com.javafee.tms.turing;

import java.util.LinkedList;
import java.util.StringTokenizer;

public class Tape {

	private static String FILL_SYMBOL = "#";
	private static int TRAILING_EDGE = 0;

	private int position = 0;
	private LinkedList<String> tape;
	private int begining = TRAILING_EDGE;

	public Tape(String tapeString) {
		StringTokenizer stok = new StringTokenizer(tapeString);

		tape = new LinkedList<String>();

		int i;
		for (i = 0; i < TRAILING_EDGE; i++) {
			tape.add(FILL_SYMBOL);
		}

		for (i = TRAILING_EDGE; stok.hasMoreTokens(); i++) {
			String symbol = stok.nextToken();
			if (symbol.startsWith("[") && symbol.endsWith("]")) {
				position = i;
				tape.add(symbol.substring(1, symbol.length() - 1));
			} else {
				tape.add(symbol);
			}
		}

		for (int len = i; i < len + TRAILING_EDGE; i++) {
			tape.add(FILL_SYMBOL);
		}
	}

	public Tape(Tape sendedTape) {
		position = sendedTape.position;
		tape = new LinkedList<String>();
		for (String symbol : sendedTape.tape)
			tape.add(symbol);
		// tape = (LinkedList<String>) t.tape.clone();
	}

	public static String getFillSymbol() {
		return FILL_SYMBOL;
	}

	public static void setFillSymbol(String fillSymbol) {
		FILL_SYMBOL = fillSymbol;
	}

	public static int getTrailingEdge() {
		return TRAILING_EDGE;
	}

	public static void setTrailingEdge(int trailingEdge) {
		TRAILING_EDGE = trailingEdge;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public LinkedList<String> getTape() {
		return tape;
	}

	public void setTape(LinkedList<String> tape) {
		this.tape = tape;
	}

	public int getBegining() {
		return begining;
	}

	public void setBegining(int begining) {
		this.begining = begining;
	}

}
