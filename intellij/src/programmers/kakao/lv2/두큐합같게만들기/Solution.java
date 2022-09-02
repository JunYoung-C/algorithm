package programmers.kakao.lv2.두큐합같게만들기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = Integer.MAX_VALUE;

        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        long ltSum = 0;
        for (int i : queue1) {
            ltSum += i;
            que1.offer(i);
        }

        long rtSum = 0;
        for (int i : queue2) {
            rtSum += i;
            que2.offer(i);
        }

        long sum = ltSum + rtSum;
        if (sum % 2 == 1) {
            return -1;
        } else if (ltSum == sum / 2) {
            return 0;
        }

        int len = queue1.length;
        answer = Math.min(getCount(len, que1, que2, ltSum, sum / 2), answer);

        if (answer == Integer.MAX_VALUE) {
            return -1;
        }
        return answer;
    }

    private static int getCount(int len, Queue<Integer> que1, Queue<Integer> que2, long sum, long target) {
        Queue<Integer> testQue1 = new LinkedList<>(que1);
        Queue<Integer> testQue2 = new LinkedList<>(que2);
        int count = 0;
        while (count < len * 3)  {
            if (sum < target) {
                sum += testQue2.peek();
                testQue1.offer(testQue2.poll());
            } else if (sum > target) {
                sum -= testQue1.peek();
                testQue2.offer(testQue1.poll());
            }

            count++;

            if (sum == target) {
                return count;
            }
        }
        return Integer.MAX_VALUE;
    }

    private int getCount(int[] numbers, long leftSum, long sum) {
        System.out.println(sum / 2);
        int len = numbers.length;
        int count = 0;
        int lt = 0, rt = len / 3;
        while (rt < len) {
            // System.out.println(lt + " " + rt + " " + leftSum);

            if (leftSum < sum / 2) {
                leftSum += numbers[rt];
                rt++;
                count++;
            } else if (leftSum > sum / 2) {
                leftSum -= numbers[lt];
                lt++;
                count++;
            }

            if (leftSum == sum / 2) {
                // System.out.println(lt + " " + rt + " " + leftSum);
                return count;
            }
        }

        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

//        int[] queue1 = {3, 2, 7, 2};
//        int[] queue2 = {4, 6, 5, 1};
//        int[] queue1 = {1, 2, 1, 2};
//        int[] queue2 = {1, 10, 1, 2};
        int[] queue1 = {1, 1};
        int[] queue2 = {1, 5};
        System.out.println(T.solution(queue1, queue2));
    }
}