import java.util.*;

public class HouseRobber {

    private int[] num;

    public int rob(int[] num) {
        int len = num.length;
        if (len == 0) {
            return 0;
        }
        int[][] maxArray = new int[len][len];
        int m;
        int n;

        for (int i = 0; i < len; i++) {
            maxArray[i][i] = num[i];
        }

        for (int i = 0; i < len - 1; i++) {
            maxArray[i][i+1] = Math.max(num[i], num[i+1]); 
        }

        for (int i = 2; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                m = num[j] + maxArray[j+2][j+i];
                n = maxArray[j+1][j+i];
                maxArray[j][j+i] = Math.max(m, n);
            }
        }

        return maxArray[0][len-1];

    }

    public int robNew(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int a = 0;
        int b = 0;
        int tmp;
        for (int i = 0; i < num.length; i++) {
            tmp = b;
            b = Math.max(a + num[i], b);
            a = tmp;
        }
        return b;
    }

    public int getMax(int[][] maxArray) {
        int max = maxArray[0][0];
        for (int i = 0 ; i < maxArray.length; i++ ) {
            for (int j = 0; j < maxArray[0].length; j++ ) {
                if (maxArray[i][j] > max) {
                    max = maxArray[i][j];
                }
            }
        }
        return max;
    }

    public int maxMoney(int a, int b) {
        if (a == b) {
            return num[a];
        }

        if (b - a == 1) {
            return Math.max(num[a], num[b]);
        }

        int m1 = num[a] + maxMoney(a+2, b);
        int m2 = maxMoney(a+1, b);

        return Math.max(m1, m2);
    }

    public static void main(String[] args) {
        int[] house = {1,2,3,4};
        // System.out.println(Collections.max(Arrays.asList(house)));

        System.out.println(new HouseRobber().robNew(house));
    }
}