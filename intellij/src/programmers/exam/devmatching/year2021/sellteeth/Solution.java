package programmers.exam.devmatching.year2021.sellteeth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Info {
    String referralName;
    int totalIncome;

    public Info(String referralName) {
        this.referralName = referralName;
    }

    public void addIncome(int income) {
        totalIncome += income;
    }
}

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int enrollLen = enroll.length;
        int[] answer = new int[enrollLen];
        Map<String, Info> infoMap = new HashMap<>();
        // enroll이 key
        for (int i = 0; i < enrollLen; i++) {
            infoMap.put(enroll[i], new Info(referral[i]));
        }

        int sellerLen = seller.length;
        for (int i = 0; i < sellerLen; i++) {
            int income = amount[i] * 100;
            int partOfIncome;
            Info myInfo = infoMap.get(seller[i]);

            while (income > 0) {
                partOfIncome = income / 10;
                income -= partOfIncome;

                myInfo.addIncome(income);

                income = partOfIncome;

                if (myInfo.referralName.equals("-")) {
                    break;
                }
                myInfo = infoMap.get(myInfo.referralName);
            }
        }


        for (int i = 0; i < enrollLen; i++) {
            answer[i] = infoMap.get(enroll[i]).totalIncome;
//            System.out.println(enroll[i] + ":" + infoMap.get(enroll[i]).referralName);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

        String[] enroll =
                {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral =
                {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller =
                {"young", "john", "tod", "emily", "mary"};
        int[] amount =
                {12, 4, 2, 5, 10};

//        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
//        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
//        String[] seller = {"sam", "emily", "jaimie", "edward"};
//        int[] amount = {2, 3, 5, 4};

//        String[] enroll =
//                {"john", "sam", "amie", "jay"};
//        String[] referral =
//                {"-", "john", "sam", "amie"};
//        String[] seller =
//                {"jay"};
//        int[] amount =
//                {100};
        for (long i : T.solution(enroll, referral, seller, amount)) {
            System.out.print(i + " ");
        }
    }
}
