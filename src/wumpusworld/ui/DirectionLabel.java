package wumpusworld.ui;

import wumpusworld.Direction;

public enum DirectionLabel {
	N(Direction.NORTH, "N"),
	W(Direction.WEST, "W"),
	S(Direction.SOUTH, "S"),
	E(Direction.EAST, "E");
	
	public final String label;
	private Direction direction;
	
	private DirectionLabel(Direction direction, String label) {
		this.direction = direction;
		this.label = label;
	}
	
	public static DirectionLabel findByDirection(Direction d) {
		for (DirectionLabel label : values()) {
			if (label.direction.equals(d)) {
				return label;
			}
		}
		return null;
	}
	
	public static Direction findByLabel(String label) {
		for (DirectionLabel directionLabel : values()) {
			if (directionLabel.label.equalsIgnoreCase(label)) {
				return directionLabel.direction;
			}
		}
		return null;
	}
}