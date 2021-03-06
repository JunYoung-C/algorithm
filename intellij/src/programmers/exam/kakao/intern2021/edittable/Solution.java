package programmers.exam.kakao.intern2021.edittable;

import java.util.Scanner;
import java.util.Stack;

class Node {
    Node prevNode;
    Node nextNode;
    int index;
    char status;

    public Node(Node prevNode, int index) {
        this.prevNode = prevNode;
        this.nextNode = null;
        this.index = index;
        this.status = 'O';
    }
}

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Node[] table = new Node[n];
        Stack<Integer> deletedIndexStack = new Stack<>();
        // 0번째 노드 : prevNode = null, n - 1번째 노드 : nextNode = null
        table[0] = new Node(null, 0);
        for (int i = 1; i < n; i++) {
            table[i] = new Node(table[i - 1], i);
            table[i - 1].nextNode = table[i];
        }

        Node nowNode = table[k];
        Node prevNode, nextNode;
        int deletedIndex;
        for (String command : cmd) {
            if (command.equals("C")) {
                nowNode.status = 'X';
                deletedIndexStack.push(nowNode.index);

                nowNode = delete(nowNode);
            } else if (command.equals("Z")) {
                deletedIndex = deletedIndexStack.pop();
                table[deletedIndex].status = 'O';

                nextNode = table[deletedIndex].nextNode;
                prevNode = table[deletedIndex].prevNode;
//                nextNode = findNextNode(n, table,  deletedIndex);
//                prevNode = findPrevNode(table,  deletedIndex);
//
//                table[deletedIndex].prevNode = prevNode;
//                table[deletedIndex].nextNode = nextNode;
                if (prevNode != null) {
                    prevNode.nextNode = table[deletedIndex];
                }
                if (nextNode != null) {
                    nextNode.prevNode = table[deletedIndex];
                }
            } else { // D X, U X
                String[] moveCmd = command.split(" ");

                nowNode = move(moveCmd[0], Integer.parseInt(moveCmd[1]), nowNode, n, table);
//                System.out.println(nowNode.index);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Node node : table) {
            sb.append(node.status);
        }
        return sb.toString();
    }

    private Node findPrevNode(Node[] table, int index) {
        Node prevNode = null;
        for (int lt = index - 1; lt >= 0; lt--) {
            if (table[lt].status == 'O') {
                prevNode = table[lt];
                break;
            }
        }
        return prevNode;
    }

    private Node findNextNode(int n, Node[] table, int index) {
        Node nextNode = null;
        for (int rt = index + 1; rt < n; rt++) {
            if (table[rt].status == 'O') {
                nextNode = table[rt];
                break;
            }
        }
        return nextNode;
    }

    private Node delete(Node nowNode) {
        if (nowNode.nextNode == null) {
            nowNode.prevNode.nextNode = null;

            nowNode = nowNode.prevNode;
        } else if (nowNode.prevNode == null) {
            nowNode.nextNode.prevNode = null;

            nowNode = nowNode.nextNode;
        } else {
            nowNode.prevNode.nextNode = nowNode.nextNode;
            nowNode.nextNode.prevNode = nowNode.prevNode;

            nowNode = nowNode.nextNode;
        }
        return nowNode;
    }

    private Node move(String direction, int count, Node nowNode, int len, Node[] table) {
        int moveCnt = 0;

        if (direction.equals("D")) { // 인덱스 증가
            while (moveCnt != count) {
                nowNode = nowNode.nextNode;
                moveCnt++;
            }
        } else { // 인덱스 감소
            while (moveCnt != count) {
                nowNode = nowNode.prevNode;
                moveCnt++;
            }
        }

        return nowNode;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

//        int n = 8;
//        int k = 2;
//        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};

        int n = 8;
        int k = 2;
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
        System.out.println(T.solution(n, k, cmd));
    }
}