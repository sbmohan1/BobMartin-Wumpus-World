package wumpusworld.test.fitnesse;

import java.awt.Point;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringBufferInputStream;

import org.apache.commons.io.IOUtils;

import wumpusworld.Game;
import wumpusworld.ui.ConsoleUI;

public class PlayerCanMove extends CommonPlayerStartingPositionFixture {

	public static Game game;
	public static ConsoleUI consoleUI;
	public static PrintStream printStream;
	public static InputStream inputStream;
	public static ByteArrayOutputStream baos;
	public static int lineNumber;
	
	public void setPlayerPosition(int x, int y) {
		if (consoleUI == null) {
			game = new Game(CommonPlayerStartingPositionFixture.worldMap);
			baos = new ByteArrayOutputStream();
			printStream = new PrintStream(baos);
			consoleUI = new ConsoleUI(printStream, game);
		}
		game.setPlayerPosition(new Point(x, y));
		consoleUI.run();
	}
	
	public void setMove(String s) {
		consoleUI.parseInput(s);
	}
	
	public String checkOutput() {
		String[] lines = baos.toString().split("\n");
		return lines[++lineNumber];
	}
}
