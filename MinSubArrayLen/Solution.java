public class Solution {
    public int minSubArrayLen1(int s, int[] nums) {
        int sum = 0;
        int i = 0;
        while (sum < s && i < nums.length) {
            sum += nums[i];
            i++;
        }
        if (sum < s) {
            return 0;
        }
        int minLen = i;
        if (i == nums.length) {
            i--;
        }
        while (i < nums.length) {
            sum = nums[i];
            for (int k = i; i - k + 1 < minLen; k--) {
                if (sum >= s) {
                    minLen = i - k + 1;
                    break;
                } 
                sum += nums[k];
            }
            i++;
        }
        return minLen;
    }

    public int minSubArrayLen2(int s, int[] nums) {
        int i = -1;
        int j = 0;
        int sum = 0;
        int minLen = nums.length + 1;

        while (i < nums.length) {
            if (sum < s) {
                i++;
                if (i == nums.length) {
                    break;
                }
                sum += nums[i];
            } else {
                minLen = Math.min(minLen, i - j + 1);
                sum -= nums[j];
                j++;
            }
        }
        return minLen == nums.length + 1? 0 : minLen;
    }

    public int minSubArrayLen(int s, int[] nums) {
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        int minLen = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {

            int end = binarySearch(nums, i + 1, sum[i] + s);
            if (end == nums.length) {
                break;
            }
            minLen = Math.min(minLen, end - i);

        }
        return minLen == nums.length + 1 ? 0 : minLen;
    }

    public int binarySearch(int[] A, int start, int target) {
        int a = start;
        int b = A.length - 1;

        while (a <= b) {
            int m = (a + b) / 2;
            if (A[m] >= target) {
                b = m - 1;
            } else {
                a = m + 1;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {2,3,1,2,4,3};
        int[] b = {1,2,3,4,5};
        int[] c = {1,4,4};


        Solution so = new Solution();
        System.out.println(so.minSubArrayLen(4, c));
    }
}