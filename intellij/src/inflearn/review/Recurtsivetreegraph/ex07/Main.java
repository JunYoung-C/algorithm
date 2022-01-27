package inflearn.review.Recurtsivetreegraph.ex07;

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
    static Node root;

    public void solution() {
        Queue<Node> que = new LinkedList<>();
        boolean[] isVisited = new boolean[8];
        isVisited[1] = true;
        que.offer(root);

        while (!que.isEmpty()) {
            Node now = que.poll();
            System.out.print(now.data + " ");
            if (now.lt != null) {
                que.offer(now.lt);
            }
            if (now.rt != null) {
                que.offer(now.rt);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        T.solution();
    }
}
