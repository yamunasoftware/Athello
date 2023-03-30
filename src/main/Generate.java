package main;

import java.io.FileWriter;
import com.opencsv.CSVWriter;

@SuppressWarnings("unused")
public class Generate {
  /* POSITION DEFINITION VARIABLES */

  // Position Type Enum:
  public enum Type {
    RANDOM,
    DEFINED
  }

  /* POSITION GENERATION METHODS */

  // Constructor:
  public Generate() {}

  // Generate Positions Method:
  public static int[][] generatePositions(int number, int defined[], Type positionType) throws Exception {
    // Positions Array:
    int positions[][] = new int[number][64];

    // Loops through List:
    for (int i = 0; i < number; i++) {
      // Checks the Case:
      if (positionType == Type.RANDOM) {
        // Adds the Position:
        positions[i] = generatePosition();
      }

      else if (positionType == Type.DEFINED) {
        // Adds the Position:
        positions[i] = generateDefinedPosition(defined);
      }
    }

    // Returns the Positions:
    return positions;
  }

  // Generate Defined Position Method:
  public static int[] generateDefinedPosition(int defined[]) throws Exception {
    // Position Values:
    int position[] = defined;
    int possibles[] = {0, 10, 20};

    // Loops through Array:
    for (int i = 0; i < position.length; i++) {
      // Checks the Case:
      if (position[i] == 0) {
        // Sets the Value:
        int index = (int)(Math.random() * possibles.length);
        int value = possibles[index];
        position[i] = value;
      }
    }

    // Returns the Position:
    return position;
  }

  // Generate Position Method:
  public static int[] generatePosition() throws Exception {
    // Position Values:
    int position[] = new int[64];
    int possibles[] = {0, 10, 20};

    // Loops through Array:
    for (int i = 0; i < position.length; i++) {
      // Sets the Value:
      int index = (int)(Math.random() * possibles.length);
      int value = possibles[index];
      position[i] = value;
    }

    // Returns the Position:
    return position;
  }

  /* SAVE METHODS */

  // Save Positions Method:
  public static void savePositions(String fileName, int positions[][]) throws Exception {
    // Loops through Array:
    for (int i = 0; i < positions.length; i++) {
      // Saves the Position:
      savePosition(fileName, positions[i]);
    }
  }

  // Save Position Method:
  public static void savePosition(String fileName, int position[]) throws Exception {
    // Sets the Writers:
    FileWriter outputFile = new FileWriter(fileName);
    CSVWriter writer = new CSVWriter(outputFile);
    
    // Sets the String Array:
    String localPosition[] = new String[position.length];
    for (int i = 0; i < position.length; i++) {
      // Sets the Value:
      localPosition[i] = Integer.toString(position[i]);
    }
    
    // Writes and Closes:
    writer.writeNext(localPosition);
    writer.close();
  }
}