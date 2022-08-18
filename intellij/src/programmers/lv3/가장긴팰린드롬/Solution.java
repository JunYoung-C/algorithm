package programmers.lv3.가장긴팰린드롬;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        String reversedStr = sb.reverse().toString();

        for (int mid = 0; mid < len; mid++) {
            int lt = mid, rt = mid;
            int count = -1;
            // 홀수 판정
            while (lt >= 0 && rt < len && s.charAt(lt) == s.charAt(rt)) {
                count += 2;
                lt--;
                rt++;
            }
            answer = Math.max(answer, count);

            if (mid + 1 >= len) {
                continue;
            }

            lt = mid;
            rt = mid + 1;
            count = 0;
            while (lt >= 0 && rt < len && s.charAt(lt) == s.charAt(rt)) {
                count += 2;
                lt--;
                rt++;
            }
            answer = Math.max(answer, count);
        }

        return answer;
    }
}
