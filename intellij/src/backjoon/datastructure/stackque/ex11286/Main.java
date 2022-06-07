package backjoon.datastructure.stackque.ex11286;

import java.io.*;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
    int number;
    int absNum;

    public Node(int number, int absNum) {
        this.number = number;
        this.absNum = absNum;
    }

    @Override
    public int compareTo(Node o) {
        if (this.absNum == o.absNum) {
            return this.number - o.number;
        }
        return this.absNum - o.absNum;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int operCount = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pQ = new PriorityQueue<>();
        while (operCount-- > 0) {
            int number = Integer.parseInt(br.readLine());

            if (number == 0) {
                bw.write((pQ.isEmpty() ? 0 : pQ.poll().number) + "\n");

            } else {
                pQ.offer(new Node(number, Math.abs(number)));
            }
        }

        bw.flush();
        bw.close();
    }
}
