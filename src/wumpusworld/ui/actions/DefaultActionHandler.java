package wumpusworld.ui.actions;

import java.io.PrintStream;
import java.util.List;

import wumpusworld.Direction;
import wumpusworld.Game;
import wumpusworld.Game.Event;
import wumpusworld.NoDoorException;
import wumpusworld.ui.DirectionLabel;

public class DefaultActionHandler implements ActionHandler {

	@Override
	public ActionHandler parseInput(String string, PrintStream out, Game game) {
		switch(string) {
		case "F":
			if (game.getNumberOfArrows() < 1) {
				out.print("You have no arrows.\n");
				return this;
			}
			ArcherActionHandler actionHandler = new ArcherActionHandler();
			actionHandler.printAvailableDirections(out, game);
			return actionHandler;
		
		case "R":
			rest(out);
			return this;
		default:
			Direction d = DirectionLabel.findByLabel(string);
			if (d == null) {
				rest(out);
				return this;
			}
			try {
				List<Event> events = game.move(d);
				for (Event e : events) {
					switch(e) {
					case BATS_NEARBY:
						out.print("*Chirping* There are bats nearby.\n");
						printAvailableDirections(out, game);
						break;
					case TRANSPORTED_BY_BATS:
						out.print("You were transported by Bats!\n");
						printAvailableDirections(out, game);
						break;
					case FALL_INTO_PIT:
						out.print("You fell to your death.\nGame over.\n");
						printAvailableDirections(out, game);
						break;

					default:
						printAvailableDirections(out, game);
					}
				}
			}
			catch (NoDoorException ndex) {
				out.print("Sorry there is no Door there.\n");
			}
			return this;
		}
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
	
	protected String trimTrailingComma(String s) {
		return s.substring(0, s.length() - 2);
	}

}
