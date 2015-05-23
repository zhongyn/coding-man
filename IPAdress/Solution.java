import java.util.*;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return new ArrayList<String>();
        }
        List<List<String>> table = new ArrayList<>(s.length() + 1);
        table.add(new ArrayList<>());
        table.get(0).add("");

        for (int i = 1; i <= s.length(); i++) {
            table.add(new ArrayList<>());
            int j = i >= 3 ? i - 3 : 0;
            for (; j < i; j++) {
                String w = s.substring(j, i);
                if ((i - j == 1 || s.charAt(j) != '0') && !table.get(j).isEmpty() && Integer.parseInt(w) <= 255) {
                    for (String prev : table.get(j)) {
                        table.get(i).add(prev + (prev.isEmpty() ? "" : '.') + w);
                    }
                }
            }
        }

        List<String> result = new ArrayList<>();
        for (String ws : table.get(s.length())) {
            if (isValid(ws)) {
                result.add(ws);
            }
        }
        return result;
    }

    public boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                count++;
            }
        }
        return count == 3;
    }

    public static void main(String[] args) {
        String s = "0000";
        Solution so = new Solution();
        System.out.println(so.restoreIpAddresses(s));
    }
}