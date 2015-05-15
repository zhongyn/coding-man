import java.util.*;

class Parenthesis {
    String val;
    int left;
    int right;

    public Parenthesis(String s, int le, int ri) {
        val = s;
        left = le;
        right = ri;
    }
}
public class Solution {
    public List<String> generateParenthesis1(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        List<Parenthesis> ls = new ArrayList<>();
        Parenthesis empty = new Parenthesis("", 0, 0);
        ls.add(empty);

        for (int i = 0; i < 2 * n; i++) {
            List<Parenthesis> tmp = new ArrayList<>();
            for (Parenthesis p : ls) {
                if (p.left < n && p.left >= p.right) {
                    tmp.add(new Parenthesis(p.val + '(', p.left + 1, p.right));
                }
                if (p.right < n && p.left > p.right) {
                    tmp.add(new Parenthesis(p.val + ')', p.left, p.right + 1));
                }
            }
            ls.clear();
            ls = tmp;
        }

        for (Parenthesis p : ls) {
            result.add(p.val);
        }
        return result;
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        backtrack("", n, n, result);
        return result;
    }

    public void backtrack(String s, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(s);
        }
        if (left > 0 && left > right) {
            backtrack('(' + s, left - 1, right, result);
        }
        if (right > 0 && left >= right) {
            backtrack(')' + s, left, right - 1, result);
        }
    }
    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.generateParenthesis(2));
    }
}