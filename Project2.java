package proj2;
import java.util.Scanner;
public class Project2 {

	private static boolean validBoard(int rows, int columns){
		if (rows * columns < 25){
			return false;
		}
		else{
			return true;
		}
	}
	private static void exiting(String num){
		if (num.equals("q") || num.equals("Q")){
			System.out.print("Exiting...");
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		
		int winner = 0;
		int exit = 0;
		String replay = "";
		String playAgain = "NO";
		
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to ConnectFour!  At any time you may press Q to exit!\n");
		System.out.print("Please enter player one's name: ");
		String name1 = input.next();
		
		System.out.print("Please enter player two's name: ");
		String name2 = input.next();
		
		System.out.print("How many rows would you like? ");
		int rows = input.nextInt();
		
		System.out.print("How many columns would you like? ");
		int columns = input.nextInt();
		
		while (!validBoard(rows, columns)){
			System.out.println("Invaild connect four board size!");
			System.out.print("How many rows would you like? ");
			rows = input.nextInt();
			
			System.out.print("How many columns would you like? ");
			columns = input.nextInt();
		}
		
		ConnectFour board = new ConnectFour(rows, columns);
		System.out.println(board.toString());
		
		while(exit == 0){
			
			if (!board.winConditionMet(Move.PLAYER2)){
				System.out.print(name1 + ", where would you like to move?");
				String move1 = input.next();
				exiting(move1);
				board.placeInColumn(Integer.parseInt(move1), Move.PLAYER1);
				System.out.println(board.toString());
			}
			else{
				System.out.print(name2 + " wins!!!");
				System.out.print("Would you like the play another game? (y / n) ");
				replay = input.next();
				if (replay.equals("n")){
					exit = 1;
					}
				else{
					board = new ConnectFour(rows, columns);
				}
			if (!board.winConditionMet(Move.PLAYER1)){
				System.out.print(name2 + ", where would you like to move?");
				String move2 = input.next();
				exiting(move2);
				board.placeInColumn(Integer.parseInt(move2), Move.PLAYER2);
				System.out.println(board.toString());
			}
			else{
				System.out.print(name2 + " wins!!!");
				System.out.print("Would you like the play another game? (y / n) ");
				replay = input.next();
				if (replay.equals("n")){
						exit = 1;
						}
					else{
						board = new ConnectFour(rows, columns);
			}
		}
			
		}
		
	}}}

	
