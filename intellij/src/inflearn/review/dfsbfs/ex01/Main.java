package inflearn.review.dfsbfs.ex01;

import java.util.Scanner;

public class Main {
    boolean canSame = false;
    boolean[] isFirstGroup;
    static int sum = 0;

    public String solution(int n, int[] arr) {
        String answer = "NO";
        isFirstGroup = new boolean[n];
        dfs(0, n, arr);
        if (canSame) {
            answer = "YES";
        }
        return answer;
    }

    void dfs(int L, int n, int[] arr) {
        if (canSame) {
            return;
        }
        if (L >= n) {
            // 그룹 나눠서 체크
            if (isSameGroup(n, arr)) {
                canSame = true;
                return;
            }
        } else {
            isFirstGroup[L] = true;
            dfs(L + 1, n, arr);
            isFirstGroup[L] = false;
            dfs(L + 1, n, arr);
        }
    }

    boolean isSameGroup(int n, int[] arr) {
        int firstSum = 0;
        for (int i = 0; i < n; i++) {
            if (isFirstGroup[i]) {
                firstSum += arr[i];
            }
        }
        if (firstSum == (sum - firstSum)) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = stdIn.nextInt();
            sum += arr[i];
        }
        System.out.println(T.solution(n, arr));
    }
}
