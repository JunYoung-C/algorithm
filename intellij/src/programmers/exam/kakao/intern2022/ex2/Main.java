package programmers.exam.kakao.intern2022.ex2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 길이가 서로 같은 큐가 주어지고, 각 큐의 합이 서로 같게 만드는 최소 횟수를 구하는 문제이다.
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long queSum1 = Arrays.stream(queue1).sum(); // 초기 상태의 합
        long queSum2 = Arrays.stream(queue2).sum();
        long numberCount = queue1.length + queue2.length; // 사실 길이가 서로 같은 큐가 주어지기 때문에 queue1.length * 2로 해도 된다.
        int num;

        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        initQue(queue1, que1);
        initQue(queue2, que2);

        // 처음에는 두 배열을 합치고 투포인터를 사용하여 구간합이 총합의 절반이 되는 구간을 찾고, 이를 횟수로 변환하자는 생각을 했다.
        // 해당 구간을 찾는 것은 어렵지 않았으나, 횟수로 변환하는 방법이 떠오르지 않아서 다른 방법으로 해결했다.

        // 합이 큰 큐에서 합이 작은 큐로 숫자를 이동시킨다. 이를 합이 같아질때까지 반복한다.
          // 한 큐에서 숫자를 빼내면, 무조건 다른 큐로 넣어야하기 때문에 숫자들의 순서가 뒤바뀌지 않는다. 마치 원을 회전하는 것과 같다.
        // 숫자를 옮긴 횟수가 numberCount 이상이면, 합을 같게 만들 수 없다.
          // -> 테케 1개가 실패해서 numCount * 2 이하로 하니깐 풀림
        // 복기 : queue1 = {1, 2, 1, 2},  queue2 = {1, 1, 10, 2}의 경우에는 9라는 결과값이 나온다.
        // 정확한 수를 산출하지는 못했지만(numCount + 1까지하면 될지도), 일정 횟수 이상의 반복은 중복인 것은 확실하다.
        // 제약 조건이 있어야 한다는 것이 중요하기 때문에 numberCount * 2 이하로 설정하여 무난하게 해결할 수 있었다.
        while (answer < numberCount * 2) {
            if (queSum1 > queSum2) { // que1의 합이 더 크면 que2로 요소 삽입
                num = que1.poll();
                que2.offer(num);
                queSum1 -= num;
                queSum2 += num;

            } else if (queSum1 < queSum2) { // que2의 합이 더 크면 que1로 요소 삽입
                num = que2.poll();
                que1.offer(num);
                queSum1 += num;
                queSum2 -= num;
            } else { // 서로 합이 같으면 종료
                return answer;
            }
            answer++;
        }

        return -1; // 합이 같은 경우를 찾을 수 없는 경우
    }

    private void initQue(int[] queue, Queue<Integer> que) {
        for (int i : queue) {
            que.offer(i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);
//        int[] queue1 = {3, 2, 7, 2};
//        int[] queue2 = {4, 6, 5, 1};

//        int[] queue1 = {1, 2, 1, 2};
//        int[] queue2 = {1, 10, 1, 2};

        int[] queue1 = {1, 2, 1, 2};
        int[] queue2 = {1, 1, 10, 2};

//        int[] queue1 = {1, 1};
//        int[] queue2 = {1, 5};

//        int[] queue1 = {1};
//        int[] queue2 = {1};

//        int[] queue1 = {2};
//        int[] queue2 = {1, 1};

//        int[] queue1 = {1000000000};
//        int[] queue2 = {1000000000};
        System.out.println(T.solution(queue1, queue2));
    }
}
