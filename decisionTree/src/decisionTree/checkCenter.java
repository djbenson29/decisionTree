package decisionTree;

public class checkCenter {

	public checkCenter()
	{
		
	}
	
	public int totalCenter(int[][] board, int player, int width, int height)
	{
		int total = 0;
		for (int i=width/2-1; i<=width/2+1;i++)
		{
			for (int j=0; j<height; j++)
			{
				if (board[j][i] == player)
				{
					total++;
				}
			}
		}
		return total;
	}
}
