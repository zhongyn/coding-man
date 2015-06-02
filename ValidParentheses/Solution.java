import java.util.*;
public class Solution {
    public int longestValidParentheses1(String s) {
        int len = s.length();
        boolean[][] table = new boolean[len][len];
        char[] st = s.toCharArray();

        for (int i = 1; i < len; i++) {
            table[i][i - 1] = true;
        }

        int maxP = 0;

        for (int i = 1; i < len; i += 2) {
            for (int j = 0; j < len - i; j++) {
                int start = j;
                int end = j + i;
                if (st[start] != '(' || st[end] != ')') {
                    continue;
                }
                if (table[start + 1][end - 1]) {
                    table[start][end] = true;
                    maxP = end - start + 1;
                    continue;                        
                }
                for (int k = start + 1; k < end; k += 2) {
                    if (st[k] == ')' && table[start + 1][k - 1]
                        && st[k + 1] == '(' && table[k + 2][end - 1]) {
                        table[start][end] = true;
                        maxP = end - start + 1;
                    }
                }
            }
        }
        return maxP;
    }

    public int longestValidParentheses(String s) {
        Deque<Integer> p = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (!p.isEmpty() && s.charAt(i) == ')' && s.charAt(p.peek()) == '(') {
                p.pop();
            } else {
                p.push(i);
            }
        }

        if (p.isEmpty()) {
            return s.length();
        }
        int pre = p.pop();
        int maxP = s.length() - pre - 1;

        while (!p.isEmpty()) {
            int cur = p.pop();
            maxP = Math.max(maxP, pre - cur - 1);
            pre = cur;
        }
        maxP = Math.max(maxP, pre);
        return maxP;
    }

    // public int longestValidParentheses(String s) {
    //     Deque<Character> stack = new LinkedList<>();
    //     Deque<Integer> p = new LinkedList<>();

    //     for (int i = 0; i < s.length(); i++) {
    //         char c = s.charAt(i);
    //         p.push(i);
    //         if (c == '(') {
    //             stack.push(c);
    //         } else if (!stack.isEmpty() && stack.peek() == '(') {
    //             stack.pop();
    //             p.pop();
    //             p.pop();
    //         }
    //     }

    //     // System.out.println(p);
    //     if (p.isEmpty()) {
    //         return s.length();
    //     }
    //     int pre = p.pop();
    //     int maxP = s.length() - pre - 1;

    //     while (!p.isEmpty()) {
    //         int cur = p.pop();
    //         maxP = Math.max(maxP, pre - cur - 1);
    //         pre = cur;
    //     }
    //     maxP = Math.max(maxP, pre);
    //     return maxP;
    // }

    public static void main(String[] args) {
        String s = "()(()((()))";

        Solution so = new Solution();
        System.out.println(so.longestValidParentheses(s));
    }
}