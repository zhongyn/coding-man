import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int len = 0;
        int lastRepeat = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, i);
                len++;
            } else {
                // System.out.println("len: " + len);
                // System.out.println("Maxlen: " + maxLen);
                int id = map.get(c);
                if (id < lastRepeat) {
                    len++;
                } else if (id > lastRepeat && maxLen < len) {
                    maxLen = len;
                    len = i - id;
                    lastRepeat = id;
                }
                map.put(c, i);
            }
        }

        return Math.max(maxLen, len);
    }

    public static void main(String[] args) {
        String s ="tmmzuxt";
        Solution so = new Solution();
        System.out.println(so.lengthOfLongestSubstring(s));
    }
}
