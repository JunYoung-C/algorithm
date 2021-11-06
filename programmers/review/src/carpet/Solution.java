package carpet;

class Solution {
  public int[] solution(int brown, int yellow) {
    int[] answer = {};
    int sum = brown + yellow;
    for (int width = sum - 1; width >= 1; width--) {
      if (sum % width == 0) {
        int height = sum / width;
        if (width * 2 + (2 * height - 4) == brown) {
          return new int[] {width, height};
        }
      }
    }
    return answer;
  }
}
