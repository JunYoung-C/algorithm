package programmers.lv2.주식가격;

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Stack<Stock> stocks = new Stack<>();
        Stock stock = null;
        for (int i = 0; i < len; i++) {
            if (stocks.isEmpty()) {
                stocks.push(new Stock(i, prices[i]));
                continue;
            }

            while (!stocks.isEmpty() && stocks.peek().price > prices[i]) {
                stock = stocks.pop();
                answer[stock.index] = i - stock.index;
            }

            stocks.push(new Stock(i, prices[i]));
        }

        while (!stocks.isEmpty()) {
            stock = stocks.pop();
            answer[stock.index] = len - 1 - stock.index;
        }

        for (Stock s : stocks) {
            System.out.print(s.index + " ");
        }
        return answer;
    }
}

class Stock {
    int index;
    int price;

    public Stock(int index, int price) {
        this.index = index;
        this.price = price;
    }
}
