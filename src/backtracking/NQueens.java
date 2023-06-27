package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {


  public static int solveNQueens(int n) {
    List<Integer> state = new ArrayList<>();
    return solveRec(state, n);
  }

  public static int solveRec(List<Integer> board, int n) {
    // Check if the board is valid
    if (!isValidBoard(board)) return 0;
    if (board.size() == n) return 1;
    else {
      int sum = 0;
      for (int i = 0; i < n; i++) {
        List<Integer> boardCopy = new ArrayList<>(board);
        boardCopy.add(i);
        sum += solveRec(boardCopy, n);
      }
      return sum;
    }
    // If valid try all the next possible possible board states
  }

  public static boolean isValidBoard(List<Integer> board) {
    if (board.size() == 0) return true;
    int lastRow = board.size() - 1;
    int lastCol = board.get(lastRow);
    for (int i = 0; i < board.size() - 1; i++) {
      int row = i;
      int col = board.get(i);
      if (col == lastCol) return false;
      if (Math.abs(row - lastRow) == Math.abs(col - lastCol)) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    int res = solveNQueens(4);
    System.out.println(res);
  }


}
