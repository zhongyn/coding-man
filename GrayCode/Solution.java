import java.util.*;

public class Solution {
    public List<Integer> grayCode(int n) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        int a = 0;

        while (!visited.contains(a)) {
            visited.add(a);
            result.add(a);
            for (int i = 0; i < n; i++) {
                int b = (1 << i) ^ a;
                if (!visited.contains(b)) {
                    a = b;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.grayCode(4));
    }
}