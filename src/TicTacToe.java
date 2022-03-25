import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;


public class TicTacToe {

	static ArrayList<Integer> playerPos= new ArrayList<>();
	static ArrayList<Integer> cpuPos= new ArrayList<>();
	
	public static void main(String[] args) {
		char [] [] gameBoard = { {' ','|',' ','|',' '},
				{'-','+','-','+','-'}, 
				{' ','|',' ','|',' '}, 
				{'-','+','-','+','-'}, 
				{' ','|',' ','|',' '}};
		
		
		while(true) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Your Position to Place. Choose From (1-9):");
			int n = sc.nextInt();
			
			while(playerPos.contains(n) || cpuPos.contains(n)) {
				System.out.println("The Position Is Already Taken. Please Enter Again:");
				n= sc.nextInt();
			}
			
			placeHolder("player",n, gameBoard);
			String result= checkWinner();
			if(result.length()>0) {
				System.out.println(result);
				break;
			}
			
			
			Random random= new Random();
			int cpuN= random.nextInt(9)+1;
			while(playerPos.contains(cpuN) || cpuPos.contains(cpuN)) {
				cpuN= random.nextInt(9)+1;
			}
			
			placeHolder("cpu",cpuN, gameBoard);
			printGameBoard(gameBoard);
			if(result.length()>0) {
				System.out.println(result);
				break;
			}
			
			
			result= checkWinner();
			
		}
		
	}
	public static void placeHolder(String user,int n, char[][] gameBoard) {
		
		char symbol=' ';
		if(user.equals("player")){
			symbol='X';
			playerPos.add(n);
		}else if(user.equals("cpu")) {
			symbol='O';
			cpuPos.add(n);
		}
		
		
		switch(n) {
			case 1:
				gameBoard[0][0] =symbol;
				break;
			case 2:
				gameBoard[0][2] =symbol;
				break;
			case 3:
				gameBoard[0][4] =symbol;
				break;
			case 4:
				gameBoard[2][0] =symbol;
				break;
			case 5:
				gameBoard[2][2] =symbol;
				break;
			case 6:
				gameBoard[2][4] =symbol;
				break;
			case 7:
				gameBoard[4][0] =symbol;
				break;
			case 8:
				gameBoard[4][2] =symbol;
				break;
			case 9:
				gameBoard[4][4] =symbol;
				break;
			default:
				break;
			}
	}
	public static void printGameBoard(char [] [] gameBoard) {
		for(char [] row: gameBoard) {
			for(char c : row) {
				System.out.print(c);
			}
			//For new line this Print is used
		System.out.println();
		}
	}
	public static String checkWinner() {
		
		List topRow= Arrays.asList(1, 2, 3);
		List midRow= Arrays.asList(4, 5, 6);
		List botRow= Arrays.asList(7, 8, 9);
		List leftCol= Arrays.asList(1, 4, 7);
		List midCol= Arrays.asList(2, 5, 9);
		List rightCol= Arrays.asList(3, 6, 9);
		
		List diagonalRight= Arrays.asList(3, 5, 7);
		List diagonalLeft= Arrays.asList(1, 5, 9);
		
		List <List> winPositions= new ArrayList<List>();
		winPositions.add(topRow);
		winPositions.add(midRow);
		winPositions.add(botRow);
		winPositions.add(leftCol);
		winPositions.add(midCol);
		winPositions.add(rightCol);
		winPositions.add(diagonalLeft);
		winPositions.add(diagonalRight);
		
		for(List l: winPositions) {
			if(playerPos.containsAll(l)) {
				return "You Won The Game. Cleared Level 1";
			}else if(cpuPos.containsAll(l)){
				return "You Lost. Cpu Is The Winner...!";
			}else if(playerPos.size() + cpuPos.size() == 9){
				return "OOPS! It Is A Tie";
			}
		}
		
		return "";
	}

}
