import java.util.*;

public class Solution {

    public class numComparator implements Comparator<char[]> {
        public int compare(char[] A, char[] B) {
            int len = Math.max(A.length, B.length);
            for (int i = 0; i <= len; i++) {
                char a = i < A.length ? A[i] : A[i % A.length];
                char b = i < B.length ? B[i] : B[i % B.length];
                if (a != b) {
                    return a - b;
                }
            }
            return 0;
        }
    }

    public String largestNumber(int[] nums) {
        List<char[]> ls = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            ls.add(Integer.toString(nums[i]).toCharArray());
        }
        ls.sort(new numComparator());

        if (ls.get(ls.size() - 1)[0] == '0') {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = ls.size() - 1; i >= 0; i--) {
            sb.append(ls.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] a = {3, 30, 34, 5, 9};
        int[] b = {0, 0};
        int[] c = {824,938,1399,5607,6973,5703,9609,4398,8247};
        int[] d = {12, 121};

        Solution so = new Solution();
        System.out.println(so.largestNumber(d));
        // System.out.println(so.largestNumber(b));
        // System.out.println(so.largestNumber(a));
    }
}