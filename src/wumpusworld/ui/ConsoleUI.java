package wumpusworld.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

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
	
	private InputStream in;
	private PrintStream out;
	private Game game;

	public ConsoleUI(InputStream in, PrintStream out, Game game) {
		this.in = in;
		this.out = out;
		this.game = game;
		printAvailableDirections(out, game);
		Scanner sc = new Scanner(in);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			if (line.isEmpty()) {
				break;
			} else {
				Direction d = DirectionLabel.findByLabel(line);
				game.move(d);
				printAvailableDirections(out, game);
			}
		}
		sc.close();
		
	}

	private void printAvailableDirections(PrintStream out, Game game) {
		List<Direction> directions = game.getAvailableDirections();
		if (directions.isEmpty()) {
			out.print("No directions to move\n");
		}
		else {
			String s = "Available directions: ";
			for (Direction d : directions) {
				s += DirectionLabel.findByDirection(d).label;
			}
			out.print(s + "\n");
		}
	}

}
