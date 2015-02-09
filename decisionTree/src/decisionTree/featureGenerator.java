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
			checkOpposingTwos coTwo = new checkOpposingTwos();
			int feature1 = cTwo.totalTwo(board, 7, 6, 1);
			int feature2 = cThree.totalThree(board, 7, 6, 1);
			int feature3 = cCenter.totalCenter(board, 1, 7, 6);
			int feature4 = cFull.foursBoardFull(board, 1);
			int feature5 = coTwo.totalTwo(board, 7, 6, 1);
			System.out.println(feature1 + " ");
			System.out.println(feature2 + " ");
			System.out.println(feature3 + " ");
			System.out.println(feature4 + " ");
			System.out.println(feature5 + " ");
			if (i==0){
				deconstructBoard("output.csv", board, feature1, feature2, feature3, feature4, feature5, winner, true);
			}
			else{
				deconstructBoard("output.csv", board, feature1, feature2, feature3, feature4, feature5, winner, false);
			}
			System.out.println("\n");
			i++;
		}
		
		br.close();
	}
	
	// Turns a board back into a CSV readable file
	public void deconstructBoard(String fileName, int[][] board, int feature1, int feature2, int feature3, int feature4, 
			int feature5, String winner, boolean first) throws FileNotFoundException, IOException {
		outputFile = new File ("./" + fileName);
		if (first){
			if (outputFile.exists()){
				outputFile.delete();
			}
			if (!outputFile.exists()){
				outputFile.createNewFile();
			}
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile.getAbsoluteFile(), true));
		bw.write("s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23,s24,s25,s26,s27,s28,"
				+ "s29,s30,s31,s32,s33,s34,s35,s36,s37,s38,s39,s40,s41,s42,f1,f2,f3,f4,f5,winner\n");
		for (int i=0; i<7; i++){
			for (int j=0; j<6; j++){
				bw.write(board[j][i] + ",");
			}
		}
		bw.write(feature1 + "," + feature2 + "," + feature3 + "," + feature4 + "," + feature5 + "," + winner);
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
