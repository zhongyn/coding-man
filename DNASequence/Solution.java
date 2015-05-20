import java.util.*;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length() - 9; i++) {
            String w = s.substring(i, i + 10);
            if (map.containsKey(w)) {
                map.put(w, map.get(w) + 1);
            } else {
                map.put(w, 1);
            }
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> en : map.entrySet()) {
            if (en.getValue() > 1) {
                result.add(en.getKey());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        Solution so = new Solution();
        System.out.println(so.findRepeatedDnaSequences(s));
    }
        
}