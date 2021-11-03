package printstars;

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width = sc.nextInt();
        int height = sc.nextInt();
        
        for (int i = 0; i < height; i++) {
          for (int j = 0; j < width; j++) {
            System.out.print("*");
          }
          System.out.println();
        }
    }
}
