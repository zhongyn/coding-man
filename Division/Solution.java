public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sum = 0;
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);

        while (a >= b) {
            long tmp = b;
            int i = 1;
            while ((tmp << 1) < a) {
                tmp <<= 1;
                i <<= 1;
            }
            sum += i;
            a -= tmp;
        }
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            return -sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.divide(-1010369383, -2147483648));
    }
}