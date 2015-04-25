public class Palindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s == "") {
            return true;
        }
        int a = 0;
        int b = s.length() - 1;
        while (a < b) {
            if (!isDigitLetter(s.charAt(a))) {
                a++;
            } else if (!isDigitLetter(s.charAt(b))) {
                b--;
            } else if (!equal(s.charAt(a), s.charAt(b))) {
                return false;
            } else {
                a++;
                b--;
            }
        }
        return true;
    }

    public boolean isDigitLetter(char a) {
        if (!(a >= 'a' && a <='z') && !(a >= 'A' && a <='Z') && !(a >= '0' && a <= '9')) {
            return false;
        }
        return true;
    }

    public boolean equal(char a, char b) {
        a = toLowerCase(a);
        b = toLowerCase(b);
        return a == b;
    }

    public char toLowerCase(char a) {
        if (a >= 'A' && a <='Z') {
            a += 'a' - 'A';
        }
        return a;        
    }

    public static void main(String[] args) {
        String s = "abc";
        Palindrome p = new Palindrome();
        System.out.println(p.toLowerCase('A'));
        System.out.println(p.equal('a', 'B'));
        System.out.println(p.isPalindrome(s));
    }
}