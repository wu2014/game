import java.util.*;
public class TicTacToe{
	public static void main (String[] args){
		Scanner console = new Scanner(System.in);
		System.out.println("Welcome! Tic-Tac-Toe is a two player game.");
		//Get players' names
		String[] players = new String[2];
		System.out.print("Enter player one's name: ");
		players[0] = console.next();
		System.out.print("Enter player two's name: ");
		players[1] = console.next();
		System.out.println();
		System.out.println("Players take turns marking a square. Only squares");
		System.out.println("not already marked can be picked. Once a player has");
		System.out.println("marked three squares in a row, he or she wins! If all squares");
		System.out.println("are marked and no three squares are the same, a tied game is declared.");
		System.out.println("Have Fun!");
		System.out.println();
		System.out.println();
		TicTacToeBoard board = new TicTacToeBoard();
		//Player 1 goes first
		int player = 0;
		while (!board.isTie() && board.winner() == 0){
			System.out.println(board.toString());	
			System.out.println("It is " + players[player] + "'s turn.");
			System.out.print("Pick a row between 1 and 3: ");
			int row = console.nextInt() - 1;
			System.out.print("Pick a column between 1 and 3: ");
			int col = console.nextInt() - 1;
			// Check if the input is valid
			while (!board.validPosition(row, col)) {
				System.out.println("ILLEGAL CHOICE! TRY AGAIN...");
				System.out.print("Pick a row between 1 and 3: ");
				row = console.nextInt() - 1;
				System.out.print("Pick a column between 1 and 3: ");
				col = console.nextInt() - 1;
			}
			board.setState(row, col, player + 1);
			//Change to another player (0 or 1)
			player = (player + 1) % 2;
		}
		
		//If we have a winner
		if (board.winner() != 0) {
			System.out.println(board.toString());
			System.out.print("Game Over - ");
			System.out.println(players[board.winner()-1] + " WINS!!!");
		} else if (board.isTie()){
			System.out.println(board.toString());
			System.out.println("Game is tied!");
		}
	}	
}
