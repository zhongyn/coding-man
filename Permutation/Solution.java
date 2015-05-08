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
        while (n < nums.length - 1 && nums[n] == nums[n + 1]) {
            n++;
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

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            ls.add(nums[i]);
        }
        ls.sort(null);
        findPermuteUnique(ls, 0, result);
        return result;        
    }
    public void findPermuteUnique(List<Integer> ls, int start, List<List<Integer>> result) {
        if (start == ls.size() - 1) {
            result.add(ls);
        }

        for (int i = start; i < ls.size(); i++) {
            if (i != start && ls.get(i) == ls.get(start)) {
                continue;
            }
            swap(ls, start, i);
            findPermuteUnique(new ArrayList<>(ls), start + 1, result);
        }
    }

    public void swap(List<Integer> ls, int a, int b) {
        int tmp = ls.get(a);
        ls.set(a, ls.get(b));
        ls.set(b, tmp);
    }


    public static void main(String[] args) {
        int[] a = {-1,-1,3,3};
        Solution so = new Solution();
        List<List<Integer>> re = so.permuteUnique(a);
        // so.permute(a);
        for (List<Integer> ls : re) {
            System.out.println(ls);
        }
    }
}