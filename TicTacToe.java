package tictac;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		char board[][]= {{' ',' ',' '},
						{' ',' ',' '},
						{' ',' ',' '}};
		while(true) {
		humanChoice(board,sc);
		if(gameOver(board))
			break;
		printBoard(board);
		Random rd = new Random();
		compChoice(board, rd);
		if(gameOver(board))
			break;
		printBoard(board);
		}
		
		sc.close();

	}
	
	private static boolean hasWon(char[][] board,char sym) {
		if((board[0][0]==sym && board[0][1]==sym && board[0][2]==sym)||
		   (board[1][0]==sym && board[1][1]==sym && board[1][2]==sym)||
		   (board[2][0]==sym && board[2][1]==sym && board[2][2]==sym)||
		   
		   
		   (board[0][0]==sym && board[1][0]==sym && board[2][0]==sym)||
		   (board[0][1]==sym && board[1][1]==sym && board[2][1]==sym)||
		   (board[0][2]==sym && board[1][2]==sym && board[2][2]==sym)||
		   
		   (board[0][0]==sym && board[1][1]==sym && board[2][2]==sym)||
		   (board[0][2]==sym && board[1][1]==sym && board[2][0]==sym))
			return true;
		return false;
	}
	
	private static boolean gameOver(char[][] board) {
		
		if(hasWon(board,'X')) {
			System.out.println("Player Wins!!");
			printBoard(board);
			return true;
		}
		if(hasWon(board,'O')) {
			System.out.println("Computer Wins!!");
			printBoard(board);
			return true;
		}
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(board[i][j]==' ') {
					return false;
				}
			}
		}
		printBoard(board);
		System.out.println("The game ended in a tie!!");
		printBoard(board);
		return true;
	}

	private static void humanChoice(char[][] board,Scanner sc) {
		String s;
		while(true) {
			System.out.println("Where would you like to play? (1-9)");
			s=sc.nextLine();
			if(validSpace(board,s)) {
				break;
			}
		}
		Input(board,s,'X');
	}
	private static void compChoice(char[][] board, Random rd) {
		int comp;
		while(true) {
		comp=rd.nextInt(9)+1;
		if(validSpace(board,comp+""))
			break;
		}
		System.out.println("Computer chose :"+comp);
		Input(board,comp+"",'O');
	}


	private static boolean validSpace(char board[][],String p) {
		switch(p) {
		case "1":
			return(board[0][0]==' ');
		case "2":
			return(board[0][1]==' ');
		case "3":
			return(board[0][2]==' ');
		case "4":
			return(board[1][0]==' ');
		case "5":
			return(board[1][1]==' ');
		case "6":
			return(board[1][2]==' ');
		case "7":
			return(board[2][0]==' ');
		case "8":
			return(board[2][1]==' ');
		case "9":
			return(board[2][2]==' ');
		default:
			return false;
		}
	}
	private static void Input(char[][] board,String s,char sym) {
		switch(s) {
		case "1":
			board[0][0]=sym;
			break;
		case "2":
			board[0][1]=sym;
			break;
		case "3":
			board[0][2]=sym;
			break;
		case "4":
			board[1][0]=sym;
			break;
		case "5":
			board[1][1]=sym;
			break;
		case "6":
			board[1][2]=sym;
			break;
		case "7":
			board[2][0]=sym;
			break;
		case "8":
			board[2][1]=sym;
			break;
		case "9":
			board[2][2]=sym;
			break;
		default:
			System.out.println("Are you blind?!!");
		}
		
	}

	private static void printBoard(char[][] board) {
		System.out.println(board[0][0]+"|"+board[0][1]+"|"+board[0][2]);
		System.out.println("-"+"+"+"-"+"+"+"-");
		System.out.println(board[1][0]+"|"+board[1][1]+"|"+board[1][2]);
		System.out.println("-"+"+"+"-"+"+"+"-");
		System.out.println(board[2][0]+"|"+board[2][1]+"|"+board[2][2]);
	}

	}


