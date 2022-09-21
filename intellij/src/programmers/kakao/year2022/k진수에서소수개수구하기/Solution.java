package programmers.kakao.year2022.k진수에서소수개수구하기;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String kNumber = Integer.toString(n, k);

        StringBuilder sb = new StringBuilder();
        for (char c : kNumber.toCharArray()) {
            if (c == '0') {
                if (sb.length() == 0) {
                    continue;
                }

                long num = Long.parseLong(sb.toString());

                if (isPrime(num)) {
                    answer++;
                }

                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }

        if (sb.length() != 0) {
            long num = Long.parseLong(sb.toString());

            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrime(long number) {
        if (number <= 1) {
            return false;
        }

        for (int div = 2; div <= (int) Math.sqrt(number); div++) {
            if (number % div == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution T = new Solution();

//        int n = 437674;
//        int k = 3;

        int n = 110011;
        int k = 10;

        System.out.println(T.solution(n, k));
    }
}
