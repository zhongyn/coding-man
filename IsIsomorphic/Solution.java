import java.util.*;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> isMaped = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (!map.containsKey(a)) {
                if (isMaped.contains(b)) {
                    return false;
                }
                map.put(a, b);
                isMaped.add(b);
            } else {
                if (map.get(a) != b) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "ab";
        String b = "ca";
        Solution so = new Solution();
        System.out.println(so.isIsomorphic(a, b));
    }
}