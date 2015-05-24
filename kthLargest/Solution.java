import java.util.*;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        makeHeap(nums);
        heapSort(nums);
        return nums[k - 1];
    }

    public void makeHeap(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, nums.length - 1);
        }
    }

    public void adjustHeap(int[] nums, int i, int last) {
        while (i <= (last - 1) / 2) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            int minID = left;
            if (right <= last && nums[right] < nums[left]) {
                minID = right;
            }
            if (nums[i] > nums[minID]) {
                swap(nums, i, minID);
                i = minID;
            } else {
                break;
            }
        }
    }

    public void heapSort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i - 1);
        }
        if (nums.length > 1) {
            swap(nums, 0 ,1);
        }
    }

    public static final void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {2,3,1,4,6,4,7,5};
        int[] b = {1};

        Solution so = new Solution();
        System.out.println(so.findKthLargest(b, 1));
        System.out.println(Arrays.toString(b));
    }
}