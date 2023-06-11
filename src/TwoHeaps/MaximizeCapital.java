package TwoHeaps;

import java.util.PriorityQueue;

public class MaximizeCapital {

  // Need to follow the problem step by step

  public static int maximumCapital(int c, int k, int[] capitals,int[] profits) {




    return -1;
  }

  public static void main(String[] args) {

    // Min Heap
    PriorityQueue<Integer> capital = new PriorityQueue<>();

    capital.add(3);
    capital.add(5);
    capital.add(2);
    capital.add(6);

    // REMOVE nodes
    System.out.println(capital.poll());
    System.out.println(capital.poll());

    // CHECK min node
    System.out.println(capital.peek());

  }
}
