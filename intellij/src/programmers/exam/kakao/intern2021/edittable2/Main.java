package programmers.exam.kakao.intern2021.edittable2;

import java.util.*;

class Solution {
    public String solution(int nodeCount, int selectedIndex, String[] commands) {
        StringTokenizer st;

        Node[] nodes = createNodeList(nodeCount);
        Stack<Node> deletedNodes = new Stack<>();
        Node selectedNode = nodes[selectedIndex];

        for (String command : commands) {
            st = new StringTokenizer(command);
            String operator = st.nextToken();

            if (operator.equals("U")) { // 인덱스 감소
                int moveCount = Integer.parseInt(st.nextToken());
                while (moveCount-- > 0) {
                    selectedNode = selectedNode.prevNode;
                }
            } else if (operator.equals("D")) { // 인덱스 증가
                int moveCount = Integer.parseInt(st.nextToken());
                while (moveCount-- > 0) {
                    selectedNode = selectedNode.nextNode;
                }
            } else if (operator.equals("C")) { // 노드 삭제
                deletedNodes.push(selectedNode);
                selectedNode.isDeleted = true;

                selectedNode.prevNode.nextNode = selectedNode.nextNode;
                selectedNode.nextNode.prevNode = selectedNode.prevNode;

                if (selectedNode.nextNode.isEnd) {
                    selectedNode = selectedNode.prevNode;
                } else {
                    selectedNode = selectedNode.nextNode;
                }

            } else if (operator.equals("Z")) { // 노드 복구
                Node recentlyDeletedNode = deletedNodes.pop();
                recentlyDeletedNode.isDeleted = false;
                recentlyDeletedNode.prevNode.nextNode = recentlyDeletedNode;
                recentlyDeletedNode.nextNode.prevNode = recentlyDeletedNode;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nodeCount; i++) {
            if (nodes[i].isDeleted) {
                sb.append("X");
            } else {
                sb.append("O");
            }
        }

        return sb.toString();
    }

    private Node[] createNodeList(int nodeCount) {
        Node[] nodes = new Node[nodeCount + 1];
        for (int i = 0; i < nodeCount; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 1; i < nodeCount - 1; i++) {
            nodes[i].nextNode = nodes[i + 1];
            nodes[i].prevNode = nodes[i - 1];
        }

        Node startNode = new Node(); // 편의를 위한 빈 노드 생성
        startNode.isStart = true;
        startNode.nextNode = nodes[0];
        nodes[0].prevNode = startNode;
//        nodes[0].hasPrev = false;
        nodes[0].nextNode = nodes[1];

        Node endNode = new Node(); // 편의를 위한 빈 노드 생성
        endNode.prevNode = nodes[nodeCount - 1];
        endNode.isEnd = true;
        nodes[nodeCount - 1].nextNode = endNode; // 편의를 위한 빈 노드 연결
//        nodes[nodeCount - 1].hasNext = false;
        nodes[nodeCount - 1].prevNode = nodes[nodeCount - 2];

        return nodes;
    }

    class Node {
        int index;
//        boolean hasNext;
//        boolean hasPrev;
        Node nextNode;
        Node prevNode;
        boolean isDeleted;
        boolean isStart;
        boolean isEnd;

        public Node() {
        }

        public Node(int index) {
            this.index = index;
//            this.hasNext = true;
//            this.hasPrev = true;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

        int n = 8;
        int k = 2;
//        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};

//        int n = 8;
//        int k = 2;
//        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};

//        String[] cmd = {"U 2", "C"};
//        String[] cmd = {"U 2", "C", "Z"};
//        String[] cmd = {"U 2", "C", "C", "C", "C", "C"};
        String[] cmd = {"D 5", "C", "C", "C", "C", "C"};

        System.out.println(T.solution(n, k, cmd));
    }
}
