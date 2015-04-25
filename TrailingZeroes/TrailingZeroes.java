public class TrailingZeroes {
    public int trailingZeroes(int n) {
        int sum = 0;
        int p = 1;

        for (int i = 1; i < n + 1; i++) {
            p *= i;
            while (p % 10 == 0) {
                sum++;
                p /= 10;
            }
            p %= 10;

        }
        return sum;        
    }

    public static void main(String[] args) {
        TrailingZeroes tz = new TrailingZeroes();
        System.out.println(tz.trailingZeroes(1000));
    }
}