import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WorldPopulation {

	SortStrategy sortStrategy;
	long[] population = new long[13484]; // Cheating because we know number of records!!
	// Lab Exercise:  After creating some strategy classes -- set the default strategy here.
	  
	public WorldPopulation(){
		sortStrategy = new SelectionSort(); // Set the default strategy here.	
	}
	
	public void readInputFile(){
		population = readPopulationFile("Lab1\\WorldPopulation.csv");
	}
	
	public void setStrategy(SortStrategy strategy){
		sortStrategy = strategy;
	}
	
	// Lab Exercise:  Read in the WorldPopulation.csv
	// Extract ONLY the numbers and store them into population[]
	public long[] readPopulationFile(String fileName){
		String line;
		int count=0;
		try {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		while ((line = br.readLine()) != null)   //returns a Boolean value  
		{  
			String[] popu=line.split(",");
			//System.out.println(popu[2]);
			population[count]=Long.parseLong(popu[2]);
			count++;
		} 
		}
		catch (IOException e)   
		{  
			e.printStackTrace();  
		}  
		return population;
	}
	
	// Lab Exercise.  Complete this method.
	// Delegate sorting to the strategy object
	public void sortPopulation(){	
		System.out.println(sortStrategy.strategyName());
		//System.out.println(sortStrategy.getSortTime());
		long startTime = System.currentTimeMillis();
		sortStrategy.sort(population);
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
	}
	
	public void computeTotalPopulation(){
		System.out.println("dd");
	}
	
	// Experiment with various strategies.
	// Create 3 strategies -- Bubble, insertion, and selection sort.
	public static void main(String[] args) {
		WorldPopulation worldPopulation = new WorldPopulation();
		SelectionSort ss=new SelectionSort();
		BubbleSort bs=new BubbleSort();
		InsertionSort is=new InsertionSort();
		worldPopulation.readInputFile();
		worldPopulation.setStrategy(is); 
		worldPopulation.sortPopulation();
		worldPopulation.setStrategy(bs); 
		worldPopulation.sortPopulation();
		worldPopulation.setStrategy(ss); 
		worldPopulation.sortPopulation();
	}

}