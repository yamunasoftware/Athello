package main;

import main.Generate.Type;

@SuppressWarnings("unused")
public class Tests {
  // Constructor:
  public Tests() {}

  // Test Train Method:
  public static void testTrain(int positions, String positionsFile, String bestsFile, String engineFile) throws Exception {
    // Test Position Random Generation:
    int generated[][] = Generate.generatePositions(positions, null, Type.RANDOM);
    Generate.savePositions(positionsFile, generated);

    /* LABEL THE BEST MOVES IN THE BESTS FILE */

    // Gets the Data:
    int tempInputs[][] = Train.openPositions(positionsFile);
    int tempOutputs[] = Train.openOutputs(bestsFile);

    // Conversion Arrays:
    double inputs[][] = new double[tempInputs.length][64];
    double outputs[] = new double[tempOutputs.length];

    // Converts the Input Data:
    for (int i = 0; i < tempInputs.length; i++) {
      for (int j = 0; j < 64; j++) {
        // Sets the Values:
        inputs[i][j] = (double)(tempInputs[i][j]);
      }
    }

    // Converts the Output Data:
    for (int i = 0; i < tempOutputs.length; i++) {
      // Sets the Values:
      outputs[i] = (double)(tempOutputs[i]);
    }

    // Trains and Saves the Engine:
    Train.saveAlgorithm(Train.train(inputs, outputs), engineFile);
  }

  // Test Engine Method:
  public static double testEngine(String engineFile, String positionFile) throws Exception {
    // Sets the Engine and Position:
    Engine.setEngine(engineFile);
    Engine.openPosition(positionFile);
    return Engine.getEngineOutput();
  }
}