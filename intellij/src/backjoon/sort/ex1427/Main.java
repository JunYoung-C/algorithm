package backjoon.sort.ex1427;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public String solution(String str) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < str.length() - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < str. length(); j++) {
                if (chars[maxIdx] < chars[j]) {
                    maxIdx = j;
                }
            }

            char tmp = chars[i];
            chars[i] = chars[maxIdx];
            chars[maxIdx] = tmp;

        }

        return new String(chars);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        String str = stdIn.next();
        System.out.println(T.solution(str));
    }
}
