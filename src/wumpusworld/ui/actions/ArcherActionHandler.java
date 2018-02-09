package wumpusworld.ui.actions;

import java.io.PrintStream;
import java.util.List;

import wumpusworld.Direction;
import wumpusworld.Game;
import wumpusworld.ui.DirectionLabel;

public class ArcherActionHandler extends DefaultActionHandler {

	@Override
	public ActionHandler parseInput(String string, PrintStream out, Game game) {
		game.shootArrow(Direction.NORTH);
		out.print("Arrow missed.\n");
		out.print("You have " + game.getNumberOfArrows() + " arrows remaining.\n");
		return new DefaultActionHandler();
	}
	
	@Override
	public void printAvailableDirections(PrintStream out, Game game) {
		if (game.getNumberOfArrows() < 1) {
			out.print("You have no arrows.");
			return;
		}
		List<Direction> directions = game.getAvailableDirections();
		if (directions.isEmpty()) {
			out.print("No directions to shoot\n");
		}
		else {
			String s = "Available Directions to Fire Arrows are ";
			for (Direction d : directions) {
				s += DirectionLabel.findByDirection(d).label + ", ";
			}
			out.print(trimTrailingComma(s) + ". Which Direction do you want to shoot?\n");
		}
	}
 
}
