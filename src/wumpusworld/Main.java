package wumpusworld;

import java.util.Scanner;

import wumpusworld.ui.ConsoleUI;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Map worldMap = new Map(4, 4);
		
		worldMap.addCavern(0, 0);
		worldMap.addCavern(1, 0);
		worldMap.addCavern(2, 0);
		worldMap.addCavern(3, 0);
		worldMap.addCavern(0, 1);
		worldMap.addCavern(1, 1);
		worldMap.addCavern(2, 1);
		worldMap.addBats(3, 1);
		worldMap.addCavern(0, 2);
		worldMap.addPit(1, 2);
		worldMap.addCavern(2, 2);
		worldMap.addCavern(3, 2);
		worldMap.addCavern(0, 3);
		worldMap.addCavern(1, 3);
		worldMap.addCavern(2, 3);
		worldMap.addCavern(3, 3);
		
		Game game = new Game(worldMap);
		game.setWumpusLocation(3, 3);
		
		printUsage();
		
		ConsoleUI consoleUI = new ConsoleUI(System.out, game);
		consoleUI.run();
		
		while (sc.hasNextLine()) {
			String input = sc.nextLine();
			consoleUI.parseInput(input);
		}
		
		sc.close();
	}

	private static void printUsage() {
		System.out.println("**********  Wumpus World  *********");
		System.out.println("\\                                 /");
		System.out.println("/    Enter direction to move.     \\");
		System.out.println("\\    Enter 'F' to fire arrows.    /");
		System.out.println("/    Enter 'R' to rest.           \\");
		System.out.println("\\                                 /");
		System.out.println("***********************************\n\n");
	}
}
