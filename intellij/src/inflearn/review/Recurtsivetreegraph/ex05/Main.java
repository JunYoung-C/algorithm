package inflearn.review.Recurtsivetreegraph.ex05;

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

        System.out.print("전위 순회 출력 : ");
        dfsFirst(root);
        System.out.println();

        System.out.print("중위 순회 출력 : ");
        dfsMiddle(root);
        System.out.println();

        System.out.print("후위 순회 출력 : ");
        dfsLast(root);
        System.out.println();
    }

    void dfsFirst(Node node) {
        System.out.print(node.data + " ");

        if (node.lt != null) {
            dfsFirst(node.lt);
        }

        if (node.rt != null) {
            dfsFirst(node.rt);
        }
    }

    void dfsMiddle(Node node) {
        if (node.lt != null) {
            dfsMiddle(node.lt);
        }
        System.out.print(node.data + " ");



        if (node.rt != null) {
            dfsMiddle(node.rt);
        }
    }

    void dfsLast(Node node) {

        if (node.lt != null) {
            dfsLast(node.lt);
        }

        if (node.rt != null) {
            dfsLast(node.rt);
        }
        System.out.print(node.data + " ");

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
