public class Solution {
    public List<String> anagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] ar = strs[i].toCharArray();
            Arrays.sort(ar);
            String s = new String(ar);
            if (map.containsKey(s)) {
                map.get(s).add(strs[i]);
            } else {
                List<String> ls = new ArrayList<>();
                ls.add(strs[i]);
                map.put(s, ls);
            }
        }

        List<String> result = new ArrayList<>();

        for (List<String> ls : map.values()) {
            if (ls.size() > 1) {
                result.addAll(ls);
            }
        }

        return result;
    }
}