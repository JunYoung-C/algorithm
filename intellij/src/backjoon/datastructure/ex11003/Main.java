package backjoon.datastructure.ex11003;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Deque<Node> deque = new ArrayDeque<>();
        int now;
        for (int i = 0; i < N; i++) {
            now = Integer.parseInt(st.nextToken());

            while (!deque.isEmpty() && deque.peekLast().number > now) {
                deque.pollLast();
            }
            deque.offer(new Node(i, now));

            if (deque.peekFirst().index <= i - L) {
                deque.pollFirst();
            }

            bw.write(deque.peekFirst().number + " ");
        }

        bw.flush();
        bw.close();
    }

    static class Node {
        int index;
        int number;

        public Node(int index, int number) {
            this.index = index;
            this.number = number;
        }
    }
}
