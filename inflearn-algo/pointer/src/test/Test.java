package test;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
  public static void main(String[] args) {
    Queue<Character> que = new LinkedList<>();
    que.offer('c');
    que.offer('b');
    String str1 = que.toString();
    System.out.println(que.toArray());
  }
}
