public class Solution {
    public int mySqrt(int x) {
        int i = 0;
        int j = x;

        while (i < j) {
            int m = i + (j - i) / 2;
            if (y == x / m) {
                return m;
            } else if (y > x) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.mySqrt(16));
        System.out.println((long)Integer.MAX_VALUE * Integer.MAX_VALUE);
    }
}