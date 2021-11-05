package nextbignum;

class Solution {
  int getCnt(char[] arr) {
    int cnt = 0;
    for (char c : arr) {
      if (c == '1') {
        cnt++;
      }
    }
    return cnt;
  }
  public int solution(int n) {
    int num = n+1;
    char[] arr1= Integer.toBinaryString(n).toCharArray();
    int nCnt = getCnt(arr1);
    System.out.println(nCnt);
    while (true) {
      char[] arr2 = Integer.toBinaryString(num).toCharArray();
      int numCnt = getCnt(arr2);
      if ( numCnt == nCnt) {
        return Integer.parseInt(String.valueOf(arr2), 2);
      }
      num++;
    }
  }
}
