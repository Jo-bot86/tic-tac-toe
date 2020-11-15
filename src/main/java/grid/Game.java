package grid;

import java.util.Arrays;
import java.util.Scanner;
import field.Field;

/**
 * Represent the grid for tic-tac-toe which is a 2-dim Array of type Field.
 * actPlayer saves the integer value to identify the actual player.
 * 
 * @author Josef Weldemariam
 */
public class Game {

	private Field[][] grid;
	private int actPlayer;

	/**
	 * initialize grid with value 0 for an empty field
	 * 
	 * @param dim dimension of the grid
	 */
	public Game(int dim) {
		grid = new Field[dim][dim];
		for (int rowIndex = 0; rowIndex < dim; rowIndex++) {
			for (int colIndex = 0; colIndex < dim; colIndex++) {
				grid[rowIndex][colIndex] = new Field(rowIndex + 1, colIndex + 1, 0);
			}
		}
	}

	/**
	 * prints the grid
	 */
	public void print() {
		for (Field[] row : grid) {
			System.out.println(Arrays.deepToString(row));
		}
	}

	/**
	 * provide a certain field in the grid
	 * 
	 * @param rowIndex row index of a certain field
	 * @param colIndex column index of a certain field
	 */
	private Field getField(int rowIndex, int colIndex) {
		return this.grid[rowIndex - 1][colIndex - 1];
	}

	/**
	 * checks, if the grid has a free fields
	 * 
	 * @return true if every field in the grid is taken
	 */
	private boolean fullGrid() {
		for (int i = 1; i <= grid.length; i++) {
			for (int j = 1; j <= grid[0].length; j++) {
				if (getField(i, j).getValue() == 0) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * change the value for the actual player
	 */
	private void changePlayer() {
		if (actPlayer == 1) {
			this.actPlayer = 2;
		} else {
			this.actPlayer = 1;
		}
	}

	public void run1() {
		int rowIndex;
		int colIndex;
		int moveCounter = 0;
		Scanner inputMove = new Scanner(System.in);
	}
	/**
	 * 
	 */
	public void run() {
		int rowIndex;
		int colIndex;
		int moveCounter = 0;
		Scanner inputMove = new Scanner(System.in);
		while (true) {
			if (fullGrid() != true) {
				System.out.println("Player " + this.actPlayer + " please make your move");
				System.out.println("Enter the row index");
				rowIndex = inputMove.nextInt();
				System.out.println("Enter the column index");
				colIndex = inputMove.nextInt();
				if (rowIndex < 1) {
					System.out.println("rowIndex < 1, this is no legal move ");
				}
				else if (rowIndex > grid.length) {
					System.out.println("rowIndex > " + grid.length + " , this is no legal move ");
				}
				else if (colIndex < 1) {
					System.out.println("colIndex < 1, this is no legal move ");
				}
				else if (colIndex > grid[0].length) {
					System.out.println("colIndex > " + grid[0].length + " , this is no legal move ");
				}
				else if (rowIndex > 0 && rowIndex < grid.length + 1 && colIndex > 0 && colIndex < grid[0].length + 1) {
					if (getField(rowIndex, colIndex).getValue() == 0) {
						getField(rowIndex, colIndex).setValue(actPlayer);
						// Checks for winning position after 4 calls of changePlayer
						if (moveCounter >= 4 && winPosition(actPlayer) == true) {
							print();
							System.out.println("Player " + actPlayer + " wins the game");
							break;
						} else {
							changePlayer();
							moveCounter++;
							print();
						}
					} else {
						System.out.println("Sorry, but this field is already taken. Try again");
						// inputMove.close();
					}	
				}
			} else {
				System.out.println("Game over, draw");
				break;
			}
		}
	}

	/**
	 * reads the value for the start player and starts the game with calling
	 * nextMove
	 */
	public void startGame() {
		Scanner inputStart = new Scanner(System.in);
		while (true) {
			System.out.println("Does player 1 or 2 start?");
			int startPlayerValue = inputStart.nextInt();
			if (startPlayerValue != 1 && startPlayerValue != 2) {
				System.out.println("Just 1 or 2 is allowed. Try again.");
			} else {
				if (startPlayerValue == 1) {
					this.actPlayer = 1;
				} else {
					this.actPlayer = 2;
				}
			}
			break;
		}
		// inputStart.close();
		run();
	}

	/**
	 * checks the grid of three equal values in a row, column or diagonal
	 * 
	 * @param actPlayer value of the actual player
	 * @return returns true if the actual player has a winning position
	 */
	private boolean winPosition(int actPlayer) {
		for (int i = 1; i <= 3; i++) {
			// Checks the rows for winning position
			if (getField(i, 1).getValue() == actPlayer && getField(i, 2).getValue() == actPlayer
					&& getField(i, 3).getValue() == actPlayer) {
				return true;
			}
			// Checks the columns for winning position
			else if (getField(1, i).getValue() == actPlayer && getField(2, i).getValue() == actPlayer
					&& getField(3, i).getValue() == actPlayer) {
				return true;
			}
		}
		// Checks the diagonal from top left to button right for winning position
		if (getField(1, 1).getValue() == actPlayer && getField(2, 2).getValue() == actPlayer
				&& getField(3, 3).getValue() == actPlayer) {
			return true;
		}
		// Checks the diagonal from top right to button left for winning position
		else if (getField(1, 3).getValue() == actPlayer && getField(2, 2).getValue() == actPlayer
				&& getField(3, 1).getValue() == actPlayer) {
			return true;
		}
		return false;
	}
}
