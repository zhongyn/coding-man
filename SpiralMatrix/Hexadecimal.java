public class Hexadecimal {
    public int hextoDec(String s) {
        int n = 0;
        if (s.length == 0) {
            System.out.println("Invalid input");
            return -1;
        }
        for (int i = 0; i < s.length; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                n += c - '0';
            } else if (c >= 'a' && c <= 'g') {
                n += c - 'a';
            } else if (c >= 'A' && c <= 'G') {
                n += a - 'A';
            } else {
                System.out.println("Invalid input");
                return -1;
            }
        }
        return n;
    }
}