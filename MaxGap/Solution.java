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

    public int maximumGap(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        int min = nums[0];
        int max = nums[0];
        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int gap = (max - min - 1) / (len - 1) + 1;
        int[] minBucket = new int[len - 1];
        int[] maxBucket = new int[len - 1];
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);

        for (int i = 0; i < len; i++) {
            if (nums[i] != min && nums[i] != max) {
                int id = (nums[i] - min) / gap;
                minBucket[id] = Math.min(minBucket[id], nums[i]);
                maxBucket[id] = Math.max(maxBucket[id], nums[i]);
            }
        }

        int maxGap = 0;
        int pre = min;
        for (int i = 0; i < len - 1; i++) {
            if (minBucket[i] != Integer.MAX_VALUE || maxBucket[i] != Integer.MIN_VALUE) {
                maxGap = Math.max(maxGap, minBucket[i] - pre);
                pre = maxBucket[i];
            }
        }
        maxGap = Math.max(maxGap, max - pre);
        return maxGap;
    }
}