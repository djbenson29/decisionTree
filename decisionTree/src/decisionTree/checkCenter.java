/*
 * Daniel Benson djbenson@wpi.edu
 * Rafael Angelo rlangelo@wpi.edu
 * CS 4341 Project 3 Decision Trees
 * Professor Heffernan
 * 
 * This file contains our checkCenter class which analyzes the given board state and returns the 
 * number of our players pieces in the middle three rows of the board with the number of the opponents
 * pieces in those rows subtracted from it. This number is then returned as a feature
 */

package decisionTree;

public class checkCenter {

	public checkCenter()
	{
		// Empty constructor to instantiate this feature
	}
	
	public int totalCenter(int[][] board, int player, int width, int height)
	{
		int opp = (player == 1) ? 2 : 1;
		int totalPlayer = 0;
		int totalOpp = 0;
		
		for (int i=width/2-1; i<=width/2+1;i++){
			for (int j=0; j<height; j++){
				if (board[j][i] == player){
					totalPlayer++;
				}
				else if (board[j][i] == opp){
					totalOpp++;
				}
			}
		}
		return totalPlayer - totalOpp;
	}
}
