public class ReverseInteger {
    public int reverse(int x) {
        int z = 0;
        while (x != 0) {
            if (z < 214748364 && z > -214748364) {
                return 0;
            } else {
                z = z * 10 + (x % 10);
                x /= 10;                
            }
            System.out.println("x: "+x);
            System.out.println("z: "+z);
        }
        return z;
    }
    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(-2147483645));
    }
}