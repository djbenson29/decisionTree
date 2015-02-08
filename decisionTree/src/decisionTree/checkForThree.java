package decisionTree;

public class checkForThree {

	// This function checks for three in a row of all varieties
	public int totalThree(int[][] board, int width, int height, int player){
		int horizontal = checkForThreeHorizontal(board, width, height, player);
		int vertical = checkForThreeVertical(board, width, height, player);
		int dRight = nDiagonalRight(3, board, player, width, height, 4);
		int dLeft = nDiagonalLeft(3, board, player, height, width, 4);
		return horizontal + vertical + dRight + dLeft;
	}

	// This function checks for three pieces in a row vertically of the same player
	public int checkForThreeVertical(int[][] board, int width, int height, int player){
		int num = 0;
		int max;
		int spaces = 0;
		for(int i=0;i<width;i++){
			max = 0;
			for(int j=0;j<height;j++){
				if(board[i][j] == player && spaces == 1){
					max++;
					spaces = 0;
				}
				else if(board[i][j] == player){
					max++;
				}
				else if(board[i][j] == 9 && spaces == 0){
					spaces++;
				}
				else{
					max = 0;
				}
				if (max == 3){
					num++;
					max = 0;
				}
			}
		}
		return num;
	}

	// This function checks for three pieces in a row horizonatally of the same player
	public int checkForThreeHorizontal(int[][] board, int width, int height, int player){
		int num = 0;
		int max;
		int spaces = 0;
		for(int i=0;i<height;i++){
			max = 0;
			for(int j=0;j<width;j++){
				if (board[i][j] == player && spaces == 1){
					max++;
					spaces = 0;
				}
				else if (board[i][j] == player){
					max++;
				}
				else if (board[i][j] == 9 && spaces == 0){
					spaces++;
				}
				else{
					max = 0;
				}
				if (max == 3){
					num++;
					max = 0;
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
