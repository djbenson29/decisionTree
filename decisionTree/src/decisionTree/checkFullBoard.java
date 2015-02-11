/*
 * Daniel Benson djbenson@wpi.edu
 * Rafael Angelo rlangelo@wpi.edu
 * CS 4341 Project 3 Decision Trees
 * Professor Heffernan
 * 
 * This file contains our checkFullBoard class which takes in a board state and then fills
 * all the currently empty spaces on the board with our players pieces. It then checks the board for the number of 
 * connect 4's. It then returns this number as a feature
 */

package decisionTree;

public class checkFullBoard {

	public checkFullBoard()
	{
		// Empty construtor to instantiate this feature
	}
	
	// Fills the board with our pieces
	public int foursBoardFull(int[][] board, int player)
	{
		int[][] tempBoard = new int[100][100];
		for (int i=0; i<7;i++)
		{
			for (int j=0;j<6;j++){
				tempBoard[i][j] = board[i][j];
			}
		}
		for (int i=0;i<7;i++)
		{
			for (int j=0;j<6;j++)
			{
				if (tempBoard[i][j] == 0)
				{
					tempBoard[i][j] = player;
				}
			}
		}
		int total = checkForFour(tempBoard, 7, 6, player);
		return total;
	}
	
	// checks horizaontally, vertically and diagonally for 4 in a row
	public int checkForFour(int[][] board, int width, int height, int player){
		int horizontal = checkForFourHorizontal(board, width, height, player);
		int vertical = checkForFourVertical(board, width, height, player);
		int dRight = nDiagonalRight(4, board, player, width, height, 4);
		int dLeft = nDiagonalLeft(4, board, player, height, width, 4);
		return horizontal + vertical + dRight + dLeft;
	}

	// This function checks for four vertical pieces of the same player in a row
	public int checkForFourVertical(int[][] board, int width, int height, int player){
		int max;
		int num = 0;
		for(int i=0;i<width;i++){
			max = 0;
			for(int j=0;j<height;j++){
				if (board[i][j] == player){
					max++;
				}
				else{
					max = 0;
				}
				if (max == 4){
					num++;
				}
			}
		}
		return num;
	}

	// This function checks for four pieces in a row horizontally of the same player 
	public int checkForFourHorizontal(int[][] board, int width, int height, int player){
		int max;
		int num = 0;
		for(int i=0;i<height;i++){
			max = 0;
			for(int j=0;j<width;j++){
				if (board[i][j] == player){
					max++;
				}
				else{
					max = 0;
				}
				if (max == 4){
					num++;
				}
			}
		}
		return num;
	}
	
	// This function checks for a given number of pieces in row diagonally of the same player
		int nDiagonalRight(int n, int[][] board, int playerNumber, int width, int height, int connectN){
			int max = 0;
			int num = 0;
			int opponentNumber = (playerNumber==1) ? 2 : 1;
			for(int i=0; i < (width-connectN); i++){
				for (int j=0; j<(height-connectN); j++){
					if (n == 2) {
						if(board[i][j] == playerNumber &&
								board[i+1][j+1] == playerNumber){
							num++;
						}
					}
					if (n == 3){
						if(board[i][j] == playerNumber &&
								board[i+1][j+1] == playerNumber &&
								board[i+2][j+2] == playerNumber){
							num++;
						}
					}
					if(n == 4){
						if(board[i][j] == playerNumber &&
								board[i+1][j+1] == playerNumber &&
								board[i+2][j+2] == playerNumber &&
								board[i+3][j+3] == playerNumber){
							num++;
						}
					}
				}
			}
			return num;
		}

		// This function checks for n pieces in a row diagonally of the same player
		int nDiagonalLeft(int n, int[][] board, int playerNumber, int height, int width, int connectN){
			int max = 0;
			int num = 0;
			int opponentNumber = (playerNumber==1) ? 2 : 1;
			for (int i=width; i < (width-connectN); i--) {
				for (int j=0; j<(height-connectN); j++) {
					if (n == 2) {
						if(board[i][j] == playerNumber &&
								board[i-1][j+1] == playerNumber){
							num++;
						}
					}
					if (n == 3){
						if(board[i][j] == playerNumber &&
								board[i-1][j+1] == playerNumber &&
								board[i-2][j+2] == playerNumber){
							num++;
						}
					}
					if(n == 4){
						if(board[i][j] == playerNumber &&
								board[i-1][j+1] == playerNumber &&
								board[i-2][j+2] == playerNumber &&
								board[i-3][j+3] == playerNumber){
							num++;
						}
					}
				}
			}
			return num;
		}
		
}
