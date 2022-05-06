package programmers.exam.kakao.intern2021.edittable2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

class Solution {
    int[] numbers;
    int[] fenwick;
    int maxNumber;

    public String solution(int numberCount, int selectedIndex, String[] commands) {
        StringTokenizer st;
        Stack<Integer> deletedIndexes = new Stack<>();
        maxNumber = numberCount;
        numbers = new int[numberCount];
        fenwick = new int[numberCount + 1];
        Arrays.fill(numbers, 1);

        for (int i = 1; i <= numberCount; i++) {
            update(i, 1);
        }

        for (String command : commands) {
            st = new StringTokenizer(command);
            String operator = st.nextToken();

            if (operator.equals("U")) { // 인덱스 감소
                int moveCount = Integer.parseInt(st.nextToken());
                selectedIndex = binarySearch(sum(selectedIndex + 1) - moveCount);
            } else if (operator.equals("D")) { // 인덱스 증가
                int moveCount = Integer.parseInt(st.nextToken());
                selectedIndex = binarySearch(sum(selectedIndex + 1) + moveCount);
            } else if (operator.equals("C")) { // 노드 삭제
                deletedIndexes.push(selectedIndex);
                numbers[selectedIndex] = 0;
                update(selectedIndex + 1, -1);

                if ((sum(selectedIndex + 1) == maxNumber - deletedIndexes.size())) {
                    while (numbers[selectedIndex] == 0) {
                        selectedIndex--;
                    }
                } else {
                    while (numbers[selectedIndex] == 0) {
                        selectedIndex++;
                    }
                }
            } else if (operator.equals("Z")) { // 노드 복구
                int restoredIndex = deletedIndexes.pop();
                numbers[restoredIndex] = 1;
                update(restoredIndex + 1, 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : numbers) {
            sb.append(i == 1 ? "O" : "X");

        }
        return sb.toString();
    }

    private void update(int index, int dif) {
        while (index <= maxNumber) {
            fenwick[index] += dif;
            index += index & -index;
        }
    }

    private int sum(int index) {
        int sum = 0;
        while (index > 0) {
            sum += fenwick[index];
            index -= index & -index;
        }

        return sum;
    }

    private int binarySearch(int target) {
        int start = 1, end = maxNumber;

        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = sum(mid);

            if (target <= sum) {
                end = mid - 1;
            } else  {
                start = mid + 1;
            }
        }

        return start - 1;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

        int n = 8;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};

//        int n = 8;
//        int k = 2;
//        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};

//        String[] cmd = {"U 2", "C"};
//        String[] cmd = {"U 2", "C", "Z"};
//        String[] cmd = {"U 2", "C", "C", "C", "C", "C"};
//        String[] cmd = {"D 5", "C", "C", "C", "C", "C"};

        System.out.println(T.solution(n, k, cmd));
    }
}
