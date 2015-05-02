import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int len = 0;
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= j) {
                maxLen = Math.max(maxLen, i - j);
                j = map.get(c) + 1;
            }
            map.put(c, i);
        }

        maxLen = Math.max(maxLen, s.length() - j);
        return maxLen;
    }

    public int LSTwoChars(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int j = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c) || map.get(c) < j) {
                count++;
                map.put(c, i);
            }
            if (count > 2) {
                maxLen = Math.max(maxLen, i - j);
                while (s.charAt(j + 1) == s.charAt(j)) {
                    j++;
                }
                j++;
                count = 2 ;
            }
        }

        maxLen = Math.max(maxLen, s.length() - j);
        return maxLen;
    }

    public static void main(String[] args) {
        String s ="bnhbjjdkeitttttttatttttttt";
        Solution so = new Solution();
        System.out.println(so.lengthOfLongestSubstring(s));
        System.out.println(so.LSTwoChars(s));
    }
}
