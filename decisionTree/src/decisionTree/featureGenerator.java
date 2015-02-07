package decisionTree;

import java.io.*;



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
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		
		br.close();
	}
	
	public static void main(String [] arg) throws IOException
	{
		String fileName = arg[0];
		featureGenerator fg = new featureGenerator();
		
		fg.generate(fileName);
	}
	
}
