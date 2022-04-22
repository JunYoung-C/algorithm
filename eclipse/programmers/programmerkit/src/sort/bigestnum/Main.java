package sort.bigestnum;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {
  public String solution(int[] numbers) {
    String answer = "";
    int len = numbers.length;
    String[] strArr = new String[len];

    for (int i = 0; i < len; i++) {
      strArr[i] = String.valueOf(numbers[i]);
    }
    Arrays.sort(strArr, new Comparator<String>() {

      @Override
      public int compare(String o1, String o2) {
        return (o2 + o1).compareTo(o1+o2);
      }
    });

    if (strArr[0].equals("0")) return "0";
    for (String s : strArr) {
      answer += s;
    }
    return answer;
  }
}


public class Main {
  public static void main(String[] args) {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);

//     int[] numbers = {6, 10, 2};

    int[] numbers = {3, 30, 34, 5, 9};
    
//    int[] numbers = {3020, 30, 20, 0};
    
//    int[] numbers = {10, 100, 101, 1100, 1101, 1110, 1111};
    System.out.println(T.solution(numbers));
  }
}
