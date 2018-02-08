package wumpusworld.test.junit.ui;

import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import wumpusworld.Game;
import wumpusworld.Map;
import wumpusworld.ui.ConsoleUI;

public class ConsoleUITest {
	@Test
	public void testUIDisplaysAvailableDirections() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		
		Map worldMap = new Map(3, 3);
		Game game = new Game(worldMap);
		game.setPlayerPosition(new Point(1, 1));
		
		InputStream is = IOUtils.toInputStream("\n");
		
		ConsoleUI console = new ConsoleUI(is, ps, game);
		
		assertEquals("Available directions: NWSE\n", baos.toString());
	}
	
	@Test
	public void testUIDisplaysAvailableDirections_CantMove() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		
		Map worldMap = new Map(1, 1);
		Game game = new Game(worldMap);
		game.setPlayerPosition(new Point(0, 0));
		
		InputStream is = IOUtils.toInputStream("\n");
		
		ConsoleUI console = new ConsoleUI(is, ps, game);
		
		assertEquals("No directions to move\n", baos.toString());
	}
	
	@Test
	public void testUIDisplaysAvailableNoEast() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		
		Map worldMap = new Map(3, 3);
		Game game = new Game(worldMap);
		game.setPlayerPosition(new Point(2, 1));
		
		InputStream is = IOUtils.toInputStream("\n");
		
		ConsoleUI console = new ConsoleUI(is, ps, game);
		
		assertEquals("Available directions: NWS\n", baos.toString());
	}
	
	@Test
	public void testUIDisplaysAvailable_AfterMoveToCenter() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		
		Map worldMap = new Map(4, 4);
		Game game = new Game(worldMap);
		game.setPlayerPosition(new Point(1, 1));
		
		InputStream is = IOUtils.toInputStream("E\n");
		
		ConsoleUI console = new ConsoleUI(is, ps, game);
		
		assertEquals("Available directions: NWSE\nAvailable directions: NWSE\n", baos.toString());
	}
	
	@Test
	public void testUIDisplaysAvailable_AfterMoveToLeftEdge() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		
		Map worldMap = new Map(3, 3);
		Game game = new Game(worldMap);
		game.setPlayerPosition(new Point(1, 1));
		
		InputStream is = IOUtils.toInputStream("W\n");
		
		ConsoleUI console = new ConsoleUI(is, ps, game);
		
		assertEquals("Available directions: NWSE\nAvailable directions: NSE\n", baos.toString());
	}
	
	@Test
	public void testUIDisplaysAvailable_AfterMoveToRightEdge() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		
		Map worldMap = new Map(3, 3);
		Game game = new Game(worldMap);
		game.setPlayerPosition(new Point(1, 1));
		
		InputStream is = IOUtils.toInputStream("E\n");
		
		ConsoleUI console = new ConsoleUI(is, ps, game);
		
		assertEquals("Available directions: NWSE\nAvailable directions: NWS\n", baos.toString());
	}
	
	@Test
	public void testUIDisplaysAvailable_AfterMoveToTopEdge() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		
		Map worldMap = new Map(3, 3);
		Game game = new Game(worldMap);
		game.setPlayerPosition(new Point(1, 1));
		
		InputStream is = IOUtils.toInputStream("N\n");
		
		ConsoleUI console = new ConsoleUI(is, ps, game);
		
		assertEquals("Available directions: NWSE\nAvailable directions: WSE\n", baos.toString());
	}
	
	@Test
	public void testUIDisplaysAvailable_AfterMoveToBottomEdge() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		
		Map worldMap = new Map(3, 3);
		Game game = new Game(worldMap);
		game.setPlayerPosition(new Point(1, 1));
		
		InputStream is = IOUtils.toInputStream("S\n");
		
		ConsoleUI console = new ConsoleUI(is, ps, game);
		
		assertEquals("Available directions: NWSE\nAvailable directions: NWE\n", baos.toString());
	}
}
