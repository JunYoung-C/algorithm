package programmers.lv3.이중우선순위큐;

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Node> maxPQ = new PriorityQueue(new MaxComparator());
        PriorityQueue<Node> minPQ = new PriorityQueue(new MinComparator());

        for (String op : operations) {
            String[] splitOp = op.split(" ");

            if (splitOp[0].equals("I")) { //숫자 삽입
                Node node = new Node(Integer.parseInt(splitOp[1]));
                maxPQ.offer(node);
                minPQ.offer(node);
            } else {
                if (splitOp[1].equals("1")) { // 최댓값 삭제
                    while (!maxPQ.isEmpty()) {
                        Node max = maxPQ.poll();
                        if (!max.isDeleted) {
                            max.isDeleted = true;
                            // System.out.println("최댓값" + " " + max.number);
                            break;
                        }
                    }
                } else { // 최솟값 삭제
                    while (!minPQ.isEmpty()) {
                        Node min = minPQ.poll();
                        if (!min.isDeleted) {
                            min.isDeleted = true;
                            // System.out.println("최솟값" + " " + min.number);
                            break;
                        }
                    }
                }
            }
        }

        // for (Node i : maxPQ) {
        //     System.out.println(i.number + " ");
        // }
        // System.out.println();
        // for (Node i : minPQ) {
        //     System.out.println(i.number + " ");
        // }

        while (!maxPQ.isEmpty()) {
            Node max = maxPQ.poll();
            if (!max.isDeleted) {
                answer[0] = max.number;
                break;
            }
        }

        while (!minPQ.isEmpty()) {
            Node min = minPQ.poll();
            if (!min.isDeleted) {
                answer[1] = min.number;
                break;
            }
        }

        return answer;
    }

    class MaxComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.number - o1.number;
        }
    }

    class MinComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.number - o2.number;
        }
    }
}

class Node {
    int number;
    boolean isDeleted;

    public Node(int number) {
        this.number = number;
    }
}