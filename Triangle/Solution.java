import java.util.*;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        if (len == 0) {
            return 0;
        }
        int[] minSum = new int[len];
        minSum[0] = triangle.get(0).get(0);

        for (int i = 1; i < len; i++) {
            List<Integer> row = triangle.get(i);
            minSum[i] = minSum[i - 1] + row.get(i);
            for (int j = row.size() - 2; j > 0; j--) {
                minSum[j] = Math.min(minSum[j], minSum[j - 1]) + row.get(j);
            }
            minSum[0] += row.get(0);
        }       

        int min = minSum[0];
        for (int i = 1; i < len; i++) {
            if (min > minSum[i]) {
                min = minSum[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> lol = new ArrayList<>();
        lol.add(Arrays.asList(2));
        lol.add(Arrays.asList(3,4));
        lol.add(Arrays.asList(6,5,7));
        lol.add(Arrays.asList(4,1,8,3));

        Solution so = new Solution();
        System.out.println(so.minimumTotal(lol));
    }
}