import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> left = new Stack<Character>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            System.out.println(c);
            if (c=='(' || c=='{' || c=='[') {
                left.push(c);
            } else if (!left.empty() && ((c==')' && left.peek()=='(') || (c==']' && left.peek()=='[') || (c=='}' && left.peek()=='{'))) {
                left.pop();                
            } else {
                return false;
            }
        }
        return left.empty();
     }

     public static void main(String[] args) {
         System.out.println(new ValidParentheses().isValid("[({})]"));
     }
}