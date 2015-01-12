import java.util.*;
public class TicTacToeBoard {
	private int[][] states = new int[3][3];

	//Get the position's state
	private int getState(int x, int y) {
		return states[x][y];
	}
	//Set the position as X or O
	public void setState(int x, int y, int value) {
		states[x][y] = value;
	}
	//Check if the row and col values are valid
	public boolean validPosition(int x, int y) {
		if(x < 0 || x > 2 || y < 0 || y > 2){
			return false;
		}
		if (getState(x, y) == 0) {
			return true;
		} else {
			return false;
		}
	}
	//Check if the game is tied
	public boolean isTie() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (states[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	//Check if there is a winner
	public int winner() {
		int win = 0;
		// three rows
		for (int row = 0; row < 3; row++) {
			if ((states[row][0] == states[row][1] && states[row][1] == states[row][2])
					&& states[row][0] != 0) {
				win = states[row][0];
			}
		}
		// three columns
		for (int col = 0; col < 3; col++) {
			if ((states[0][col] == states[1][col] && states[1][col] == states[2][col])
					&& states[0][col] != 0) {
				win = states[0][col];
			}
		}
		// left to right diagonal
		if (states[0][0] == states[1][1] && states[1][1] == states[2][2]
				&& states[0][0] != 0) {
			win = states[0][0];
		}
		// right to left diagonal
		if (states[2][0] == states[1][1] && states[1][1] == states[0][2]
				&& states[2][0] != 0) {
			win = states[2][0];
		}
		return win;
	}
	//Print game board
	public String toString() {
		String ans = "Game Board:\n";
		for (int row = 0; row < 3; row++) {
			ans += " | ";
			for (int col = 0; col < 3; col++) {
				if(states[row][col] == 0){
					ans += "   ";
				}
				if(states[row][col] == 1){
					ans += " X ";
				}
				if(states[row][col] == 2){
					ans += " O ";
				}	
			}
			ans += " |\n";
		}
		return ans;
	}				
}
