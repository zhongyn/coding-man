public class HammingWeight {
    // you need to treat n as an unsigned value
    public int hammingWeight(long n) {
        int sum = 0;        
        while (n != 0) {
            n &= (n-1);
            sum++;
        }
  
        return Math.abs(sum);
    }

    public int reverseBits(int n) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < 16; i++) {
            a = (1<<i) & n;
            b = (1<<(31-i)) & n;
            if ((((a>>i) + (b>>(31-i))) & 1) == 1) {
                n ^= (1<<i);
                n ^= (1<<(31-i));
            }
        }
        return n;
    }

    public int reverseBits1(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (n & 1);
            n >>>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        // System.out.println(new HammingWeight().hammingWeight(4294967295));
        System.out.println(new HammingWeight().reverseBits1(43261596));
    }
}