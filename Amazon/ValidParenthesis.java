import java.util.*;
class ValidParenthesis {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put(')', '(');
        Deque<Character> stack = new LinkedList<>();


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c =='[') {
                stack.push(c);
            } else if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String a = "[45](34)";
        String b = "45[4(6])6]";
        ValidParenthesis so = new ValidParenthesis();
        System.out.println(so.isValid(a));
        System.out.println(so.isValid(b));
    }
}