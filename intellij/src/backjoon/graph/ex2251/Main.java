package backjoon.graph.ex2251;

import java.io.*;
import java.util.*;

class Node {
    int a;
    int b;
    int c;

    public Node(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public ArrayList<Node> nextNodes(int maxA, int maxB, int maxC) {
        ArrayList<Node> nextNodes = new ArrayList<>();

        int a = this.a;
        int b = this.b;
        int c = this.c;

        if (c <= maxA - a) {
            nextNodes.add(new Node(a + c, b, 0));
        } else {
            nextNodes.add(new Node(maxA, b, c - (maxA - a)));
        }

        if (c <= maxB - b) {
            nextNodes.add(new Node(a, b + c, 0));
        } else {
            nextNodes.add(new Node(a, maxB, c - (maxB - b)));
        }

        if (a <= maxB - b) {
            nextNodes.add(new Node(0, a + b, c));
        } else {
            nextNodes.add(new Node(a - (maxB - b), maxB, c));
        }

        if (a <= maxC - c) {
            nextNodes.add(new Node(0, b, a + c));
        } else {
            nextNodes.add(new Node(a - (maxC - c), b, maxC));
        }

        if (b <= maxC - c) {
            nextNodes.add(new Node(a, 0, b + c));
        } else {
            nextNodes.add(new Node(a, b - (maxC - c), maxC));
        }

        if (b <= maxA - a) {
            nextNodes.add(new Node(a + b, 0, c));
        } else {
            nextNodes.add(new Node(maxA, b - (maxA - a), c));
        }

        return nextNodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return a == node.a && b == node.b && c == node.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }
}

public class Main {
    public ArrayList<Integer> solution(int maxA, int maxB, int maxC) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<Node> visitNodes = new ArrayList<>();

        Queue<Node> que = new LinkedList<>();
        Node startNode = new Node(0, 0, maxC);
        que.offer(startNode);
        visitNodes.add(startNode);
        answer.add(maxC);

        while (!que.isEmpty()) {
            Node currentNode = que.poll();

            for (Node next : currentNode.nextNodes(maxA, maxB, maxC)) {
                if (!visitNodes.contains(next)) {
                    if (next.a == 0) {
                        answer.add(next.c);
                    }

                    visitNodes.add(next);
                    que.offer(next);
                }
            }
        }

        Collections.sort(answer);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        br.close();
        for (int i : T.solution(a, b, c)) {
            bw.write(i + " ");

        }
        bw.flush();
        bw.close();
    }
}
