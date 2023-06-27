package backtracking;

public class WordSearch {

  public static boolean wordSearch(char[][] grid, String word) {
    boolean res = false;
    for (int y = 0; y < grid.length; y++) {
      for (int x = 0; x < grid[0].length; x++) {
        res = res || wordSearchRec(grid, x, y, word.toLowerCase(), 0, 's');
      }
    }
    return res;
  }

  public static boolean wordSearchRec(char[][] grid, int x, int y, String word, int wordIndex, char prevDir) {
    if (word.charAt(wordIndex) != Character.toLowerCase(grid[x][y])) return false;
    if (word.charAt(wordIndex) == Character.toLowerCase(grid[x][y]) && wordIndex == word.length() - 1) return true;
    boolean resL = false, resR = false, resU = false, resD = false;
    if (prevDir != 'r' && x + 1 < grid[0].length) {
      resR = wordSearchRec(grid, x + 1, y, word, wordIndex + 1, 'l');
    }
    if (prevDir != 'l' && x - 1 >= 0) {
      resL = wordSearchRec(grid, x - 1, y, word, wordIndex + 1, 'r');
    }
    if (prevDir != 'd' && y + 1 < grid.length) {
      resD = wordSearchRec(grid, x, y + 1, word, wordIndex + 1, 'u');
    }
    if (prevDir != 'u' && y - 1 >= 0) {
      resU = wordSearchRec(grid, x, y - 1, word, wordIndex + 1, 'd');
    }
    return resR || resL || resD || resU;
  }

  public static void main(String[] args) {
    char[][] grid = {
        {'L', 'W', 'L', 'I', 'M'},
        {'A', 'T', 'L', 'Q', 'O'},
        {'O', 'L', 'A', 'T', 'O'},
        {'R', 'T', 'A', 'I', 'N'},
        {'O', 'I', 'T', 'N', 'C'}
    };

    boolean res = wordSearch(grid, "LATIN");

    System.out.println(res);
  }

}
