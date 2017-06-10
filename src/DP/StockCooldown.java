package DP;

/*
 * 309. Best Time to Buy and Sell Stock with Cool down
 * 
 * Difficulty: $$$$$
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cool down 1 day)
 * 
 * Example:
 * prices = [1, 2, 3, 0, 2]
 * maxProfit = 3
 * transactions = [buy, sell, cool down, buy, sell]
 * */

public class StockCooldown {
	public int maxProfit(int[] prices) {
        int pre_buy = 0, buy = Integer.MIN_VALUE, pre_sell = 0, sell = 0;
        for(int price : prices){
            pre_buy = buy;
            buy = Math.max(pre_sell - price, pre_buy);
            pre_sell = sell;
            sell = Math.max(pre_buy + price, pre_sell);
        }
        
        return sell;
    }
}
