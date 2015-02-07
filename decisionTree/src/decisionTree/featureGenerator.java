package decisionTree;

import java.io.*;
import java.util.Arrays;
import java.util.List;



public class featureGenerator {

	File inputFile;
	File outputFile;
	
	public featureGenerator()
	{

	}
	
	public void generate(String fileName) throws FileNotFoundException, IOException
	{
		inputFile = new File("./" + fileName);
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		
		String line = null;
		int[][] board = new int[100][100];
		while ((line = br.readLine()) != null) {
			board = createBoard(board, line);
			printBoard(board);
			System.out.println("\n");
			deconstructBoard("./output.txt", board);
			System.out.println("\n");
		}
		
		br.close();
	}
	
	// Turns a board back into a CSV readable file
	public void deconstructBoard(String fileName, int[][] board) throws FileNotFoundException, IOException {
		outputFile = new File ("./" + fileName);
		BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
		
		for (int i=0; i<7; i++){
			for (int j=0; j<6; j++){
				System.out.print(board[j][i] + ",");
			}
		}
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
