import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Set<String> dict = new HashSet<>();
        int totalLen = 0;
        for (int i = 0; i < words.length; i++) {
            dict.add(words[i]);
            totalLen += words[i].length();
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= s.length() - totalLen; i++) {
            Set<String> explored = new HashSet<>();
            if (wordBreak(s.substring(i, i + totalLen), dict, explored)) {
                result.add(i);
            }
        }
        return result;
    }

    public boolean wordBreak(String s, Set<String> dict, Set<String> explored) {
        if (s.length() == 0) {
            return true;
        }
        for (int i = 1; i <= s.length(); i++) {
            String w = s.substring(0, i);
            System.out.println(w);
            if (dict.contains(w) && !explored.contains(w)) {
                explored.add(w);
                if (wordBreak(s.substring(i), dict, explored)) {
                    return true;
                }
                explored.remove(w);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abcbaaaccaabbcababaaabccaabccccbbccbaabcbccacacacabcbbbacbcbbccabaccbbbcbaabbabbaaaacaacbcacbbaacbcbcbabbbcacbbacaacbbbcacccbbcacabbbacaccbcbaababa";
        String[] dict = {"bcb","baa","cac","aca","cca"};
        Solution so = new Solution();
        System.out.println(so.findSubstring(s, dict));
    }
}