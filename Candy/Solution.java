import java.util.*;
public class Solution {
    public int candy1(int[] ratings) {
        int len = ratings.length;
        if (len == 0) {
            return 0;
        }
        int sum = 1;
        int pre = 1;
        int minP = 1;

        for (int i = 1; i < len; i++) {
            if (ratings[i] < ratings[i - 1]) {
                pre--;
                minP = Math.min(minP, pre);
            } else if (ratings[i] > ratings[i - 1]) {
                pre++;
            }
            sum += pre;
        }

        if (minP < 1) {
            sum += len * (1 - minP);
            pre += (1 - minP);
        }

        if (pre > 1 && ratings[len - 1] <= ratings[len - 2]) {
            sum -= pre;
            sum++;
        }
        if (minP < 1 && ratings[0] <= ratings[1]) {
            sum -= (1 - minP);
        }
        return sum;
    }

    public int candy2(int[] ratings) {
        int len = ratings.length;
        int[] num = new int[len];
        if (len < 2) {
            return 1;
        }

        for (int i = 1; i < len - 1; i++) {
            if (ratings[i - 1] > ratings[i] && ratings[i] < ratings[i + 1]) {
                num[i] = 1;
                for (int j = i - 1; j >= 0 && ratings[j] > ratings[j + 1]; j--) {
                    if (num[j] < num[j + 1]) {
                        num[j] = num[j + 1] + 1;
                    }
                }
                for (int j = i + 1; j < len && ratings[j] > ratings[j - 1]; j++) {
                    if (num[j] < num[j - 1]) {
                        num[j] = num[j - 1] + 1;
                    }
                }
            }
        }

        int id = 0;
        for (int i = 0; i < len - 1 && ratings[i] <= ratings[i + 1]; i++) {
            if (ratings[i] < ratings[i + 1]) {
                id++;
            } 
            num[i] = id;
        }

        id = 0;
        for (int i = len - 1; i > 0 && ratings[i] <= ratings[i - 1]; i--) {
            if (ratings[i] < ratings[i - 1]) {
                id++;
            }
            num[i] = id;
        }
        num[0] = num[0] > 0 ? num[0] : num[1] + 1;
        num[len - 1] = num[len - 1] > 0 ? num[len - 1] : num[len - 2] + 1;

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += num[i];
        }
        return sum;
    }

    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] num = new int[len];
        Arrays.fill(num, 1);

        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                num[i] = num[i - 1] + 1;
            }
        }   

        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                num[i] = Math.max(num[i], num[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += num[i];
        }     
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {1,2,4,4,3};
        int[] b = {2,2,2};

        Solution so = new Solution();
        System.out.println(so.candy(b));
    }
}