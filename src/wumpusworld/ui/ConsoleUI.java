package wumpusworld.ui;

import java.io.PrintStream;
import java.util.List;

import wumpusworld.Direction;
import wumpusworld.Game;
import wumpusworld.NoDoorException;
import wumpusworld.ui.actions.ActionHandler;
import wumpusworld.ui.actions.DefaultActionHandler;

public class ConsoleUI {
	
	private PrintStream out;
	private Game game;
	private ActionHandler actionHandler;
	
	public ConsoleUI(PrintStream out, Game game) {
		this.out = out;
		this.game = game;
	}

	public void run() {
		DefaultActionHandler defaultActionHandler = new DefaultActionHandler();
		defaultActionHandler.printAvailableDirections(out, game);
		this.actionHandler = defaultActionHandler;
	}

	public void parseInput(String string) {
		actionHandler = actionHandler.parseInput(string, out, game);
	}

}
