public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int highest = 0;

        for (int i = 0; i < 32; i++) {
            if (((m >> i) & 1) == 1) {
                highest = i;
            }
        }

        int a = 1 << highest;

        if (n >= (a << 1)) {
            return 0;
        } 

        return a + rangeBitwiseAnd(m - a, n - a);
    }

    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        while (m >> i != 0) {
            i++;
        }
        int a = 1 << i;        

        int b = a << 1;
        if ((n >= b && b > 0) || m == 0) {
            return 0;
        } 

        return a + rangeBitwiseAnd(m - a, n - a);
    }

    public static void main(String[] args) {
        int m = 5;
        int n = 8;
        Solution s = new Solution();
        System.out.println(s.rangeBitwiseAnd(m, n));
    }
}