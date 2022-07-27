package programmers.lv2.예상대진표;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        int k = 1;

        int numA = a;
        int numB = b;
        for (; answer <= 20; answer++) {
            numA = (numA + 1) / 2;
            numB = (numB + 1) / 2;
            if (numA == numB) {
                break;
            }
        }

        return answer;
    }
}
