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


    public int[] maxArray(int[] nums, int a, int b) {
        int[] re = new int[2];
        if (a == b) {
            re[0] = 1;
            re[1] = nums[a];
            return re;
        }

        int m = (a + b) / 2;

        int[] left = maxArray(nums, a, m);
        int[] right = maxArray(nums, m + 1, b);

        int sum = left[1] + right[1];
        if (sum >= left[1] && sum >= right[1]) {
            re[0] = 1;
            re[1] = sum;
        } else if (left[1] > right[1]) {
            re[0] = 0;
            re[1] = left[1];
        } else {
            re[0] = 1;
            re[1] = right[1];
        }
        return re;
    }

    public int maxSubArray2(int[] nums) {
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


    public static void main(String[] args) {
        int[] a = {4, -1, 2, 1};
        Solution s = new Solution();
        System.out.println(s.maxSubArray(a));
        System.out.println(s.maxSubArray2(a));

    }
}
