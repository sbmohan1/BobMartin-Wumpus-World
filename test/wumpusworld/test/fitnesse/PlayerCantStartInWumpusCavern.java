package wumpusworld.test.fitnesse;



import wumpusworld.Game;

public class PlayerCantStartInWumpusCavern extends CommonPlayerStartingPositionFixture {

	public void cavernWithWumpus(int x, int y) {
		Game game = new Game(worldMap);
		game.setWumpusLocation(x, y);
	}
}
