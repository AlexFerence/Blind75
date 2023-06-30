package backtracking;

import java.util.Arrays;

public class SudokuSolver {


  public static char[][] solveSudoku(char[][] board) {
    char[][] res = null;
    for (int i = 1; i < 10; i++) {
      String iStr = "" + i;
      char[][] temp = solveSudokuRec(board, 0, 0, iStr.charAt(0));
      if (temp != null) res = temp;
    }
    return res;
  }



  public static char[][] solveSudokuRec(char[][] board, int x, int y, char c) {

    // Increment to the next spot
    if (x == 8 && y == 8 && validBoard(board)) return board;

    int nX = x;
    int nY = y;
    if (nX == 8) {
      nX = 0;
      nY++;
    }
    else {
      nX++;
    }

    int rows = board.length;
    int columns = board[0].length;

    char[][] copy = new char[rows][columns];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        copy[i][j] = board[i][j];
      }
    }

    if (!validBoard(copy)) return null;
    if (copy[y][x] == '.') {
      copy[y][x] = c;
      if (!validBoard(copy)) return null;
      for (int i = 1; i < 10; i++) {
        String iStr = "" + i;
        char[][] temp = solveSudokuRec(copy, nX, nY, iStr.charAt(0));
        if (temp != null) return copy;
      }
    }
    else {
      if (!validBoard(copy)) return null;
      solveSudokuRec(copy, nX, nY, c);
    }

    return null;
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


  public static void main(String[] args) {
    String[][] input = {
        {".", ".", ".", ".", ".", ".", ".", "7", "."},
        {"2", "7", "5", ".", ".", ".", "3", "1", "4"},
        {".", ".", ".", ".", "2", "7", ".", "5", "."},
        {"9", "8", ".", ".", ".", ".", ".", "3", "1"},
        {".", "3", "1", "8", ".", "4", ".", ".", "."},
        {".", ".", ".", "1", ".", ".", "8", ".", "5"},
        {"7", ".", "6", "2", ".", ".", "1", "8", "."},
        {".", "9", ".", "7", ".", ".", ".", ".", "."},
        {"4", "1", ".", ".", ".", "5", ".", ".", "7"}
    };

    char[][] charArray = new char[input.length][input[0].length];

    for (int i = 0; i < input.length; i++) {
      for (int j = 0; j < input[i].length; j++) {
        charArray[i][j] = input[i][j].charAt(0);
      }
    }

    char[][] arr = solveSudoku(charArray);

    System.out.println(Arrays.toString(arr));

  }
}
