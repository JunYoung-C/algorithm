package inflearn.review.Recurtsivetreegraph.ex09;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int data;
    Node lt, rt;

    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}

public class Main {
    Node root;

    public int solution() {
        int answer = bfs();

        return answer;
    }

    int bfs() {
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        int L = 0;
        while (!que.isEmpty()) {
            int len = que.size();
            for (int i = 0; i < len; i++) {
                Node now = que.poll();
                if (now.lt == null && now.rt == null) {
                    return L;
                }
                if (now.lt != null) {
                    que.offer(now.lt);
                }
                if (now.rt != null) {
                    que.offer(now.rt);
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        System.out.println(tree.solution());
    }
}
