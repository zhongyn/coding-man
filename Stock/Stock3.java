public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int[] fw = new int[len];
        int minPrice = prices[0];
        int[] bw = new int[len];
        int maxPrice = prices[len - 1];

        for (int i = 1; i < len; i++) {
            fw[i] = Math.max(fw[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
            bw[len - 1 - i] = Math.max(bw[len - i], maxPrice - prices[len - 1 - i]);
            maxPrice = Math.max(maxPrice, prices[len - 1 - i]);
        }

        int maxPro = bw[0];
        for (int i = 0; i < len - 1; i++) {
            maxPro = Math.max(fw[i] + bw[i + 1], maxPro);
        }
        return maxPro;
    }
}