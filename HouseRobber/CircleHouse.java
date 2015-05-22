public class CircleHouse {
    public int rob(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        // don't rob the last one
        int a = 0;
        int b = 0;
        int tmp;
        for (int i = 0; i < num.length - 1; i++) {
            tmp = b;
            b = Math.max(a + num[i], b);
            a = tmp;
        }
        int maxMoney = b;

        // rob the last one
        a = num[num.length - 1];
        b = a;
        for (int i = 1; i < num.length - 2; i++) {
            tmp = b;
            b = Math.max(a + num[i], b);
            a = tmp;
        }

        return Math.max(maxMoney, b);
    }
}