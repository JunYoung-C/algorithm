package printbignum;

import java.util.Scanner;


public class Main {
  public void solution(int n, int[] nums) {
    System.out.print(nums[0] + " ");
    for (int i = 1; i < n; i++) {
      if (nums[i] > nums[i-1])
        System.out.print(nums[i] + " ");
    }
    
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = stdIn.nextInt();
    }

    T.solution(n, nums);
  }
}
