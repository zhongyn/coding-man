import java.util.*;

public class Subsets {
    private List<List<Integer>> outer;
    private int[] input;

    public List<List<Integer>> subsets(int[] S) {
        outer = new LinkedList<List<Integer>>();
        Arrays.sort(S);
        input = S;
        System.out.println(Arrays.toString(input));
        addSubsets(input.length);
        return outer;
    }

    public List<List<Integer>> addSubsets(int len) {
        System.out.println(len);
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (len == 0) {
            List<Integer> empty = new LinkedList<Integer>();
            outer.add(empty);
            result.add(empty);
            return result;
        } 

        for (List set : addSubsets(len - 1)) {
            int i = set.size() == 0? 0 : Arrays.binarySearch(input, (int) set.get(set.size() - 1)) + 1;
            for (; i < input.length; i++) {
                List<Integer> newSet = new LinkedList<Integer>(set);
                newSet.add(input[i]);
                result.add(newSet);
                outer.add(newSet);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        Subsets s = new Subsets();
        List<List<Integer>> result = s.subsets(a);
        System.out.println(result);
    }
}