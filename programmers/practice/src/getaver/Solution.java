package getaver;

class Solution {
  public double solution(int[] arr) {
    double answer = 0;
    double sum = 0;
    for (double i : arr) {
      sum += i;
    }
    answer = sum / arr.length;
    return answer;
  }
}
