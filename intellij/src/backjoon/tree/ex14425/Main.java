package backjoon.tree.ex14425;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int m, Node rootNode, String[] strings) {
        int answer = 0;

        for (String str : strings) {
            Node currentNode = rootNode;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (currentNode.nextNodes[c - 'a'] == null) {
                    break;
                }

                currentNode = currentNode.nextNodes[c - 'a'];

                if (i == str.length() - 1 && currentNode.isEnd) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Node rootNode = new Node();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            Node currentNode = rootNode;
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);

                if (currentNode.nextNodes[c - 'a'] == null) {
                    currentNode.nextNodes[c - 'a'] = new Node();
                }

                currentNode = currentNode.nextNodes[c - 'a'];

                if (j == str.length() - 1) {
                    currentNode.isEnd = true;
                }
            }
        }

        String[] strings = new String[m];
        for (int i = 0; i < m; i++) {
            strings[i] = br.readLine();
        }

        bw.write(T.solution(n, m, rootNode, strings) + "");
        bw.flush();
        bw.close();
    }
}

class Node {
    Node[] nextNodes = new Node[26];
    boolean isEnd;
}
