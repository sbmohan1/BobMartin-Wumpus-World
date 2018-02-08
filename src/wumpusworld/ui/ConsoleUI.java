package wumpusworld.ui;

import java.io.PrintStream;
import java.util.List;

import wumpusworld.Game;
import wumpusworld.Game.Direction;

public class ConsoleUI {
	
	public enum DirectionLabel {
		N(Direction.NORTH, "N"),
		W(Direction.WEST, "W"),
		S(Direction.SOUTH, "S"),
		E(Direction.EAST, "E");
		
		private String label;
		private Direction direction;
		
		private DirectionLabel(Direction direction, String label) {
			this.direction = direction;
			this.label = label;
		}
		
		public static DirectionLabel findByDirection(Direction d) {
			for (DirectionLabel label : values()) {
				if (label.direction.equals(d)) {
					return label;
				}
			}
			return null;
		}
		
		public static Direction findByLabel(String label) {
			for (DirectionLabel directionLabel : values()) {
				if (directionLabel.label.equals(label)) {
					return directionLabel.direction;
				}
			}
			return null;
		}
	}
	
	private PrintStream out;
	private Game game;
	
	public ConsoleUI(PrintStream out, Game game) {
		this.out = out;
		this.game = game;
	}

	public void run() {
		printAvailableDirections(out, game);
	}

	private void printAvailableDirections(PrintStream out, Game game) {
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

	public void parseInput(String string) {
		Direction d = DirectionLabel.findByLabel(string);
		game.move(d);
		printAvailableDirections(out, game);
	}

}
