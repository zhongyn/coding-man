import java.util.*;

public class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Integer, List<Character>> map = new HashMap<>();
        createMap(map);
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        result.add("");

        for (int i = 0; i < digits.length(); i++) {
            int key = digits.charAt(i) - '0';
            List<String> tmp = new ArrayList<>();

            for (int j = 0; j < result.size(); j++) {
                for (char ch : map.get(key)) {
                    tmp.add(result.get(j) + ch);
                }
            }
            result.clear();
            result = tmp;
        }
        return result;
    }

    public void createMap(Map<Integer, List<Character>> map) {
        for (int i = 1; i <= 6; i++) {
            List<Character> ls = new ArrayList<>();
            char ch = (char)('a' + (i - 2) * 3);
            ls.add(ch);
            ls.add((char)(ch + 1));
            ls.add((char)(ch + 2));
            map.put(i, ls);
        }
        map.put(7, Arrays.asList('p', 'q', 'r', 's'));
        map.put(8, Arrays.asList('t', 'u', 'v'));
        map.put(9, Arrays.asList('w', 'y', 'x', 'z'));
    }

    public static void main(String[] args) {
        String s = "23";
        Solution so = new Solution();
        System.out.println(so.letterCombinations(s));
    }
}