package test;

import java.util.PriorityQueue;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        pQ.offer(1);
        pQ.offer(1);
        pQ.remove(pQ.poll());
        System.out.println(pQ.peek());
    }
}
