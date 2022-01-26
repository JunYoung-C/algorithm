package inflearn.review.sort.ex05;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public String solution(int n, int[] arr) {
        String answer = "U";
        Arrays.sort(arr);

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                answer= "D";
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = stdIn.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}
