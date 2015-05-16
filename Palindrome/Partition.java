import java.util.*;

public class Partition {
    public List<List<String>> partition(String s) {
        int len = s.length();
        char[] charArray = s.toCharArray();
        List<List<List<String>>> table = new ArrayList<>(len + 1);
        table.add(new ArrayList<>());
        table.get(0).add(new ArrayList<>());
        
        for (int i = 1; i <= len; i++) {
            table.add(new ArrayList<>());
            for (int j = 0; j < i; j++) {
                if (!table.get(j).isEmpty() && isPalindrome(charArray, j, i)) {
                    for (List<String> p : table.get(j)) {
                        List<String> ls = new ArrayList<>(p);
                        ls.add(s.substring(j, i));
                        table.get(i).add(ls);
                    }
                }
            }
        }

        return table.get(len);
    }

    public boolean isPalindrome(char[] A, int start, int end) {
        for (int i = 0; i < (end - start) / 2; i++) {
            if (A[start + i] != A[end - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s ="aab";
        Partition p = new Partition();
        List<List<String>> re = p.partition(s);
        for (List<String> ls : re) {
            System.out.println(ls);
        }
    }
}