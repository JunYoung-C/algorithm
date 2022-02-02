package inflearn.review.dp.ex04;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Block implements Comparable<Block>{
    int a;
    int h;
    int w;

    public Block(int a, int h, int w) {
        this.a = a;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Block o) {
        return o.a - this.a;
    }
}
public class Main {
    public int solution(int n, Block[] blocks) {
        int answer = 0;
        Arrays.sort(blocks);
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int maxH = blocks[i].h;
            for (int j = i - 1; j >= 0; j--) {
                if (blocks[i].w < blocks[j].w) {
                    maxH = Math.max(maxH, dp[j] + blocks[i].h);
                }
            }
            dp[i] = maxH;
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        Block[] blocks = new Block[n];
        for (int i = 0; i < n; i++) {
            int a = stdIn.nextInt();
            int h = stdIn.nextInt();
            int w = stdIn.nextInt();
            blocks[i] = new Block(a, h, w);
        }
        System.out.println(T.solution(n, blocks));
    }
}