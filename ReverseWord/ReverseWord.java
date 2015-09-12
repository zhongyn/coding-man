import java.util.*;

public class ReverseWord {
    public String reverseWords2(char[] str) {
        reverse(str, 0, str.length - 1);

        int start = -1;
        int p = 0;
        while (p < str.length) {
            if (str[p] != ' ') {
                if (start == -1) {
                    start = p;
                }
            } else {
                if (start != -1) {
                    reverse(str, start, p - 1);
                    start = -1;                    
                }
            }
            p++;

        }
        if (start != -1) {
            reverse(str, start, p - 1);
        }
        return new String(str);
    }

    
    public void reverse(char[] str, int i, int j) {
        while (i < j) {
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
            i++;
            j--;
        }
    }

    public String reverseWords1(String s) {
        StringBuilder sb = new StringBuilder();
        int j = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                j = i;
            } else if (i == 0 || s.charAt(i - 1) == ' ') {
                if (sb.length() != 0) {
                    sb.append(' ');
                }
                sb.append(s.substring(i, j));
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "the blue is sky";
        ReverseWord rw = new ReverseWord();
        System.out.println(rw.reverseWords1(" "));
    }
}