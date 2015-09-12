import java.util.*;
public class Solution {
    public int calculate1(String s) {
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

    public int compute1(char operator, int op1, int op2) {
        int result = 0;
        switch (operator) {
            case '+': result = op1 + op2;
            break;
            case '-': result = op1 - op2;
            break;
        }
        return result;
    }

    public int calculate(String s) {
        Deque<Integer> num = new LinkedList<>();
        Deque<Character> op = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                int j = i;
                int a = 0;
                while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    a = a * 10 + (s.charAt(j) - '0');
                    j++;
                }
                i = j - 1;
                num.push(a);
                if (!op.isEmpty() && (op.peek() == '*' || op.peek() == '/')) {
                    num.push(compute(num.pop(), num.pop(), op.pop()));
                }
            } else if (c != ' ') {
                op.push(c);
            } 
        }

        System.out.println(num);
        System.out.println(op);
        while (!op.isEmpty()) {
            int b = num.removeLast();
            int a = num.removeLast();
            num.add(compute(a, b, op.removeLast()));
        }

        return num.pop();
    }

    public int compute(int a, int b, char p) {
        int c = 0;
        switch (p) {
            case '*': c = b * a;
            break;
            case '/': c = b / a;
            break;
            case '+': c = b + a;
            break;
            case '-': c = b - a;
            break;
        }
        return c;
    }

    public static void main(String[] args) {
        String s ="2-4-(8+2-6+(8+4-(1)+8-10))";
        String a = "(7)-(0)+(4)";
        String b = "2*4 - 6 + 9";
        String d = "42";
        Solution so = new Solution();
        // System.out.println(so.calculate(a));
        System.out.println(so.calculate(d));
    }
}