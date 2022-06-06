package backjoon.datastructure.ex11003;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Node {
    int index;
    long number;

    public Node(int index, long number) {
        this.index = index;
        this.number = number;
    }
}

public class Main {
    public void solution(int n, int l, long[] numbers) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Node> deque = new ArrayDeque<>();
        int lt = 0, rt = 0;

        for (; rt < n; rt++) {
            Node currentNode = new Node(rt, numbers[rt]);
            while (!deque.isEmpty() && deque.peekLast().number >= currentNode.number) {
                // 디큐 마지막 노드의 숫자가 넣을 노드의 숫자보다 크다면, 디큐 마지막 노드 제거
                deque.pollLast();
            }
            deque.offer(currentNode);

            // 디큐 첫번째 노드의 숫자가 최솟값이다.
            // 최솟값 출력
            // 디큐 첫번째 노드의 인덱스 <= lt인 경우 제거
            // lt++;

            Node firstNode = deque.peekFirst();
            bw.write(firstNode.number + " ");
            if (rt - lt + 1 == l && firstNode.index <= lt++) {
                deque.pollFirst();
            }
        }

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        long[] numbers = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        T.solution(n, l, numbers);
    }
}
