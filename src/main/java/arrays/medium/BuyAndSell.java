package arrays.medium;

class BuyAndSell {
    public int maxProfit(int[] prices) {
        int curr_min = Integer.MAX_VALUE;
        int max_profit = Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++) {
            curr_min = Math.min(curr_min,prices[i]);
            max_profit = Math.max(max_profit, prices[i]-curr_min);
        }
        return max_profit;
    }
}
