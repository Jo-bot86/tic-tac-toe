package de.TicTacToe.game;

import grid.Game;

public class App {
	public static void main(String[] args) {
		Game game = new Game(3);
		game.print();
		game.startGame();
	}
}
