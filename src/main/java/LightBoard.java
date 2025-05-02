public class LightBoard
{
  
  private boolean[][] lights;

  public LightBoard(int numRows, int numCols)
  {
    lights = new boolean[numRows][numCols];
    for (int r = 0; r < numRows; r++) {
      for (int c = 0; c < numCols; c++) {
        lights[r][c] = Math.random() < 0.4;
      }
    }
  }

  public boolean evaluateLight(int row, int col)
  {
    int count = 0;
    for (int r = 0; r < lights.length; r++) {
      if (lights[r][col]) {
        count++;
      }
    }

    if (lights[row][col]) {
      // Rule 1: On and count is even
      if (count % 2 == 0) {
        return false;
      }
    } else {
      // Rule 2: Off and count divisible by 3
      if (count % 3 == 0) {
        return true;
      }
    }

    // Rule 3: Return current light status
    return lights[row][col];
  }

  public boolean[][] getLights()
  {
    return lights;
  }

  public String toString()
  {
    String s = "";
    for (int r = 0; r < lights.length; r++) {
      for (int c = 0; c < lights[0].length; c++) {
        s += lights[r][c] ? "*" : ".";
      }
      s += "\n";
    }
    return s;
  }
}
