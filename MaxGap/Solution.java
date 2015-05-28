public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int min = Math.min(nums[0], nums[1]);
        int max = Math.max(nums[0], nums[1]);
        int gap = max - min;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > max) {
                if (nums[i] - max > gap) {
                    gap = nums[i] - max;
                }
                max = nums[i];
            } else if (nums[i] < min) {
                if (min - nums[i] > gap) {
                    gap = min - nums[i];
                }
                min = nums[i];
            }
        }
        return gap;
    }
}