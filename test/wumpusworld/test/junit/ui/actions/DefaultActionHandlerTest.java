package wumpusworld.test.junit.ui.actions;

import org.junit.Test;

import wumpusworld.ui.actions.ActionHandler;
import wumpusworld.ui.actions.DefaultActionHandler;

public class DefaultActionHandlerTest {
	@Test
	public void testArcherActionHandlerReturned() {
		DefaultActionHandler actionHandler = new DefaultActionHandler();
		ActionHandler newHandler = actionHandler.parseInput("F", null, null);
		actionHandler.getClass().equals(ArcherActionHandler.class);
		
	}
}
