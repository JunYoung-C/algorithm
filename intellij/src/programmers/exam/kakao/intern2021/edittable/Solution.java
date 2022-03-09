package programmers.exam.kakao.intern2021.edittable;

import java.util.Scanner;
import java.util.Stack;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        char[] table = new char[n];
        Stack<Integer> deletedIndexStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            table[i] = 'O';
        }

        int nowIndex = k;
        for (String command : cmd) {
            if (command.equals("C")) {
                table[nowIndex] = 'X';
                deletedIndexStack.push(nowIndex);

                while (++nowIndex < n && table[nowIndex] == 'X') {}

                if (nowIndex >= n) {
                    while (table[--nowIndex] == 'X') {}
                }

            } else if (command.equals("Z")) {
                int deletedIndex = deletedIndexStack.pop();
                table[deletedIndex] = 'O';
            } else { // D X, U X
                String[] moveCmd = command.split(" ");

                nowIndex = moveAndReturnIndex(moveCmd[0], Integer.parseInt(moveCmd[1]), nowIndex, n, table);
//                System.out.println(nowIndex);
            }
        }
        return String.valueOf(table);
    }

    private int moveAndReturnIndex(String direction, int count, int nowIndex, int len, char[] table) {
        int moveCnt = 0;
        if (direction.equals("D")) { // 인덱스 증가
            while (moveCnt != count) {
                while (table[++nowIndex] == 'X') {
                }
                moveCnt++;
            }
        } else { // 인덱스 감소
            while (moveCnt != count) {
                while (table[--nowIndex] == 'X') {
                }
                moveCnt++;
            }
        }

        return nowIndex;
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