package backtracking;

import java.util.Arrays;

public class SudokuSolver {


  public static char[][] solveSudoku(char[][] board) {
    char[][] res = null;
    for (int i = 0; i < 10; i++) {
      String iStr = "" + i;
      char[][] temp = solveSudokuRec(board, 0, 0, iStr.charAt(0));
      if (temp != null) res = temp;
    }
    return res;
  }



  public static char[][] solveSudokuRec(char[][] board, int x, int y, char c) {

    board[y][x] = c;

    if (!validBoard(board)) {
      return null;
    }

    // Increment to the next spot
    if (x == 8 && y == 8) {
      return board;
    }

    int nX = x;
    int nY = y;

    if (nX == 8) {
      nX = 0;
      nY++;
    }
    else {
      nX++;
    }
    
    for (int i = 0; i < 10; i++) {

    }




    return board;
  }

  // Function that determines if the board is valid
  // Ignore the '.' they represent empty spaces
  public static boolean validBoard(char[][] board) {
    // Check rows
    for (int i = 0; i < board.length; i++) {
      boolean[] seen = new boolean[10];
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] != '.') {
          int num = Character.getNumericValue(board[i][j]);
          if (seen[num]) return false;
          seen[num] = true;
        }
      }
    }

    // Check columns
    for (int i = 0; i < board.length; i++) {
      boolean[] seen = new boolean[10];
      for (int j = 0; j < board[i].length; j++) {
        if (board[j][i] != '.') {
          int num = Character.getNumericValue(board[j][i]);
          if (seen[num]) return false;
          seen[num] = true;
        }
      }
    }

    // Check squares
    for (int i = 0; i < board.length; i += 3) {
      for (int j = 0; j < board[i].length; j += 3) {
        boolean[] seen = new boolean[10];
        for (int k = i; k < i + 3; k++) {
          for (int l = j; l < j + 3; l++) {
            if (board[k][l] != '.') {
              int num = Character.getNumericValue(board[k][l]);
              if (seen[num]) return false;
              seen[num] = true;
            }
          }
        }
      }
    }

    return true;
  }

}
