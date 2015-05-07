import java.util.*;

public class Subsets {
    private List<List<Integer>> outer;
    private int[] input;

    public List<List<Integer>> subsets(int[] S) {
        outer = new ArrayList<>();
        Arrays.sort(S);
        input = S;
        System.out.println(Arrays.toString(input));
        addSubsets(input.length);
        return outer;
    }

    public List<List<Integer>> addSubsets(int len) {
        System.out.println(len);
        List<List<Integer>> result = new ArrayList<>();

        if (len == 0) {
            List<Integer> empty = new ArrayList<>();
            outer.add(empty);
            result.add(empty);
            return result;
        } 

        for (List set : addSubsets(len - 1)) {
            int i = set.size() == 0? 0 : Arrays.binarySearch(input, (int) set.get(set.size() - 1)) + 1;
            for (; i < input.length; i++) {
                List<Integer> newSet = new ArrayList<>(set);
                newSet.add(input[i]);
                result.add(newSet);
                outer.add(newSet);
            }
        }

        return result;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> pre = new ArrayList<>();
        pre.add(new ArrayList<>());
        result.addAll(pre);
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> cur = new ArrayList<>();
            List<List<Integer>> validSets = (i > 0 && nums[i] == nums[i - 1]) ? pre : result;
            for (List<Integer> set : validSets) {
                List<Integer> copy = new ArrayList<>(set);
                copy.add(nums[i]);
                cur.add(copy);                    
            }
            result.addAll(cur);
            pre = cur;   
        }
        return result;
    }
    public static void main(String[] args) {
        int[] a = {2,2,2,2,2};
        Subsets s = new Subsets();
        List<List<Integer>> result = s.subsetsWithDup(a);
        // List<List<Integer>> result = s.subsets(a);

        System.out.println(result);
    }
}