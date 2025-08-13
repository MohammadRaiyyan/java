package problems.array;

public class BuyStock {
    public static void main(String[] args) {
        int[] stockPrices = { 7, 1, 5, 3, 6, 4 };
        int maxProfit = maxProfitBrute(stockPrices);
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
            if (minPrice > prices[i]) {
                int profit = prices[i] - minPrice;
                minPrice = prices[i];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                int profit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
}
