public class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[len - 1] > nums[len - 2]) {
            return len - 1;
        }
        int i = 1;
        while (i < len - 1 && nums[i] < nums[i + 1]) {
            i++;
        }
        return i;
    }

    public int findPeakElement(int[] nums) {
        int a = 0;
        int b = nums.length - 1;

        while (a < b) {
            int m = (a + b) / 2;
            if (nums[m] <= nums[m + 1]) {
                a = m + 1;
            } else {
                b = m;
            }
        }
        return a;
    }

}