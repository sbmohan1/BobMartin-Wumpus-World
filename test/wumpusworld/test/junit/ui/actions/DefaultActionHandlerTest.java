package wumpusworld.test.junit.ui.actions;

import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import wumpusworld.Game;
import wumpusworld.Map;
import wumpusworld.ui.actions.ActionHandler;
import wumpusworld.ui.actions.ArcherActionHandler;
import wumpusworld.ui.actions.DefaultActionHandler;

public class DefaultActionHandlerTest {
	
	private PrintStream printStream;
	private ByteArrayOutputStream baos;
	
	@Before
	public void setUp() {
		baos = new ByteArrayOutputStream();
		printStream = new PrintStream(baos);
	}
	
	@Test
	public void testArcherActionHandlerReturned() {
		Map worldMap = new Map(3, 3);
		
		worldMap.addCavern(0, 0);
		worldMap.addCavern(0, 1);
		worldMap.addCavern(0, 2);
		worldMap.addCavern(1, 0);
		worldMap.addCavern(1, 1);
		worldMap.addCavern(1, 2);
		worldMap.addCavern(2, 0);
		worldMap.addCavern(2, 1);
		worldMap.addCavern(2, 2);
		
		Game game = new Game(worldMap);
		game.setPlayerPosition(new Point(2, 1));
		
		DefaultActionHandler actionHandler = new DefaultActionHandler();
		ActionHandler newHandler = actionHandler.parseInput("F", printStream, game);
		assertEquals("Available Directions to Fire Arrows are N, W, S. Which Direction do you want to shoot?\n", baos.toString());
		assertEquals(ArcherActionHandler.class, newHandler.getClass());
	}
}
