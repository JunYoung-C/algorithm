package backjoon.datastructure.stackque.ex1874;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public ArrayList<String> solution(int n, int[] sequences) {
        ArrayList<String> answer = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0, num = 1; i < n; i++) {
            while (sequences[i] >= num) {
                stack.push(num++);
                answer.add("+");
            }

            if (stack.pop() == sequences[i]) {
                answer.add("-");
            } else {
                answer.clear();
                answer.add("NO");
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] sequences = new int[n];
        for (int i = 0; i < n; i++) {
            sequences[i] = Integer.parseInt(br.readLine());
        }

        for (String s : T.solution(n, sequences)) {
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
    }
}
