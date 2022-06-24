package template.tree.trie;

import java.io.*;
import java.util.StringTokenizer;

class Node {
    Node[] nextNodes = new Node[26];
    boolean isEnd;
}

public class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int inputStringCount = Integer.parseInt(st.nextToken());
        int findStringCount = Integer.parseInt(st.nextToken());
        Node rootNode = new Node();

        for (int i = 0; i < inputStringCount; i++) {
            String str = br.readLine();
            Node currentNode = rootNode;

            for (char c : str.toCharArray()) {
                if (currentNode.nextNodes[c - 'a'] == null) {
                    currentNode.nextNodes[c - 'a'] = new Node();
                }

                currentNode = currentNode.nextNodes[c - 'a'];
            }

            currentNode.isEnd = true;
        }

        int answer = 0;
        for (int i = 0; i < findStringCount; i++) {
            String str = br.readLine();
            Node currentNode = rootNode;
            boolean contains = true;

            for (char c : str.toCharArray()) {
                if (currentNode.nextNodes[c - 'a'] == null) {
                    contains = false;
                    continue;
                }

                currentNode = currentNode.nextNodes[c - 'a'];
            }

            if (currentNode.isEnd && contains) {
                answer++;
            }
        }

        br.close();
        bw.write(answer+ "");
        bw.flush();
        bw.close();
    }
}
