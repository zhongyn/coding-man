public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int a = 0;
        int b = nums.length - 1;
        
        while (a < b) {
            int m = (a + b) / 2;
            if (nums[m] >= target) {
                b = m;
            } else {
                a = m + 1;
            }
        }
        int left = nums[a] == target ? a : -1;
        
        b = nums.length - 1;
        
        while (a < b) {
            int m = (a + b + 1) / 2;
            if (nums[m] <= target) {
                a = m;
            } else {
                b = m - 1;
            }
        }
        int right = nums[b] == target ? b : -1;
        return new int[]{left, right};
    }

    public static void main(String[] args) {
        int[] a = {5,7,7,8,8,10};
        Solution so = new Solution();
        int[] re = so.searchRange(a, 8);
        for (int i : re) {
            System.out.println(i);
        }
    }
}