package main;

import lib.Algorithm;
import lib.Storage;
import java.io.BufferedReader;
import java.io.FileReader;

@SuppressWarnings("unused")
public class Engine {
  /* POSITION AND ENGINE VARIABLES */

  // Engine Object Variable:
  private static Algorithm engine = new Algorithm();

  // Othello Default Position Array:
  private static int position[] = {
    0, 0, 0, 0, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 0, 0, 0,
    0, 0, 0, 10, 20, 0, 0, 0,
    0, 0, 0, 20, 10, 0, 0, 0,
    0, 0, 0, 0, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 0, 0, 0
  };

  /* POSITION METHODS */
  
  // Constructor:
  public Engine() {}

  // Set Position Method:
  public static void setPosition(int input[]) throws Exception {
    // Sets the Value:
    position = input;
  }

  // Get Position Method:
  public static int[] getPosition() throws Exception {
    // Returns the Position:
    return position;
  }

  // Open Position Method:
  public static void openPosition(String fileName) throws Exception {
    // File Objects:
    BufferedReader br = new BufferedReader(new FileReader("book.csv"));
    
    try {
      // File Arrays:
      String line = br.readLine();
      String values[] = line.split(",");

      // Loops through Line:
      for (int i = 0; i < position.length; i++) {
        // Converts to Integer:
        position[i] = Integer.parseInt(values[i]);
      }
    }

    catch (Exception e) {
      // Print Stack Trace:
      e.printStackTrace();
    }

    // Closes the Reader:
    br.close();
  }

  /* ENGINE METHODS */

  // Get Engine Output Method:
  public static double getEngineOutput() throws Exception {
    // Sets the LocalPosition:
    double localPosition[] = new double[64];
    for (int i = 0; i < position.length; i++) {
      // Sets the Values:
      localPosition[i] = (double)(position[i]);
    }

    // Returns the Output:
    return engine.getOutput(localPosition);
  }

  // Get Engine Method:
  public static Algorithm getEngine() throws Exception {
    // Returns the Engine:
    return engine;
  }

  // Set Engine Method:
  public static void setEngine(String fileName) throws Exception {
    // Sets the Engine:
    engine = Storage.getNetwork(fileName);
  }
}