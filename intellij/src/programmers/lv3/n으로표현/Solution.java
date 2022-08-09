package programmers.lv3.n으로표현;

import java.util.*;

class Solution {
    public int solution(int N, int findNumber) {
        ArrayList<HashSet<Long>> numbers = createNumbers(N);

        for (int nCount = 2; nCount <= 8; nCount++) {
            HashSet<Long> numRow = numbers.get(nCount);
            for (int i = 1; i < nCount; i++) {
                for (long lt : numbers.get(i)) {
                    // System.out.print(num + " ");
                    if (lt == 0) {
                        continue;
                    } else if (lt == findNumber) {
                        return nCount - 1;
                    }

                    for (long rt : numbers.get(nCount - i)) {
                        if (rt == 0) {
                            continue;
                        }

                        numRow.add(lt + rt);
                        numRow.add(lt - rt);
                        numRow.add(lt / rt);
                        numRow.add(lt * rt);
                    }
                }
            }
            // System.out.println();
        }

        for (long num : numbers.get(8)) {
            if (num == findNumber) {
                return 8;
            }
        }

        return -1;
    }

    private ArrayList<HashSet<Long>> createNumbers(int n) {
        ArrayList<HashSet<Long>> numbers = new ArrayList<>();
        long stickNumber = n;
        for (int i = 0; i <= 8; i++) {
            numbers.add(new HashSet<>());
            if (i > 0) {
                numbers.get(i).add(stickNumber);
                stickNumber = stickNumber * 10 + n;
            }
        }

        return numbers;
    }
}
