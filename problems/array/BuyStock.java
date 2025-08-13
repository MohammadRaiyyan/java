package problems.array;

public class BuyStock {
    public static void main(String[] args) {
        int[] stockPrices = { 7, 1, 5, 3, 6, 4 };
        int maxProfit = maxProfitOptimal(stockPrices);
        System.out.println(maxProfit);
    }

    static int maxProfitBrute(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }

    static int maxProfitOptimal(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int cost = prices[i] - minPrice;
            minPrice = Math.min(prices[i], minPrice);
            maxProfit = Math.max(maxProfit, cost);
        }
        return maxProfit;
    }
}
