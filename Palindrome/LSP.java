import java.util.*;

public class LSP {
    public String longestPalindrome1(String s) {
        int len = s.length();
        int a = 0;
        int b = 0;

        boolean[][] table = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                if (i == 0) {
                    table[j][j + i] = true;
                } else if (s.charAt(j) == s.charAt(j + i)) {
                    if (i == 1 || table[j + 1][j + i - 1]) {
                        table[j][j + i] = true;
                        a = j;
                        b = j + i;
                    }
                }
            }
        }

        return len == 0 ? "" : s.substring(a, b + 1);
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 3) {
            return s;
        }
        boolean[] isPL = new boolean[len];
        int[] startID = new int[len];
        Map<Character, List<Integer>> map = new HashMap<>();

        int max = 2;
        startID[0] = 0;
        startID[1] = 0;
        isPL[0] = true;
        isPL[1] = true;
        int a = 0;
        int b = 1;


        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (i > 1 && map.containsKey(c)) {
                System.out.println(c);
                for (Integer prev : map.get(c)) {
                    if (i - prev + 1 > max) {
                        System.out.println(prev);
                        if (isPL[i - 1] && startID[i - 1] == prev + 1) {
                            max = i - prev + 1;
                            startID[i] = prev;
                            a = prev;
                            b = i;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                map.put(c, new ArrayList<Integer>());
            }
            map.get(c).add(i);
        }

        return s.substring(a, b + 1);
    }

    public static void main(String[] args) {
        String s = "abcba";
        LSP lsp = new LSP();
        System.out.println(lsp.longestPalindrome(s));
    }
}