package test;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
  public static void main(String[] args) {
    Queue<Integer> que = new LinkedList<>();
    que.offer(1);
    que.offer(2);
    Queue<Integer> que2 = new LinkedList<>();
    que2.offer(2);
    que2.offer(1);
    System.out.print(que.equals(que2));
  }
}
