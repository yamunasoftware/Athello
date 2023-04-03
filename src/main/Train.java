package main;

import lib.Training;
import lib.Algorithm;
import lib.Storage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class Train {
  /* TRAIN VARIABLES */

  // Training Settings:
  private static int inputLength = 64, nodes = 1000000, epochs = 10;
  private static double outputLength = 64, mutMin = 0.9, mutMax = 1.1;

  // Constructor:
  public Train() {}

  /* TRAIN METHODS */

  // Train Algorithm Method:
  public static Algorithm train(double inputs[][], double outputs[]) throws Exception {
    // Returns the Algorithm:
    Training training = new Training(inputLength, nodes, epochs, outputLength, mutMin, mutMax);
    return training.train(inputs, outputs);
  }

  // Train Existing Algorithm Method:
  public static Algorithm train(Algorithm existing, double inputs[][], double outputs[]) throws Exception {
    // Returns the Algorithm:
    Training training = new Training(existing, nodes, epochs, mutMin, mutMax);
    return training.train(inputs, outputs);
  }

  /* STORAGE METHODS */

  // Save Algorithm Method:
  public static void saveAlgorithm(Algorithm save, String fileName) throws Exception {
    // Saves the Algorithm:
    Storage.storeNetwork(save, fileName);
  }

  // Open Outputs:
  public static int[] openOutputs(String fileName) throws Exception {
    // File Objects:
    BufferedReader br = new BufferedReader(new FileReader("book.csv"));
    ArrayList<Integer> list = new ArrayList<Integer>();
    
    try {
      // File Arrays:
      String line = br.readLine();
      String values[] = line.split(",");

      // Loops through Line:
      for (int i = 0; i < values.length; i++) {
        // Converts to Integer:
        list.add(Integer.parseInt(values[i]));
      }
    }

    catch (Exception e) {
      // Print Stack Trace:
      e.printStackTrace();
    }

    // Closes the Reader:
    br.close();
    
    // Sets the Array:
    int outputs[] = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      // Sets the Outputs:
      outputs[i] = list.get(i);
    }
    return outputs;
  }

  // Open Positions Method:
  public static int[][] openPositions(String fileName) throws Exception {
    // File Objects:
    BufferedReader br = new BufferedReader(new FileReader("book.csv"));
    ArrayList<int[]> list = new ArrayList<int[]>();
    
    try {
      // Loops through File:
      String line;
      while ((line = br.readLine()) != null) {
        // File Arrays:
        String values[] = line.split(",");
        int position[] = new int[values.length];

        // Loops through Line:
        for (int i = 0; i < values.length; i++) {
          // Converts to Integer:
          position[i] = Integer.parseInt(values[i]);
        }
        list.add(position);
      }
    }

    catch (Exception e) {
      // Print Stack Trace:
      e.printStackTrace();
    }

    // Loops through List:
    int output[][] = new int[list.size()][64];
    for (int i = 0; i < list.size(); i++) {
      // Sets the Array:
      output[i] = list.get(i);
    }
    br.close();
    return output;
  }
}