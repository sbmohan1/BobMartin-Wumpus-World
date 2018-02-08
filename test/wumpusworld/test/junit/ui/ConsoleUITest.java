package wumpusworld.test.junit.ui;

import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import wumpusworld.Game;
import wumpusworld.Map;
import wumpusworld.ui.ConsoleUI;

public class ConsoleUITest {
	private PrintStream printStream;
	private ByteArrayOutputStream baos;
	
	@Before
	public void setUp() {
		baos = new ByteArrayOutputStream();
		printStream = new PrintStream(baos);
	}

	@Test
	public void testUIDisplaysAvailableDirections() {
		
		Map worldMap = new Map(3, 3);
		Game game = new Game(worldMap);
		game.setPlayerPosition(new Point(1, 1));
		
		ConsoleUI console = new ConsoleUI(printStream, game);
		console.run();
		
		
		
		assertEquals("Available Directions are N, W, S, E.\n", baos.toString());
	}
	
	@Test
	public void testUIDisplaysAvailableDirections_CantMove() {
		
		Map worldMap = new Map(1, 1);
		Game game = new Game(worldMap);
		game.setPlayerPosition(new Point(0, 0));
		
		ConsoleUI console = new ConsoleUI(printStream, game);
		console.run();
		
		assertEquals("No directions to move\n", baos.toString());
	}
	
	@Test
	public void testUIDisplaysAvailableNoEast() {
		
		Map worldMap = new Map(3, 3);
		Game game = new Game(worldMap);
		game.setPlayerPosition(new Point(2, 1));
		
		ConsoleUI console = new ConsoleUI(printStream, game);
		console.run();
		
		
		
		assertEquals("Available Directions are N, W, S.\n", baos.toString());
	}
	
	@Test
	public void testUIDisplaysAvailable_AfterMoveToCenter() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		
		Map worldMap = new Map(4, 4);
		Game game = new Game(worldMap);
		game.setPlayerPosition(new Point(1, 1));
		
		ConsoleUI console = new ConsoleUI(ps, game);
		console.run();
		
		console.parseInput("E");
		
		assertEquals("Available Directions are N, W, S, E.\nAvailable Directions are N, W, S, E.\n", baos.toString());
	}
	
	@Test
	public void testUIDisplaysAvailable_AfterMoveToLeftEdge() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		
		Map worldMap = new Map(3, 3);
		Game game = new Game(worldMap);
		game.setPlayerPosition(new Point(1, 1));
		
		ConsoleUI console = new ConsoleUI(ps, game);
		console.run();
		
		console.parseInput("W");
		
		assertEquals("Available Directions are N, W, S, E.\nAvailable Directions are N, S, E.\n", baos.toString());
	}
	
	@Test
	public void testUIDisplaysAvailable_AfterMoveToRightEdge() {
		
		Map worldMap = new Map(3, 3);
		Game game = new Game(worldMap);
		game.setPlayerPosition(new Point(1, 1));
		
		ConsoleUI console = new ConsoleUI(printStream, game);
		console.run();
		
		console.parseInput("E");
		
		assertEquals("Available Directions are N, W, S, E.\nAvailable Directions are N, W, S.\n", baos.toString());
	}
	
	@Test
	public void testUIDisplaysAvailable_AfterMoveToTopEdge() {
		
		Map worldMap = new Map(3, 3);
		Game game = new Game(worldMap);
		game.setPlayerPosition(new Point(1, 1));
		
		ConsoleUI console = new ConsoleUI(printStream, game);
		console.run();
		
		console.parseInput("N");
		
		assertEquals("Available Directions are N, W, S, E.\nAvailable Directions are W, S, E.\n", baos.toString());
	}
	
	@Test
	public void testParseInput() {
		Map worldMap = new Map(3, 3);
		Game game = new Game(worldMap);
		game.setPlayerPosition(new Point(1, 1));
		
		ConsoleUI console = new ConsoleUI(printStream, game);
		console.run();
		
		console.parseInput("S");
		
		assertEquals("Available Directions are N, W, S, E.\nAvailable Directions are N, W, E.\n", baos.toString());
	}
}
