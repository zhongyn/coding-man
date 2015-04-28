import java.util.*;

public class Solution {
    public int evalRPN1(String[] tokens) {
        Stack<String> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();
        Set<String> op = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

        for (int i = tokens.length - 1; i >= 0 ; i--) {
            if (op.contains(tokens[i])) {
                operators.push(tokens[i]);
            } else {
                operands.push(Integer.parseInt(tokens[i]));
            }
            System.out.println("operands: "+operands);
            System.out.println("operators: "+operators);

            if (operands.size() == 2 && operators.size() > 0) {
                int a = operands.pop();
                int b = operands.pop();
                int ans = evaluate(operators.pop(), a, b);
                operands.push(ans);
            }
        }
        return operands.pop();
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();
        Set<String> op = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

        for (int i = 0; i < tokens.length; i++) {
            if (!op.contains(tokens[i])) {
                operands.push(Integer.parseInt(tokens[i]));
            } else {
                int b = operands.pop();
                int a = operands.pop();
                int ans = evaluate(tokens[i], a, b);
                operands.push(ans);
            }
        }
        return operands.pop();
    }

    public int evaluate(String op, int a, int b) {
        int result = 0;

        switch (op) {
            case "+": result = a + b;
                    break;
            case "-": result = a - b;
                    break;
            case "*": result = a * b;
                    break;
            case "/": result = a / b;
                    break;
        }
        return result;
    }

    // public String evaluate(String op, String a, String b) {
    //     int c = Integer.parseInt(a);
    //     int d = Integer.parseInt(b);
    //     int result = 0;

    //     switch (op) {
    //         case "+": result = a + b;
    //                 break;
    //         case "-": result = a - b;
    //                 break;
    //         case "*": result = a * b;
    //                 break;
    //         case "/": result = a / b;
    //                 break;
    //     }
    //     return String.valueOf(result);
    // }


    public static void main(String[] args) {
        String[] s = {"2", "1", "+", "3", "*"};
        Solution so = new Solution();
        String[] a = {"-78","-33","196","+","-19","-","115","+","-","-99","/","-18","8","*","-86","-","-","16","/","26","-14","-","-","47","-","101","-","163","*","143","-","0","-","171","+","120","*","-60","+","156","/","173","/","-24","11","+","21","/","*","44","*","180","70","-40","-","*","86","132","-84","+","*","-","38","/","/","21","28","/","+","83","/","-31","156","-","+","28","/","95","-","120","+","8","*","90","-","-94","*","-73","/","-62","/","93","*","196","-","-59","+","187","-","143","/","-79","-89","+","-"};
        System.out.println(so.evalRPN(a));
    }
}