package wumpusworld;

import java.util.Scanner;

import wumpusworld.ui.ConsoleUI;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Map worldMap = new Map(2, 2);
		
		worldMap.addCavern(0, 0);
		worldMap.addCavern(0, 1);
		worldMap.addCavern(1, 0);
		worldMap.addCavern(1, 1);
		
		Game game = new Game(worldMap);
		
		game.getPlayerPosition();
		
		ConsoleUI consoleUI = new ConsoleUI(System.out, game);
		
		consoleUI.run();
		
		while (sc.hasNextLine()) {
			String input = sc.nextLine();
			consoleUI.parseInput(input);
		}
		
		sc.close();
	}
}
