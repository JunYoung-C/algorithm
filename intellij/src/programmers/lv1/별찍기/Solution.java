package programmers.lv1.별찍기;

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for (int col = 0; col < b; col++) {
            for (int row = 0; row < a; row++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}