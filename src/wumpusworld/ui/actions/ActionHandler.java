package wumpusworld.ui.actions;

import java.io.PrintStream;

import wumpusworld.Game;

public interface ActionHandler {
	ActionHandler parseInput(String string, PrintStream out, Game game);
}
