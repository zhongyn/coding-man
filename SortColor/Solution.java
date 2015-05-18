public class Solution {
    public void sortColors(int[] nums) {
        int a = 0;
        int b = nums.length - 1;
        for (int i = 0; i <= b; i++) {
            while (nums[i] == 2 && i < b) {
                swap(nums, i, b);
                b--;
            }
            while (nums[i] == 0 && i > a) {
                swap(nums, i, a);
                a++;
            }
        }
    }

    public void swap(int[] A, int a, int b) {
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }
}