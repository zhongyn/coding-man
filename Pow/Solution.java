public class Solution {
    public double myPow(double x, int n) {
        double result = 1;
        int nn = Math.abs(n);

        while (nn > 0) {
            int p = nn;
            int i = 0;
            double r = x;
            while (p > 1) {
                r *= r;
                i++;
                p >>= 1;
            }
            result *= r;
            nn -= 1 << i;
        }
        return n >= 0 ? result : 1 / result;
    }
}