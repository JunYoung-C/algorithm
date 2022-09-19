package programmers.kakao.lv3.길찾기게임;

import java.util.*;

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        int len = nodeinfo.length;
        int[][] nodeInfo = new int[len][3]; // 인덱스, x, y
        initNodeInfo(nodeInfo, nodeinfo);

        Tree tree = null;
        for (int[] n : nodeInfo) {
            Node node = new Node(n[0], n[1], n[2]);
            if (tree == null) {
                tree = new Tree(node);
                continue;
            }

            tree.add(node);
        }

        ArrayList<Integer> preorder = new ArrayList<>();
        tree.setPreorder(preorder, tree.root);

        ArrayList<Integer> postorder = new ArrayList<>();
        tree.setPostorder(postorder, tree.root);

        answer = new int[2][len];
        for (int i = 0; i < len; i++) {
            answer[0][i] = preorder.get(i);
            answer[1][i] = postorder.get(i);
        }

        return answer;
    }

    private void initNodeInfo(int[][] nodeInfo, int[][] nodeinfo) {
        int len = nodeinfo.length;
        for (int i = 0; i < len; i++) {
            nodeInfo[i][0] = i + 1;
            nodeInfo[i][1] = nodeinfo[i][0];
            nodeInfo[i][2] = nodeinfo[i][1];
        }

        Arrays.sort(nodeInfo, (o1, o2) -> {
            if (o1[2] == o2[2]) {
                return o1[1] - o2[1];
            }
            return o2[2] - o1[2];
        });
    }
}

class Tree {
    Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public void add(Node node) {
        Node cNode = root;

        while (true) {
            if (cNode.x > node.x) {
                if (cNode.left == null) {
                    cNode.left = node;
                    return;
                } else {
                    cNode = cNode.left;
                }
            } else {
                if (cNode.right == null) {
                    cNode.right = node;
                    return;
                } else {
                    cNode = cNode.right;
                }
            }
        }
    }

    public void setPreorder(ArrayList<Integer> preorder, Node cNode) {
        if (cNode == null) {
            return;
        }

        preorder.add(cNode.index);
        setPreorder(preorder, cNode.left);
        setPreorder(preorder, cNode.right);
    }

    public void setPostorder(ArrayList<Integer> postorder, Node cNode) {
        if (cNode == null) {
            return;
        }

        setPostorder(postorder, cNode.left);
        setPostorder(postorder, cNode.right);
        postorder.add(cNode.index);
    }
}

class Node {
    int index, x, y;
    Node left;
    Node right;

    public Node(int index, int x, int y) {
        this.index = index;
        this.x = x;
        this.y = y;
    }
}
