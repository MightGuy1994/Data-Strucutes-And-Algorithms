class BestTimeToSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;

        int low = prices[0];
        int max_profit = 0;

        for(int i = 1; i<prices.length; i++) {
            low = Math.min(low,prices[i]);
            max_profit = Math.max(max_profit,prices[i] - low);
        }
        return max_profit;
    }
}

// another greedy question. find min value at that postion and find the max profit at that point of time.


