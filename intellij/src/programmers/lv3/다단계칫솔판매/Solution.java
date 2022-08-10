package programmers.lv3.다단계칫솔판매;

import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral,
                          String[] seller, int[] amount) {
        int personCount = enroll.length;
        int[] answer = new int[personCount];
        int sellCount = seller.length;
        HashMap<String, Person> personMap = createPersonMap(enroll, referral);

        for (int i = 0; i < sellCount; i++) {
            int income = amount[i] * 100;
            // int fee = income / 10;
            Person person = personMap.get(seller[i]);
            person.addIncome(income, personMap);
//             while (true) {
//                 // System.out.println(seller[i] + " " + person.name + " " + income + " " + fee);
//                 if (person.hasReferral()) {
//                     person.income += income - fee;
//                 } else {
//                     person.income += income;
//                     break;
//                 }

//                 if (income > 0) {
//                     income = fee;
//                     fee = fee / 10;
//                     person = personMap.get(person.referral);
//                 } else {
//                     break;
//                 }
//             }
        }

        for (int i = 0; i < personCount; i++) {
            answer[i] = personMap.get(enroll[i]).income;
        }

        return answer;
    }

    private HashMap<String, Person> createPersonMap(String[] enroll, String[] referral) {
        int personCount = enroll.length;
        HashMap<String, Person> personMap = new HashMap<>();
        Person center = new Person("-");
        personMap.put("-", center);

        for (int i = 0; i < personCount; i++) {
            personMap.put(enroll[i], new Person(enroll[i], referral[i]));
        }

        return personMap;
    }
}

class Person {
    String name;
    String referral;
    int income;

    public Person(String name, String referral) {
        this.name = name;
        this.referral = referral;
    }

    public Person(String name) {
        this(name, null);
    }

    public void addIncome(int income, HashMap<String, Person> personMap) {
        int fee = income / 10;
        this.income += income - fee;
        if (hasReferral() && fee != 0) {
            personMap.get(this.referral).addIncome(fee, personMap);
        }
    }

    public boolean hasReferral() {
        if (referral == null) {
            return false;
        }

        return true;
    }
}
