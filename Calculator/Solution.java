import java.util.*;
public class Solution {
    public int calculate(String s) {
        Deque<Character> operator = new LinkedList<>();
        Deque<Integer> ops = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                int op = 0;
                int j = i;
                for (; j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9'; j++) {
                    op  = op * 10 + (s.charAt(j) - '0');
                }
                i = j - 1;
                ops.push(op);
                computation(operator, ops);
            } else if (c == '+' || c == '-' || c == '(') {
                operator.push(c);
            } else if (c == ')') {
                operator.pop();
                computation(operator, ops);
            }
        }
        return ops.pop();
    }

    public void computation(Deque<Character> operator, Deque<Integer> ops) {
        if (!operator.isEmpty() && operator.peek() != '(') {
            char oper = operator.pop();
            int cur = ops.pop();
            int pre = ops.pop();
            switch (oper) {
                case '+': pre += cur;
                break;
                case '-': pre -= cur;
                break;
            }
            ops.push(pre);        
        }
    }

    public int compute(char operator, int op1, int op2) {
        int result = 0;
        switch (operator) {
            case '+': result = op1 + op2;
            break;
            case '-': result = op1 - op2;
            break;
        }
        return result;
    }

    public static void main(String[] args) {
        String s ="2-4-(8+2-6+(8+4-(1)+8-10))";
        String a = "(7)-(0)+(4)";
        Solution so = new Solution();
        // System.out.println(so.calculate(a));
        System.out.println(so.calculate(s));
    }
}