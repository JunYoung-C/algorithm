package watermelon;

class Solution {
  public String solution(int n) {
      String water = "수";
      String melon = "박";
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < n; i++) {
        if (i % 2 == 0) sb.append(water);
        else sb.append(melon);
      }
      return sb.toString();
  }
}
