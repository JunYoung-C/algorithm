package exam04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Block implements Comparable<Block> {
  int area;
  int height;
  int weight;

  Block(int area, int height, int weight) {
    this.area = area;
    this.height = height;
    this.weight = weight;
  }

  @Override
  public int compareTo(Block o) {
    return o.area - this.area;
  }

}


public class Main {

  public int solution(int n, ArrayList<Block> arr) {
    int answer = 0;
    int[] heights = new int[n];
    Collections.sort(arr);
    heights[0] = arr.get(0).height;
    answer = heights[0];
    for (int i = 1; i < n; i++) {
      Block block = arr.get(i);
      for (int j = i - 1; j >= 0; j--) {
        Block prevBlock = arr.get(j);
        if (prevBlock.weight > block.weight) {
          heights[i] = Math.max(heights[i], heights[j]);
        }
      }
      heights[i] += block.height;
      answer = Math.max(answer, heights[i]);
    }
//    for (Block block : arr) {
//      System.out.println(block.area + " " + block.height + " " + block.weight);
//    }
//    for (int h : heights) {
//      System.out.print(h + " ");
//    }
//    System.out.println();
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    ArrayList<Block> arr = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int a = stdIn.nextInt();
      int h = stdIn.nextInt();
      int w = stdIn.nextInt();
      arr.add(new Block(a, h, w));
    }
    System.out.println(T.solution(n, arr));
  }
}
