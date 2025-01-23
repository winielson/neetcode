//https://neetcode.io/problems/buy-and-sell-crypto
//You are given an integer array prices where prices[i] is the price of NeetCoin on the ith day.
//
//You may choose a single day to buy one NeetCoin and choose a different day in the future to sell it.
//
//Return the maximum profit you can achieve. You may choose to not make any transactions, in which case the profit would be 0.

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, l = 0, r = 1;

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
            } else {
                l = r;
            }
            r++;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock instance = new BestTimeToBuyAndSellStock();
        int[] input = {10,1,5,6,7,1}; // Example input array
        int result = instance.maxProfit(input);
        System.out.println("Answer: " + result);
    }
}




