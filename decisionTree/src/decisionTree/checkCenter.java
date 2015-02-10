package decisionTree;

public class checkCenter {

	public checkCenter()
	{
		
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
