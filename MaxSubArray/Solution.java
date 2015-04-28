public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int a;
        
        for (int i = 0; i < nums.length; i++) {
           a = 0;
           for (int j = i; j < nums.length; j++) {
               a += nums[j];
               if (max < a) {
                   max = a;
               }
           }
       }
       
       return max;
    }


    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxSum = maxSum > 0? maxSum + nums[i] : nums[i];
            if (maxSum > result) {
                result = maxSum;
            }
        }
        return result;
     }

    public int maxSubArray(int[] A) {
        return findMax(A, 0, A.length - 1);
    }

    public int findMax(int[] A, int a, int b) {
        if (a >= b) {
            return A[a];
        }
        int m = (a + b) / 2;
        int left = findMax(A, a, m - 1);
        int right = findMax(A, m + 1, b);

        int p = m;
        int maxSuffix = A[m];
        int maxSoFarSuf = A[m];
        while (p > a) {
            p--;
            maxSuffix += A[p];
            if (maxSuffix > maxSoFarSuf) {
                maxSoFarSuf = maxSuffix;
            }
        }
        p = m;
        int maxPrefix = A[m];
        int maxSoFarPre = A[m];
        while (p < b) {
            p++;
            maxPrefix += A[p];
            if (maxPrefix > maxSoFarPre) {
                maxSoFarPre = maxPrefix;
            }
        }
        return Math.max(Math.max(left, right), maxSoFarPre + maxSoFarSuf - A[m]);
    }


    public int maxProduct(int[] nums) {
        int maxEndHere = nums[0];
        int minEndHere = nums[0];
        int maxSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int a = maxEndHere * nums[i];
            int b = minEndHere * nums[i];
            maxEndHere = max(a, b, nums[i]);
            minEndHere = min(a, b, nums[i]);
            if (maxSoFar < maxEndHere) {
                maxSoFar = maxEndHere;
            }
        }
        return maxSoFar;
    }

    public int max(int a, int b, int c) {
        if (a < b) {
            a = b;
        }
        if (a < c) {
            a = c;
        }
        return a;
    }

    public int min(int a, int b, int c) {
        if (a > b) {
            a = b;
        }
        if (a > c) {
            a = c;
        }
        return a;

    }

    public static void main(String[] args) {
        int[] a = {4, -1, 2, 1};
        Solution s = new Solution();
        System.out.println(s.maxSubArray(a));
        System.out.println(s.maxSubArray2(a));

    }
}
