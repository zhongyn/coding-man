import java.util.*;
public class LongestUniqueSubStr {
    public int uniqueSubStr(String s,int m) {
        if (s.length() == 0 || m < 1) {
            return 0;
        }

        Map<Character, Integer> visited = new HashMap<>();
        int maxSoFar = 0;
        int lh = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (visited.containsKey(c)) {
                visited.put(c, visited.get(c) + 1);
            } else {
                visited.put(c, 1);
            }

            System.out.println("lh: " + lh);
            System.out.println("i: " + i);
            System.out.println(visited);
            System.out.println();

            if (i == s.length() - 1 || (visited.size() == m && !visited.containsKey(s.charAt(i + 1)))) {
                maxSoFar = Math.max(maxSoFar, i - lh + 1);
                char firChar = s.charAt(lh);
                while (visited.containsKey(firChar)) {
                    char lhChar = s.charAt(lh);
                    visited.put(lhChar, visited.get(lhChar) - 1);
                    if (visited.get(lhChar) == 0) {
                        visited.remove(lhChar);
                    }
                    lh++;
                }

            }
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        LongestUniqueSubStr so = new LongestUniqueSubStr();
        String a = "a";
        String b = "abcabdaaacd";
        String c = "";
        System.out.println(so.uniqueSubStr(a, 0));
    }
}