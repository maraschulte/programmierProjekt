package backend;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;


public class graph {
	
	public static void saveFileAsGraph(Scanner obj) {
		String currentLine = obj.nextLine();
		
		//Skip unrelevant lines
		for (int i = 0; i < 5; i++) {
			currentLine = obj.nextLine();
		}
		System.out.println("Skipped unrelavent lines");
		
		//number of Nodes
		int numNodes = Integer.parseInt(currentLine);
		System.out.println("Number of nodes is: " + numNodes);
		currentLine = obj.nextLine();
		
		//number of Edges
		int numEdges = Integer.parseInt(currentLine);
		System.out.println("Number of nodes is: " + numEdges);
		currentLine = obj.nextLine();
		
		//Skip nodes
		for (int i = 0; i < numNodes; i++) {
			currentLine = obj.nextLine();
		}
		System.out.println("Skipped nodes");
		
		
		ArrayList<ArrayList<Double>> edgeList = new ArrayList<ArrayList<Double>>();
		int counter = 0;
		while (obj.hasNext()) {
			
			edgeList.add(addLineInEdgeList(currentLine));
			System.out.println(currentLine + " added to ArrayList");
			currentLine = obj.nextLine();
		}
		edgeList.add(addLineInEdgeList(currentLine));
		System.out.println(currentLine + " added to ArrayList");
		
		
		obj.close();
		System.out.println("Finished.");
	}

	

	private static ArrayList<Double> addLineInEdgeList(String currentLine) {
		//currentLine = srcIDX trgIDX cost type maxspeed
		double src;
		double trg;
		double weight;
		String srcString = "";
		String trgString = "";
		String costString = "";
		
		int i = 0;
		char c = currentLine.charAt(i);
		
		//Get src Node
		while (c != ' ') {
			srcString = srcString + c;
			i++;
			c = currentLine.charAt(i);
		}
		src = Double.parseDouble(srcString);
		
		// Get trg Node
		i++;
		c = currentLine.charAt(i);
		while (c != ' ') {
			trgString = trgString + c;
			i++;
			c = currentLine.charAt(i);
		}
		trg = Double.parseDouble(trgString);
		
		//Get cost
		i++;
		c = currentLine.charAt(i);
		while (c != ' ') {
			costString = costString + c;
			i++;
			c = currentLine.charAt(i);
		}
		weight = Double.parseDouble(costString);
		
		
		//Create List
		ArrayList<Double> edgeListInList = new ArrayList<Double>();
		edgeListInList.add(src);
		edgeListInList.add(trg);
		edgeListInList.add(weight);
		
		return edgeListInList;
	}



	public static void main(String[] args) throws Exception {
		File doc = new File("C:\\Users\\Mara\\Documents\\Uni\\ProgrammierprojektSS\\toy.txt");
		Scanner obj = new Scanner(doc);
		saveFileAsGraph(obj);
	}
}
