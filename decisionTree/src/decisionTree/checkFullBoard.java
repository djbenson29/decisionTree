package decisionTree;

public class checkFullBoard {

	public checkFullBoard()
	{
		
	}
	
	public int foursBoardFull(int[][] board, int player)
	{
		for (int i=0;i<7;i++)
		{
			for (int j=0;j<6;j++)
			{
				if (board[i][j] == 0)
				{
					board[i][j] = player;
				}
			}
		}
		int total = checkForFour(board, 7, 6, player);
		return total;
	}
	
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
			for(int i=width; i < (width-connectN); i--){
				for (int j=0; j<(height-connectN); j++){
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
