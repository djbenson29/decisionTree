package decisionTree;

import java.io.*;
import java.util.Arrays;
import java.util.List;



public class featureGenerator {

	File inputFile;
	File outputFile;
	String winner = "0";
	
	public featureGenerator()
	{

	}
	
	public void generate(String fileName) throws FileNotFoundException, IOException
	{
		inputFile = new File("./" + fileName);
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		int i = 0;
		
		String line = null;
		int[][] board = new int[100][100];
		while ((line = br.readLine()) != null) {
			board = createBoard(board, line);
			System.out.println(i);
			printBoard(board);
			checkForTwo cTwo = new checkForTwo();
			checkForThree cThree = new checkForThree();
			checkCenter cCenter = new checkCenter();
			checkFullBoard cFull = new checkFullBoard();
			int feature1 = cTwo.totalTwo(board, 7, 6, 1);
			int feature2 = cThree.totalThree(board, 7, 6, 1);
			int feature3 = cCenter.totalCenter(board, 1, 7, 6);
			int feature4 = cFull.foursBoardFull(board, 1);
			System.out.println(feature1 + " ");
			System.out.println(feature2 + " ");
			System.out.println(feature3 + " ");
			//System.out.println(feature4 + " ");
			deconstructBoard("output.txt", board, feature1, feature2, feature3, feature4, winner);
			System.out.println("\n");
			i++;
		}
		
		br.close();
	}
	
	// Turns a board back into a CSV readable file
	public void deconstructBoard(String fileName, int[][] board, int feature1, int feature2, int feature3, int feature4, String winner) throws FileNotFoundException, IOException {
		outputFile = new File ("./" + fileName);
		if (!outputFile.exists()){
			outputFile.createNewFile();
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile.getAbsoluteFile(), true));
		for (int i=0; i<7; i++){
			for (int j=0; j<6; j++){
				bw.write(board[j][i] + ",");
			}
		}
		bw.write(feature1 + "," + feature2 + "," + feature3 + "," + feature4 + "," + winner);
		bw.write("\n");
		bw.close();
	}
	
	public int[][] createBoard(int[][] board, String line)
	{
		List<String> ls = Arrays.asList(line.split(","));
		int counter = 0;
		for (int i=0;i<7;i++)
		{
			for (int j=0;j<6;j++)
			{
				board[j][i] = Integer.parseInt(ls.get(counter));
				counter++;
			}
		}
		winner = ls.get(ls.size() - 1);
		return board;
	}
	
	public void printBoard(int[][] board)
	{
		for (int i=5; i>=0; i--) {
			for (int j=0; j<7; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	
	public static void main(String [] arg) throws IOException
	{
		String fileName = arg[0];
		featureGenerator fg = new featureGenerator();
		
		fg.generate(fileName);
		
	}
	
}
