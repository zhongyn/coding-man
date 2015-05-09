import java.util.*;

// public class Solution {
//     public int maxProfit(int[] prices) {
//         if (prices.length == 0) {
//             return 0;
//         }
//         int maxPro = 0;
//         int minPrice = prices[0];

//         for (int i = 1; i < prices.length; i++) {
//             maxPro = Math.max(maxPro, prices[i] - minPrice);
//             minPrice = Math.min(minPrice, prices[i]);
//         }
//         return maxPro;
//     }
// }

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }        
        List<Integer> hasStockPro = new ArrayList<>();
        List<Integer> noStockPro = new ArrayList<>();
        hasStockPro.add(-prices[0]);
        noStockPro.add(0);

        for (int i = 1; i < prices.length; i++) {
            hasStockPro = noStockPro - prices[i];
            noStockPro = tmp + prices[i];
            maxPro = Math.max(Math.max(hasStockPro, noStockPro), maxPro);
        }
        return maxPro;
    }

    public int maxProfit(int[] prices) {
        List<Integer> start = new ArrayList<>();
        List<Integer> finish = new ArrayList<>();
        List<Integer> profit = new ArrayList<>();

        for (int j = 1; j < prices.length; j++) {
            for (int i = 0; i < j; i++) {
                int p = prices[j] - prices[i];
                if (p > 0) {
                    start.add(i);
                    finish.add(j);
                    profit.add(p);
                }
            }
        }
        if (profit.isEmpty()) {
            return 0;
        }

        int[] opt = new int[profit.size()];
        opt[0] = 0;

        for (int i = 1; i < opt.length; i++) {
            int q = binarySearch(finish, start.get(i));
            // System.out.println("q:"+q);
            opt[i] = Math.max(profit.get(i) + opt[q], opt[i - 1]);
        }
        return opt[opt.length - 1];
    }

    public int binarySearch(List<Integer> ls, int key) {
        int start = 0;
        int end = ls.size() - 1;

        while (start < end - 1) {
            int m = (start + end) / 2;
            if (ls.get(m) <= key) {
                start = m;
            } else {
                end = m - 1;
            }
        }
        return key >= ls.get(end) ? end : start;
    }

    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                total += prices[i + 1] - prices[i];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>(Arrays.asList(1,2,2,2,5,7,8));
        int[] p = {1,2,4};
        Solution so = new Solution();
        // System.out.println(so.binarySearch(ls, 6));
        System.out.println(so.maxProfit(p));
    }
}