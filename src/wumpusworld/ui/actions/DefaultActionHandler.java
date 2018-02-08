package wumpusworld.ui.actions;

import java.io.PrintStream;
import java.util.List;

import wumpusworld.Direction;
import wumpusworld.Game;
import wumpusworld.NoDoorException;
import wumpusworld.ui.DirectionLabel;

public class DefaultActionHandler implements ActionHandler {

	@Override
	public ActionHandler parseInput(String string, PrintStream out, Game game) {
		if (string.equalsIgnoreCase("F")) {
//			rest(out);
			return this;
		}
		if (string.equalsIgnoreCase("R")) {
//			rest(out);
			return this;
		}
		Direction d = DirectionLabel.findByLabel(string);
		if (d == null) {
			rest(out);
			return this;
		}
		try {
			game.move(d);
			printAvailableDirections(out, game);
		}
		catch (NoDoorException ndex) {
			out.print("Sorry there is no Door there.\n");
		}
		return this;
	}
	
	private void rest(PrintStream out) {
		out.print("Player rested.\n");
	}
	
	public void printAvailableDirections(PrintStream out, Game game) {
		List<Direction> directions = game.getAvailableDirections();
		if (directions.isEmpty()) {
			out.print("No directions to move\n");
		}
		else {
			String s = "Available Directions are ";
			for (Direction d : directions) {
				s += DirectionLabel.findByDirection(d).label + ", ";
			}
			out.print(trimTrailingComma(s) + ".\n");
		}
	}
	
	private String trimTrailingComma(String s) {
		return s.substring(0, s.length() - 2);
	}

}