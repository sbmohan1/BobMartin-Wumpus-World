package wumpusworld;

import java.awt.Point;
import java.util.List;

public class PlayerPositionStrategy {

	public Point getPoint(Game game) {
		List<Point> caverns = game.getWorldMap().getCaverns();
		filterWumpus(game, caverns);
		if (caverns.isEmpty()) {
			throw new RuntimeException();
		}
		int offset = (int)(Math.random() * caverns.size());
		return caverns.get(offset);
	}

	private void filterWumpus(Game game, List<Point> caverns) {
		Point wumpusLocation = game.getWumpusLocation();
		for (Direction d : Direction.values()) {
			caverns.remove(d.getPoint(wumpusLocation));
		}
		caverns.remove(game.getWumpusLocation());
	}

}
