package dp.exam04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Block implements Comparable<Block> {
  int a;
  int w;
  int h;

  Block(int a, int h, int w) {
    this.a = a;
    this.w = w;
    this.h = h;
  }

  @Override
  public int compareTo(Block o) {
    return o.a - this.a;
  }

}


public class Main {

  public int solution(int n, ArrayList<Block> blocks) {
    int answer = 0;
    Collections.sort(blocks);
    int[] heights = new int[n];
    for (int i = 0; i < n; i++) {
      int maxH = 0;
      Block block = blocks.get(i);
      for(int j = i-1; j >= 0; j--) {
        Block tmp = blocks.get(j);
        if (block.w < tmp.w && maxH < heights[j]) {
          maxH = heights[j];
        }
      }
      heights[i] = maxH + block.h;
      answer = Math.max(answer, heights[i]);
    }

//    for (int h : heights) {
//      System.out.print(h + " ");
//    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    ArrayList<Block> blocks = new ArrayList<>();
    for (int i= 0; i < n; i++) {
      int a = stdIn.nextInt();
      int h = stdIn.nextInt();
      int w = stdIn.nextInt();
      blocks.add(new Block(a, h, w));
    }
    System.out.println(T.solution(n, blocks));
  }
}
