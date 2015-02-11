/*
 * Daniel Benson djbenson@wpi.edu
 * Rafael Angelo rlangelo@wpi.edu
 * CS 4341 Project 3 Decision Trees
 * Professor Heffernan
 * 
 * This file contains our feature generator class which takes in a file 
 * and produces a CSV file that can be used to analyze our results in WEKA.
 */

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
		// Empty constructor to instantiate the class
	}
	
	// This function reads the file and creates the ouput file
	public void generate(String fileName) throws FileNotFoundException, IOException
	{
		inputFile = new File("./" + fileName);
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		int i = 0;
		int featureList[] = new int[30];
		int counter = 5;
		
		String line = null;
		int[][] board = new int[100][100];
		while ((line = br.readLine()) != null) {
			board = createBoard(board, line);
			//System.out.println(i);
			printBoard(board);
			checkForTwo cTwo = new checkForTwo();
			checkForThree cThree = new checkForThree();
			checkCenter cCenter = new checkCenter();
			checkFullBoard cFull = new checkFullBoard();
			checkOpposingTwos coTwo = new checkOpposingTwos();
			featureList[0] = cTwo.totalTwo(board, 7, 6, 1);
			featureList[1] = cThree.totalThree(board, 7, 6, 1);
			featureList[2] = cCenter.totalCenter(board, 1, 7, 6);
			featureList[3] = cFull.foursBoardFull(board, 1);
			featureList[4] = coTwo.totalTwo(board, 7, 6, 1);
//			System.out.println(featureList[0] + " ");
//			System.out.println(featureList[1] + " ");
//			System.out.println(featureList[2] + " ");
//			System.out.println(featureList[3] + " ");
//			System.out.println(featureList[4] + " ");
			
			for (int x=0; x<5; x++) {
				for (int y=0; y<5; y++) {
					int q = featureList[x];
					int p = featureList[y];
					featureList[counter] = q*p;
					//System.out.println("featureList[counter] = " + featureList[counter] + ". FeatureList[x] = "+ featureList[x] + " y = " + featureList[y]);
					counter++;
				}
			}
			
			counter = 5;
			
			if (i==0){
				deconstructBoard("output.csv", board, featureList, winner, true);
			}
			else{
				deconstructBoard("output.csv", board, featureList, winner, false);
			}
			System.out.println("\n");
			i++;
		}
		
		br.close();
	}
	
	// Turns a board back into a CSV readable file
	public void deconstructBoard(String fileName, int[][] board, int features[], String winner, boolean first) throws FileNotFoundException, IOException {
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
		// Write the column labels
		if (first){
			bw.write("s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23,s24,s25,s26,s27,s28,"
					+ "s29,s30,s31,s32,s33,s34,s35,s36,s37,s38,s39,s40,s41,s42,f1,f2,f3,f4,f5,f1*f1,f1*f2,f1*f3,f1*f4,f1*f5,"
					+ "f2*f1,f2*f2,f2*f3,f2*f4,f2*f5,f3*f1,f3*f2,f3*f3,f3*f4,f3*f5,f4*f1,f4*f2,f4*f3,f4*f4,f4*f5,"
					+ "f5*f1,f5*f2,f5*f3,f5*f4,f5*f5,winner\n");
		}
		
		// write the board values 
		for (int i=0; i<7; i++){
			for (int j=0; j<6; j++){
				bw.write(board[j][i] + ",");
			}
		}
		// write the feature values
		for (int i=0; i<29; i++){
			bw.write(features[i] + ",");
		}
		
		bw.write(winner);
		bw.write("\n");
		bw.close();
	}
	
	// This function takes in a line of input and constructs a board to be analyzed
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
	
	// This function prints the board for debugging purposes
	public void printBoard(int[][] board)
	{
		for (int i=5; i>=0; i--) {
			for (int j=0; j<7; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	
	// Main Function
	public static void main(String [] arg) throws IOException
	{
		String fileName = arg[0];
		featureGenerator fg = new featureGenerator();
		
		fg.generate(fileName);
		
	}
	
}
