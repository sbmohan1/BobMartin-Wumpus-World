package wumpusworld.test.fitnesse;

import java.awt.Point;

import wumpusworld.Game;
import wumpusworld.Map;

public class PlayerFallsIntoPitTest extends CommonPlayerMovementFixture {

	protected static String movementDirection;
	protected static Point playerPos;
	
	public void resetStatic() {
		movementDirection = null;
		playerPos = null;
	}
	
	public void move(String s) {
		movementDirection = s;
		super.setMove(s);
	}
	
	public void setPlayerPosition(int x, int y) {
		playerPos = new Point(x, y);
		super.setPlayerPosition(x, y);
	}
	
	public void run(int times) {
		if(worldMap == null) {
			worldMap = new Map(width, height);
		}
		
		for(int i=0; i < times; i++) {
			super.setPlayerPosition(playerPos.x, playerPos.y);
			super.setMove(movementDirection);
		}
	}
}
