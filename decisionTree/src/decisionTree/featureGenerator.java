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
		int i = 0;
		
		String line = null;
		int[][] board = new int[100][100];
		while ((line = br.readLine()) != null) {
			board = createBoard(board, line);
			System.out.println(i);
			printBoard(board);
			deconstructBoard("output.txt", board);
			System.out.println("\n");
			i++;
		}
		
		br.close();
	}
	
	// Turns a board back into a CSV readable file
	public void deconstructBoard(String fileName, int[][] board) throws FileNotFoundException, IOException {
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
