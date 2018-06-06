package com.javafee.tms.services.mapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.logging.Level;

import org.springframework.stereotype.Service;

import com.javafee.tms.graph.Graph;
import com.javafee.tms.graph.directed.TuringGraph;
import com.javafee.tms.graph.elements.Edge;
import com.javafee.tms.graph.elements.Node;
import com.javafee.tms.graph.elements.TuringEdge;
import com.javafee.tms.graph.elements.TuringNode;
import com.javafee.tms.turing.Tape;

import lombok.extern.java.Log;

@Log
@Service
public class TuringGraphMapper {

	private BufferedReader bufferedReader;
	private Integer line;
	private LinkedList<String> tapes = new LinkedList<String>();
	private Tape defaultTape;

	public Tape getDefaultTape() {
		if (defaultTape == null) {
			defaultTape = new Tape("[" + Tape.getFillSymbol() + "]");
		}
		return defaultTape;
	}

	public LinkedList<String> getTapes() {
		if (tapes.size() == 0) {
			tapes.add("[" + Tape.getFillSymbol() + "]");
		}
		return tapes;
	}

	public Graph getGraph(File file) throws IOException {

		boolean fillSymbolChanged = false;
		Integer action;
		Double nodeXCord, nodeYCord, curve;
		String dataString, name, oldState, newState, oldSymbol, newSymbol;
		TuringNode turingNode;
		LinkedList<Node> nodes = new LinkedList<Node>();
		LinkedList<Edge> edges = new LinkedList<Edge>();
		StringTokenizer stok;

		tapes = new LinkedList<String>();

		try {
			bufferedReader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			log.log(Level.SEVERE, "Error while loading graph file resources " + file.getName(), e);
			return null;
		}

		line = 0;
		fillSymbolChanged = false;

		do {
			dataString = bufferedReader.readLine();
			if (dataString == null) { // file has not proper format
				log.log(Level.SEVERE, "Error while processing graph file. File has not proper format.");
				return null;
			}
			if (dataString.startsWith("fill symbol")) {
				line++;
				fillSymbolChanged = true;
				Tape.setFillSymbol(bufferedReader.readLine().trim());
			}
			line++;
		} while (!dataString.toLowerCase().startsWith("nodes"));

		if (!fillSymbolChanged) {
			Tape.setFillSymbol("#");
		}

		dataString = bufferedReader.readLine();
		if (dataString == null) {
			log.log(Level.SEVERE, "Error while processing graph file. File has not proper format.");
			return null;
		}
		stok = new StringTokenizer(dataString);

		// get all nodes
		do {
			if (dataString.startsWith("//") || stok.countTokens() == 0) {
				dataString = bufferedReader.readLine();
				if (dataString == null) {
					log.log(Level.SEVERE, "Error while processing graph file. File has not proper format.");
					return null;
				}
				stok = new StringTokenizer(dataString);
				line++;
				continue;
			}

			if ((stok.countTokens() != TuringNode.FIELDS)) {
				log.log(Level.SEVERE, "Error while processing graph file. Wrong number of parameters in line.");
				return null;
			}

			// get name
			name = new String(stok.nextToken());

			// get halt status - direction
			dataString = stok.nextToken().toUpperCase();
			if (dataString.equals("L"))
				action = TuringNode.LEFT;
			else if (dataString.equals("R"))
				action = TuringNode.RIGHT;
			else if (dataString.equals("H"))
				action = TuringNode.HALT;
			else if (dataString.equals("Y"))
				action = TuringNode.ACCEPT;
			else if (dataString.equals("N"))
				action = TuringNode.REJECT;
			else {
				log.log(Level.SEVERE, "Error while processing graph file. There is unknown direction symbol in line.");
				return null;
			}

			dataString = stok.nextToken();
			try {
				nodeXCord = Double.parseDouble(dataString);
			} catch (NumberFormatException e) {
				log.log(Level.SEVERE, "Error while processing graph file. There is not valid x coordinate.", e);
				return null;
			}

			dataString = stok.nextToken();
			try {
				nodeYCord = Double.parseDouble(dataString);
			} catch (NumberFormatException e) {
				log.log(Level.SEVERE, "Error while processing graph file. There is not valid y coordinate.", e);
				return null;
			}

			turingNode = new TuringNode(name, action, nodeXCord, nodeYCord);
			nodes.add(turingNode);

			dataString = bufferedReader.readLine();
			if (dataString == null) {
				log.log(Level.SEVERE, "Error while processing graph file. File has not proper format.");
				return null;
			}
			stok = new StringTokenizer(dataString);
			line++;

		} while (!dataString.toLowerCase().startsWith("edges"));

		dataString = bufferedReader.readLine();
		if (dataString == null) {
			log.log(Level.SEVERE, "Error while processing graph file. File has not proper format.");
			return null;
		}
		stok = new StringTokenizer(dataString);

		dataString = bufferedReader.readLine();
		if (dataString == null) {
			return null;
		}
		stok = new StringTokenizer(dataString);

		// get all edges
		do {
			if (dataString.startsWith("//") || stok.countTokens() == 0) {
				dataString = bufferedReader.readLine();
				if (dataString == null) {
					if (edges.size() == 0) {
						return null;
					} else {
						break;
					}
				}
				stok = new StringTokenizer(dataString);
				line++;
				continue;
			}

			if (stok.countTokens() != 5 && stok.countTokens() != 4) {
				log.log(Level.SEVERE, "Error while processing graph file. Wrong number of parameters in line.");
				return null;
			}
			oldState = stok.nextToken();
			newState = stok.nextToken();
			oldSymbol = stok.nextToken();
			newSymbol = stok.nextToken();

			if (stok.countTokens() == 0) {
				curve = 0.0;
			} else {
				dataString = stok.nextToken();
				curve = Double.parseDouble(dataString);
			}

			// add edge to List of edges, but check if adding this edge makes TM
			// nondeterministic
			if (!oldState.equals(newState) || !oldSymbol.equals(newSymbol)) {

				for (Edge edge : edges) {
					if (((TuringEdge) edge).getOldState().equals(oldState)
							&& ((TuringEdge) edge).getOldSymbol().equals(oldSymbol)) {
						// more then one way
					}
				}
				edges.add(new TuringEdge(oldState, newState, oldSymbol, newSymbol, curve));
			} else {
				String warning = "This edge rejected: " + oldState + " " + newState + " " + oldSymbol + " " + newSymbol
						+ ": and not needed";
				log.log(Level.WARNING, warning);
			}

		} while (!dataString.toLowerCase().startsWith("tapes"));

		dataString = bufferedReader.readLine();
		if (dataString == null) {
			defaultTape = new Tape("[" + Tape.getFillSymbol() + "]");
		}

		else {
			stok = new StringTokenizer(dataString);

			do {
				line++;
				if (dataString.startsWith("//") || stok.countTokens() == 0) {
					dataString = bufferedReader.readLine();
					if (dataString == null) {
						break;
					}
					stok = new StringTokenizer(dataString);
					continue;
				}
				tapes.add(dataString);
				dataString = bufferedReader.readLine();
				if (dataString == null) {
					break;
				}
				stok = new StringTokenizer(dataString);
			} while (true);

		}

		if (tapes.size() == 0) {
			defaultTape = new Tape("[" + Tape.getFillSymbol() + "]");
		} else {
			defaultTape = new Tape(tapes.get(0));
		}

		log.log(Level.INFO, "Mapping file " + file.getAbsolutePath() + " to graph success");
		return new TuringGraph(nodes, edges);
	}
}
