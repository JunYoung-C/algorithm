package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    int[] numbers = {2, 5, 9, 10, 11, 15, 17, 19, 21, 22, 23, 30, 32, 34, 36, 37, 40, 41, 43};
    
    int len = numbers.length;
    ArrayList<Integer> answer = new ArrayList<>();

    Random rd = new Random();//랜덤 객체 생성
    while (true) {
      int idx = rd.nextInt(len);
      int number = numbers[idx];
      if (answer.contains(number)) {
        continue;
      }
      answer.add(number);
      if (answer.size() >= 6) break;
    }
    
    Collections.sort(answer);
    for (int i : answer) {
      System.out.print(i + " ");
    }
    
  }
}
