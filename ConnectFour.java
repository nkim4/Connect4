package proj2;

import java.util.Arrays;
import java.util.Scanner;

public class ConnectFour {

	Move[][] board;
	int columns;
	int rows;
	/**
	 * @param args
	 */	
	public ConnectFour(int rows, int columns){
		
		this.board = makeDefaultBoard(rows, columns);
		this.rows = board.length;
		this.columns = board[0].length;
		Move player1 = Move.PLAYER1;
		Move player2 = Move.PLAYER2;
	}
	public int getRows(){
		return rows;
	}
	public int getColumns(){
		return columns;
	}
	private static Move[][] makeDefaultBoard(int rows, int columns){
		
		Move[][] board = new Move[rows][columns];
		for (Move[] xboard: board){
			Arrays.fill(xboard, Move.EMPTY);
		}
		return board;
	}
	
	public String toString(){
		
		String finalString = "";
		
		for (int i = 0; i <= this.rows - 1; i++){
			String stringBoard = "";
			for (int j = 0; j <= this.columns - 1; j++){
				stringBoard = stringBoard + board[i][j].getSymbol();
			}
			finalString = stringBoard + "\n" + finalString;
		}
		return finalString;
	}
	
	public void placeInColumn(int column, Move player){
		
		for (int i = 0; i <= this.rows - 1 ; i++){
			if(this.board[i][column].getSymbol().equals("_")){
				this.board[i][column] = player;
				break;			}
		}
	}
	public boolean winConditionMet(Move player){
		if (this.checkRow(player)){
			return true;
		}
		else if (this.checkColumn(player)){
			return true;
		}
		else if (this.checkLeftDiagonal(player)){
			return true;
		}
		else if (this.checkRightDiagonal(player)){
			return true;
		}
		else{
			return false;
		}
	}
	private boolean checkRow(Move player){
		for (int i = 0; i < this.getColumns() - 3; i++){
			for (int j = 0; j < this.getRows(); j++){
				if (board[j][i].getSymbol().equals(player.getSymbol())
					&& board[j][i + 1].getSymbol().equals(player.getSymbol())
					&& board[j][i + 2].getSymbol().equals(player.getSymbol())
					&& board[j][i + 3].getSymbol().equals(player.getSymbol())){
					return true;
				}
			}
		}
		return false;
	}
	private boolean checkColumn(Move player){
		for (int i = 0; i < this.getRows() - 3; i++){
			for (int j = 0; j < this.getColumns(); j++){
				if (board[i][j].getSymbol().equals(player.getSymbol())
					&& board[i + 1][j].getSymbol().equals(player.getSymbol())
					&& board[i + 2][j].getSymbol().equals(player.getSymbol())
					&& board[i + 3][j].getSymbol().equals(player.getSymbol())){
					return true;
				}
			}
		}
		return false;
	}
	private boolean checkLeftDiagonal(Move player){
		for (int i = 0; i < this.getRows() - 3; i++){
			for (int j = 0; j < this.getColumns() - 3; j++){
				if (board[i][j].getSymbol().equals(player.getSymbol())
					&& board[i + 1][j + 1].getSymbol().equals(player.getSymbol())
					&& board[i + 2][j + 2].getSymbol().equals(player.getSymbol())
					&& board[i + 3][j + 3].getSymbol().equals(player.getSymbol())){
					return true;
				}
			}
		}
		return false;
	}
	private boolean checkRightDiagonal(Move player){
		for (int i = 0; i < this.getRows() - 3; i++){
			for (int j = 3; j < this.getColumns(); j++){
				if (board[i][j].getSymbol().equals(player.getSymbol())
					&& board[i + 1][j - 1].getSymbol().equals(player.getSymbol())
					&& board[i + 2][j - 2].getSymbol().equals(player.getSymbol())
					&& board[i + 3][j - 3].getSymbol().equals(player.getSymbol())){
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args){
		
		ConnectFour testBoard;
		Scanner input = new Scanner(System.in);
		
		System.out.println("1 - Test the toString and makeDefaultBoard method");
		System.out.println("2 - Tests placement of pieces on the board\n    (places 3 pieces to see if they stack and to see if the location is accurate)");
		System.out.println("3 - Tests the winConditionMet method 4 vertically");
		System.out.println("4 - Tests the winConditionMet method 4 horizontally");
		System.out.println("5 - Tests the winConditionMet method 4 left diagonal");
		System.out.println("6 - Tests the winConditionMet method 4 right diagonal");
		System.out.println("7 - Tests the winConditionMet method only 3");
		int choice = input.nextInt();
		
		switch (choice){
		
		case 1:{
			testBoard = new ConnectFour(8, 12);
			System.out.print(testBoard.toString());
		}
		break;
		case 2:{
			testBoard = new ConnectFour(8, 12);
			testBoard.placeInColumn(2, Move.PLAYER1);
			System.out.print(testBoard.toString());
			testBoard.placeInColumn(2, Move.PLAYER2);
			System.out.println(testBoard.toString());
			testBoard.placeInColumn(3, Move.PLAYER1);
			System.out.println(testBoard.toString());
			
			}
		break;
		case 3:{
			testBoard = new ConnectFour(8, 12);
			testBoard.placeInColumn(11, Move.PLAYER2);
			testBoard.placeInColumn(11, Move.PLAYER2);
			testBoard.placeInColumn(11, Move.PLAYER2);
			testBoard.placeInColumn(11, Move.PLAYER2);
			testBoard.placeInColumn(11, Move.PLAYER1);
			testBoard.placeInColumn(11, Move.PLAYER1);
			testBoard.placeInColumn(11, Move.PLAYER1);
			testBoard.placeInColumn(11, Move.PLAYER1);
			System.out.print(testBoard.toString() + "\n");
			System.out.println(testBoard.winConditionMet(Move.PLAYER1));
		}
		break;
		case 4:{
			testBoard = new ConnectFour(8, 12);
			testBoard.placeInColumn(0, Move.PLAYER1);
			testBoard.placeInColumn(1, Move.PLAYER1);
			testBoard.placeInColumn(2, Move.PLAYER1);
			testBoard.placeInColumn(3, Move.PLAYER1);
			System.out.print(testBoard.toString() + "\n");
			System.out.println(testBoard.winConditionMet(Move.PLAYER1));
		}
		break;
		case 5:{
			testBoard = new ConnectFour(8, 12);
			testBoard.placeInColumn(0, Move.PLAYER2);
			testBoard.placeInColumn(0, Move.PLAYER2);
			testBoard.placeInColumn(0, Move.PLAYER2);
			testBoard.placeInColumn(1, Move.PLAYER2);
			testBoard.placeInColumn(1, Move.PLAYER2);
			testBoard.placeInColumn(2, Move.PLAYER2);
			testBoard.placeInColumn(0, Move.PLAYER1);
			testBoard.placeInColumn(1, Move.PLAYER1);
			testBoard.placeInColumn(2, Move.PLAYER1);
			testBoard.placeInColumn(3, Move.PLAYER1);
			System.out.print(testBoard.toString() + "\n");
			System.out.println(testBoard.winConditionMet(Move.PLAYER1));		
		}
		break;
		case 6:{
			testBoard = new ConnectFour(8, 12);
			testBoard.placeInColumn(3, Move.PLAYER2);
			testBoard.placeInColumn(1, Move.PLAYER2);
			testBoard.placeInColumn(2, Move.PLAYER2);
			testBoard.placeInColumn(2, Move.PLAYER2);
			testBoard.placeInColumn(3, Move.PLAYER2);
			testBoard.placeInColumn(3, Move.PLAYER2);
			testBoard.placeInColumn(0, Move.PLAYER1);
			testBoard.placeInColumn(1, Move.PLAYER1);
			testBoard.placeInColumn(2, Move.PLAYER1);
			testBoard.placeInColumn(3, Move.PLAYER1);
			System.out.print(testBoard.toString() + "\n");
			System.out.println(testBoard.winConditionMet(Move.PLAYER1));
		}
		break;
		case 7:{
			testBoard = new ConnectFour(8, 12);
			testBoard.placeInColumn(1, Move.PLAYER1);
			testBoard.placeInColumn(2, Move.PLAYER1);
			testBoard.placeInColumn(3, Move.PLAYER1);
			System.out.print(testBoard.toString() + "\n");
			System.out.println(testBoard.winConditionMet(Move.PLAYER1));
		}
		break;
	}
	}	
}
		
	


