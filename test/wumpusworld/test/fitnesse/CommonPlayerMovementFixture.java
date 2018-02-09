package wumpusworld.test.fitnesse;

import java.awt.Point;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import wumpusworld.Game;
import wumpusworld.ui.ConsoleUI;

public class CommonPlayerMovementFixture extends CommonFixture {
	public static Game game;
	public static ConsoleUI consoleUI;
	public static PrintStream printStream;
	public static InputStream inputStream;
	public static ByteArrayOutputStream baos;
	public static int lineNumber;
	
	public void resetStatic() {
		super.resetStatic();
		game = null;
		consoleUI = null;
		printStream = null;
		inputStream = null;
		baos = null;
		lineNumber = 0;
	}
	
	public void setPlayerPosition(int x, int y) {
		if (consoleUI == null) {
			game = new Game(worldMap);
			baos = new ByteArrayOutputStream();
			printStream = new PrintStream(baos);
			consoleUI = new ConsoleUI(printStream, game);
		}
		game.setPlayerPosition(new Point(x, y));
		consoleUI.run();
	}
	
	public void setMove(String s) {
		if (s == null || s.isEmpty()) {
			return;
		}
		consoleUI.parseInput(s);
	}
	
	public String checkOutput() {
		baos.toString();
		String[] lines = baos.toString().split("\n");
		return lines[lineNumber++];
	}
}
