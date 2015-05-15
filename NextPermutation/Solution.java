public class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                for (int j = len - 1; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        swap(nums, i, j);
                        ascending(nums, i + 1, len - 1);
                        return;
                    }
                }
            }
        }
        ascending(nums, 0, len - 1);
    }

    public void ascending(int[] A, int a, int b) {
        for (int i = 0; i <= (b - a) / 2; i++) {
            swap(A, a + i, b - i);
        }      
    }

    public void swap(int[] A, int a, int b) {
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {2,3,1};
        Solution so = new Solution();
        so.nextPermutation(a);
        for (int i : a) {
            System.out.println(i);   
        }
    }
}