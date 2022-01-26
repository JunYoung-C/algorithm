package inflearn.review.sort.ex08;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public int solution(int n, int m, int[] arr) {
        int answer = -1;
        int lt = 0, rt = n - 1;
        Arrays.sort(arr);

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
//            System.out.println(lt + " " + rt + " " + mid + " " +arr[mid]);
            if (arr[mid] == m) {
                return mid + 1;
            } else if (arr[mid] < m) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        int m = stdIn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = stdIn.nextInt();
        }
        System.out.println(T.solution(n, m, arr));
    }
}
