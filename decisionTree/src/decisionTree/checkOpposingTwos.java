package decisionTree;

public class checkOpposingTwos {

	public checkOpposingTwos()
	{
		
	}
	
	public int totalTwo(int[][] board, int width, int height, int player){
		int oppositePlayer = 0;
		if (player==1){
			oppositePlayer = 2;
		}
		else{
			oppositePlayer = 1;
		}
		int horizontal = checkForTwoHorizontal(board, width, height, player);
		int vertical = checkForTwoVertical(board, width, height, player);
		int dRight = nDiagonalRight(2, board, player, width, height, 2);
		int dLeft = nDiagonalLeft(2, board, player, width, height, 2);
		int total = horizontal + vertical + dRight + dLeft;
		int oppHorizontal = checkForTwoHorizontal(board, width, height, oppositePlayer);
		int oppVertical = checkForTwoVertical(board, width, height, oppositePlayer);
		int oppDRight = nDiagonalRight(2, board, oppositePlayer, width, height, 2);
		int oppDLeft = nDiagonalLeft(2, board, oppositePlayer, width, height, 2);
		int oppositeTotal = oppHorizontal + oppVertical + oppDRight + oppDLeft;
		return total - oppositeTotal;
	}

	// This function checks for two pieces in a row horizontally of the same player
	public int checkForTwoHorizontal(int[][] board, int width, int height, int player){
		int num = 0;
		int max;
		for(int i=0;i<height;i++){
			max = 0;
			for (int j=0;j<width;j++){
				if(board[i][j] == player){
					max++;
				}
				else{
					max = 0;
				}
				if (max == 2){
					num++;
					max = 0;
				}
			}
		}
		return num;
	}

	// This function checks for two pieces in a row vertically of the same player
	public int checkForTwoVertical(int[][] board, int width, int height, int player){
		int num = 0;
		int max;
		for (int i=0;i<width;i++){
			max = 0;
			for (int j=0;j<height;j++){
				if (board[j][i] == player){
					max++;
				}
				else{
					max = 0;
				}
				if (max == 2)
				{
					num++;
					max = 0;
				}
			}
		}
		return num;
	}

	// This function checks for a given number of pieces in row diagonally of the same player
	int nDiagonalRight(int n, int[][] board, int playerNumber, int width, int height, int connectN){
		//int max = 0;
		int num = 0;
		//int opponentNumber = (playerNumber==1) ? 2 : 1;
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
	int nDiagonalLeft(int n, int[][] board, int playerNumber, int width, int height, int connectN){
		//int max = 0;
		int num = 0;
		//int opponentNumber = (playerNumber==1) ? 2 : 1;
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
