package inflearn.review.sort.ex09;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public int solution(int n, int m, int[] arr, int max) {
        int answer = -1;
        int lt = Arrays.stream(arr).max().getAsInt(), rt = max;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int cnt = countDVD(mid, arr, n);
            if (cnt <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    int countDVD(int size, int[] arr, int n) {
        int cnt = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if ((sum + arr[i]) <= size) {
                sum += arr[i];
            } else {
                cnt++;
                sum = arr[i];
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        int m = stdIn.nextInt();
        int sum = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = stdIn.nextInt();
            sum += arr[i];
        }
        System.out.println(T.solution(n, m, arr, sum));
    }
}
