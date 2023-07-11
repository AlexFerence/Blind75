package dynamicprogramming;

import java.util.Arrays;

public class Matrix01 {

  public static int[][] updateMatrix(int[][] mat) {
    int[][] res = new int[mat.length][mat[0].length];
    for (int[] arr : res) {
      Arrays.fill(arr, Integer.MAX_VALUE);
    }
    // Find the first zero then call the recursive function
    for (int y = 0; y < mat.length; y++) {
      for (int x = 0; x < mat[0].length; x++) {
        if (mat[y][x] == 0) {
          updateMatrixRec(x, y, mat, res, 0, 'n');
        }
      }
    }
    return res;
  }

  public static void updateMatrixRec(int x, int y, int[][] mat, int[][] res, int distFrom0, char prevDir) {

    if (x < 0 || y < 0 || y >= mat.length || x >= mat[0].length) return;

    int curr = mat[y][x];

    if (curr == 0) {
      if (res[y][x] == 0) return;
      res[y][x] = 0;
      updateMatrixRec(x + 1, y, mat, res, 1, 'l');
      updateMatrixRec(x - 1, y, mat, res, 1, 'r');
      updateMatrixRec(x, y + 1, mat, res, 1, 'u');
      updateMatrixRec(x, y - 1, mat, res, 1, 'd');
    }

    if (curr == 1) {
      int prevNum = res[y][x];
      res[y][x] = Math.min(distFrom0, res[y][x]);
      if (distFrom0 < prevNum) {
        updateMatrixRec(x + 1, y, mat, res, distFrom0 + 1, 'l');
        updateMatrixRec(x - 1, y, mat, res, distFrom0 + 1, 'r');
        updateMatrixRec(x, y + 1, mat, res, distFrom0 + 1, 'u');
        updateMatrixRec(x, y - 1, mat, res, distFrom0 + 1, 'd');
      }
    }
  }

  public static void main(String[] args) {
    // Call the function with [[0,0,1],[0,1,1],[1,0,1]] as input
    // and print the result here

    int[][] mat = {
        {1, 1, 1, 1},
        {1, 0, 1, 0},
        {1, 1, 1, 1},
        {0, 0, 0, 0}
    };
    int[][] res = updateMatrix(mat);
    for (int[] row : res) {
      for (int col : row) {
        System.out.print(col + " ");
      }
      System.out.println();
    }

  }

}
