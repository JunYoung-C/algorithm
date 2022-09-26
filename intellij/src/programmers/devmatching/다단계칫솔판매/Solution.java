package programmers.devmatching.다단계칫솔판매;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String, Node> map = new HashMap<>();
        initMap(enroll, referral, map);

        for (int i = 0; i < seller.length; i++) {
            Node current = map.get(seller[i]);
            int money = amount[i] * 100;
            int fee = money / 10;

            while (money > 0) {
                current.profit += money - fee;

                if (!current.hasParent()) {
                    break;
                }

                current = current.parent;
                money = fee;
                fee = money / 10;
            }
        }

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = map.get(enroll[i]).profit;
        }

        return answer;
    }

    private void initMap(String[] enroll, String[] referral, HashMap<String, Node> map) {
        map.put("-", new Node("-"));
        for (int i = 0; i < enroll.length; i++) {
            Node parent = map.get(referral[i]);
            map.put(enroll[i], new Node(enroll[i], parent));
        }
    }

    class Node {
        String name;
        Node parent;
        int profit;

        public Node(String name) {
            this.name = name;
        }

        public Node(String name, Node parent) {
            this.name = name;
            this.parent = parent;
        }

        public boolean hasParent() {
            return parent != null;
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();

        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        for (int i : T.solution(enroll, referral, seller, amount)) {
            System.out.print(i + " ");
        }
    }
}