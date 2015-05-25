public class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int i = 1;
        int j = x;

        while (i < j) {
            int m = i + (j - i) / 2;
            if (m >= x / m) {
                j = m;
            } else {
                i = m + 1;
            }
        }
        return i == x / i ? i : i - 1;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.mySqrt(Integer.MAX_VALUE));
        System.out.println(so.mySqrt(2));
        System.out.println((long)Integer.MAX_VALUE * Integer.MAX_VALUE);
    }
}