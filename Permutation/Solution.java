import java.util.*;

public class Solution {
    public List<List<Integer>> permute1(int[] nums) {
        return findPermute(nums, nums.length);
    }

    public List<List<Integer>> findPermute(int[] nums, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0) {
            result.add(new LinkedList<>());
            return result;
        }

        List<List<Integer>> pre = findPermute(nums, n - 1);
        for (List<Integer> p : pre) {
            for (int i = 0; i < n; i++) {
                List<Integer> newP = new LinkedList<>(p);
                newP.add(i, nums[n - 1]);
                result.add(newP);
                // System.out.println(newP);
            }
        }
        return result;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findPermute(nums, 0, result);
        return result;
    }

    public void findPermute(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            List<Integer> ls = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                ls.add(nums[i]);
            }
            // System.out.println(ls);
            result.add(ls);
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            findPermute(nums, start + 1, result);
            swap(nums, start, i);
        }
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        Solution so = new Solution();
        so.permute(a);
    }
}