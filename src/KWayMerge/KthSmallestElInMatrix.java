package KWayMerge;

import java.util.Objects;
import java.util.PriorityQueue;

public class KthSmallestElInMatrix {

  private  static class Tile {
    public final int val;
    public final int x;
    public final int y;
    public Tile(int v, int x, int y) {
      this.val = v;
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Tile tile = (Tile) o;
      return val == tile.val && x == tile.x && y == tile.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(val, x, y);
    }
  }

  public static int kthSmallestElement(int[][] matrix, int k) {
    int n = matrix.length;
    // Make a new list of the size of all the elements
    int[] storage = new int[n * n];
    PriorityQueue<Tile> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
    int i = 0;
    minHeap.add(new Tile(matrix[0][0],0,0));
    while (i < k) {
      // Pop top element
      Tile minEl = minHeap.poll();
      storage[i] = minEl.val;

      int x = minEl.x;
      int y = minEl.y;

      // Add el to the right
      if (minEl.x < n - 1) {
        if (!minHeap.contains(new Tile(matrix[y][x+1],x+1,y))) {
          minHeap.add(new Tile(matrix[y][x+1],x+1,y));
        }
      }

      // Add el on the bottom
      if (minEl.y < n - 1) {
        if (!minHeap.contains(new Tile(matrix[y+1][x],x,y+1))) {
          minHeap.add(new Tile(matrix[y+1][x],x,y+1));
        }
      }
      i++;
    }

    // Your code will replace this placeholder return statement
    return storage[k - 1];
  }

  public static void main(String[] args) {

    int[][] arr = {
        {2,5,8},
        {3,7,10},
        {6,8,11}
    };

    int res = kthSmallestElement(arr, 3);

    System.out.println(res);

  }

}
