import java.util.*;

public class Solution {
    // public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //     List<List<Integer>> result = new ArrayList<>();
    //     Arrays.sort(candidates);
    //     for (int i = candidates.length - 1; i >= 0; i--) {
    //         result.addAll(backtrack(candidates, target, i));
    //     }
    //     return result;
    // }

    // public List<List<Integer>> backtrack(int[] A, int target, int i) {
    //     List<List<Integer>> result = new ArrayList<>();
    //     if (i < 0 || target < A[i]) {
    //         return null;
    //     }
    //     if (target == A[i]) {
    //         List<Integer> ls = new ArrayList<>();
    //         ls.add(A[i]);
    //         result.add(ls);
    //         return result;
    //     }

    //     for (int j = i; j >= 0; j--) {
    //         List<List<Integer>> pre = backtrack(A, target - A[i], j);
    //         if (pre != null) {
    //             for (List<Integer> ls : pre) {
    //                 ls.add(A[i]);
    //                 result.add(ls);
    //             }                            
    //         }
    //     }
    //     return result;
    // }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return backtrack(candidates, target, candidates.length - 1);
    }

    public List<List<Integer>> backtrack1(int[] A, int target, int index) {
        List<List<Integer>> result = new ArrayList<>();
        if (target == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        for (int i = index; i >= 0 && target >= A[0]; i--) {
            List<List<Integer>> next = backtrack(A, target - A[i], i);
            for (List<Integer> ls : next) {
                ls.add(A[i]);
                result.add(ls);
            }                
        }
        return result;
    }

    public List<List<Integer>> backtrack(int[] A, int target, int index) {
        List<List<Integer>> result = new ArrayList<>();
        if (target == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        for (int i = index; i >= 0 && target >= A[0]; i--) {
            List<List<Integer>> next = backtrack(A, target - A[i], i - 1);
            for (List<Integer> ls : next) {
                ls.add(A[i]);
                result.add(ls);
                System.out.println(ls);
            }     
            System.out.println();
            while (i > 0 && A[i] == A[i - 1]) {
                i--;
            }       
        }
        return result;
    }



    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<List<Integer>>> table = new ArrayList<>(target + 1);
        Arrays.sort(candidates);
        List<List<Integer>> empty = new ArrayList<>();
        empty.add(new ArrayList<>());
        table.add(empty);

        for (int t = 1; t <= target; t++) {
            table.add(new ArrayList<>());
            for (int i = 0; i < candidates.length && t >= candidates[i]; i++) {
                for (List<Integer> ls : table.get(t - candidates[i])) {
                    if (ls.isEmpty() || candidates[i] >= ls.get(ls.size() - 1)) {
                        List<Integer> copy = new ArrayList<>(ls);
                        copy.add(candidates[i]);
                        table.get(t).add(copy);
                    }
                }
            }
        }        
        return table.get(target);
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<List<Integer>>> table = new ArrayList<>(n + 1);
        table.add(new ArrayList<>());
        table.get(0).add(new ArrayList<>());

        for (int i = 1; i <= n; i++) {
            table.add(new ArrayList<>());
            int j = i < 10 ? i : 9;
            for (; j > 0; j--) {
                for (List<Integer> ls : table.get(i - j)) {
                    if (ls.isEmpty() || (ls.size() < k && ls.get(ls.size() - 1) < j)) {
                        List<Integer> copy = new ArrayList<>(ls);
                        copy.add(j);
                        table.get(i).add(copy);
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> ls : table.get(n)) {
            if (ls.size() == k) {
                result.add(ls);
            }
        }
        return result;
    }

    // public List<List<Integer>> combinationSum1(int[] candidates, int target) {
    //     List<List<List<List<Integer>>>> table = new ArrayList<>();
    //     Arrays.sort(candidates);

    //     int i = 0;
    //     while (i < candidates.length && candidates[i] <= target) {
    //         table.add(new ArrayList<>());
    //         for (int j = 1; j <= target; j++) {
    //             // System.out.println("i: " + i);
    //             // System.out.println("j: " + j);
    //             // System.out.println();
    //             List<List<Integer>> cell = new ArrayList<>();
    //             table.get(i).add(cell);
    //             if (candidates[i] == j) {
    //                 List<Integer> ls = new ArrayList<>();
    //                 ls.add(candidates[i]);
    //                 cell.add(ls);      
    //                 // System.out.println(ls);       
    //             } else if (j - candidates[i] > 0) {
    //                 for (int k = 0; k <= i; k++) {
    //                     List<List<Integer>> pre = table.get(k).get(j - candidates[i] - 1);
    //                     if (!pre.isEmpty()) {
    //                         for (List<Integer> p : pre) {
    //                             List<Integer> copy = new ArrayList<>(p);
    //                             copy.add(candidates[i]);
    //                             cell.add(copy);
    //                             // System.out.println(copy);
    //                         }
    //                     }
    //                 }
    //             }
    //         }
    //         i++;
    //     }
    //     List<List<Integer>> result = new ArrayList<>();

    //     for (int j = 0; j < i; j++) {
    //         result.addAll(table.get(j).get(target - 1));
    //     }
    //     return result;
    // }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        List<List<Integer>> tmp;

        for (int i = 0; i < k; i++) {
            tmp = new ArrayList<>();
            for (List<Integer> ls : result) {
                int start = ls.isEmpty() ? 1 : (ls.get(ls.size() - 1) + 1);
                for (int j = start; j <= n; j++) {
                    List<Integer> copy = new ArrayList<>(ls);
                    copy.add(j);
                    tmp.add(copy);
                    // System.out.println(copy);
                }
            }
            result = tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,1,1,2,3,4};
        Solution so = new Solution();
        // List<List<Integer>> re = so.combinationSum2(a, 6);
        // List<List<Integer>> re = so.combinationSum3(3, 9);
        List<List<Integer>> re = so.combine(4, 2);
        for (List<Integer> p : re) {
            System.out.println(p);
        }
    }
}