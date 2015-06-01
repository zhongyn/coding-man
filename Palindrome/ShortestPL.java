import java.util.*;
public class ShortestPL {
    public String shortestPalindrome1(String s) {
        StringBuilder prefix = new StringBuilder();

        for (int i = s.length() - 1; i > 0; i--) {
            int j = 0;
            for (; j < (i + 1) / 2 && s.charAt(j) == s.charAt(i - j); j++) {}
            if (j != (i + 1) / 2) {
                prefix.append(s.charAt(i));
            } else {
                break;
            }
        }
        prefix.append(s);
        return prefix.toString();
    }

    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder re = new StringBuilder(s).reverse();
        sb.append('#').append(re);

        int len = sb.length();
        int[] table = new int[len + 1];
        table[0] = -1;
        int i = 0;
        int j = table[0];

        while (i < len) {
            while (j >= 0 && sb.charAt(i) != sb.charAt(j)) {
                j = table[j];
            }
            i++;
            j++;
            table[i] = j;
        }

        re.replace(re.length() - table[len], re.length(), s);
        return re.toString();
    }

    public String shortestPalindrome2(String s) {
        if (s.length() < 2) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append('#');
            sb.append(s.charAt(i));
        }
        sb.append('#');

        int len = sb.length();
        int[] table = new int[len];
        table[1] = 1;
        table[len - 2] = 1;
        int c = 1;
        int r = 1;
        for (int i = 2; i < len - 2; i++) {
            int j = 2 * c - i;
            table[i] = Math.min(r - i, table[j]);

            int left = i - table[i] - 1;
            int right = i + table[i] + 1;
            while (left >= 0 && right <len && sb.charAt(left) == sb.charAt(right)) {
                left--;
                right++;
                table[i]++;
            }
            if (i + table[i] >= r) {
                c = i;
                r = i + table[i];
            }
        }

        int maxPL = 0;
        for (int i = 0; i < len; i++) {
            if (table[i] == i) {
                maxPL = Math.max(maxPL, i);
            }
        }

        StringBuilder t = new StringBuilder(s.substring(maxPL));
        t.reverse().append(s);
        return t.toString();
    }

    public static void main(String[] args) {
        String s = "aaabc";
        ShortestPL so = new ShortestPL();
        System.out.println(so.shortestPalindrome(s));
    }
}