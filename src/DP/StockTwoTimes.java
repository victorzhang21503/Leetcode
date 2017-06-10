package DP;

/*
 * 123. Best Time to Buy and Sell Stock III
 * 
 * Difficulty: $$$$$
 * 
 * Description:
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * 
 * Comment:
 * 每次扫一遍buy, sell表示进行一次交易
 * buy[i]代表到第i天为止，最后一次行为为买，可以得到最大的利益
 * sell[i]表示到第i天为止，最后一次行为为卖，可以得到最大的利益
 * */

public class StockTwoTimes {
	public static void main(String args[]) {
		StockTwoTimes solution = new StockTwoTimes();
		int[] prices = new int[]{1,5,1,6,1,7,1,8};
		solution.maxProfit(prices);
	}
	
	public int maxProfit(int[] prices) {
        int len = prices.length;
        
        int[] buy = new int[len + 1];
        int[] sell = new int[len + 1];
        buy[0] = Integer.MIN_VALUE;
        
        for(int j = 0; j < 2; j++){
            for(int i = 0; i < len; i++){
                buy[i + 1] = Math.max(buy[i], sell[i + 1] - prices[i]); // sell[i + 1] cannot be sell[i], 
                														 // otherwise every loop cannot represent one transaction
                														// how? we need to find the update of buy are based last loop's value sell[i + 1].
                														// Comparatively, sell[i] already updated in this loop, if use the value of it again, 
                														// multiple transaction would happen in the same loop
                sell[i + 1] = Math.max(sell[i], buy[i + 1] + prices[i]);
            }
            if(j == 0) {
            		for(int k = 0; k < len; k++) {
            			System.out.print("buy[" + k +"] = " + buy[k] + "  ");
            		}
            		System.out.println();
            		for(int k = 0; k < len; k++) {
            			System.out.print("sell[" + k +"] = " + sell[k] + "  ");
            		}
            }
        }
        
        return sell[len];
    }
}
