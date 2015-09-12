import java.util.*;
public class Palindrome {
    public List<Integer> findPalindrome(int start, int end) {
        List<Integer> res = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            List<Integer> oct = toBase(i, 8);
            List<Integer> dec = toBase(i, 10);
            if (isPalindrome(dec) && isPalindrome(oct)) {
                System.out.println(oct);
                res.add(i);
            }
        }
        return res;
    }

    private List<Integer> toBase(int n, int base) {
        List<Integer> res = new ArrayList<>();
        while (n > 0) {
            res.add(n % base);
            n /= base;
        }
        return res;
    }

    private boolean isPalindrome(List<Integer> n) {
        int i = 0;
        int j = n.size() - 1;
        while (i < j) {
            if (n.get(i++) != n.get(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome so = new Palindrome();
        System.out.println(so.findPalindrome(1, 1000));
    }
}