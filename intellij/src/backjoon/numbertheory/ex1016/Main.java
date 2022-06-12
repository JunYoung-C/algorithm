package backjoon.numbertheory.ex1016;

import java.util.Scanner;

public class Main {
    public int solution(Long min, Long max) {
        int answer = 0;
        boolean[] isChecked = new boolean[(int) (max - min + 1)];

        for (long num = 2; num * num <= max; num++) {
            long pow = num * num;

            long startIndex = min / pow;
            if (min % pow != 0) {
                startIndex++;
            }
            for (long i = startIndex; i * pow <= max; i++) {
                isChecked[(int) (i * pow - min)] = true;
            }
        }

        for (int i = 0; i < max - min + 1; i++) {
            if (!isChecked[i]) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        Long min = stdIn.nextLong();
        Long max = stdIn.nextLong();

        System.out.println(T.solution(min, max));
    }
}
