import java.util.*;
public class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 < len2) {
            return multiply(num2, num1);
        }

        String cur = "";

        for (int i = 0; i < len2; i++) {
            String product = multiplyDigit(num1, num2.charAt(len2 - 1 - i));
            // System.out.println("product: " + product);
            cur = addStrings(cur, product, i);
            // System.out.println(cur);
        }
        if (cur.charAt(cur.length() - 1) == '0') {
            return "0";
        }
        return new StringBuilder(cur).reverse().toString();
    }

    public String multiplyDigit(String s, char c) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int d = c - '0';
        for (int i = s.length() - 1; i >= 0; i--) {
            int p = (s.charAt(i) - '0') * d + carry;
            sb.append(p % 10);
            carry = p / 10;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.toString();
    }

    public String addStrings(String cur, String product, int offset) {
        if (cur.length() == 0) {
            return product;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cur.substring(0, offset));
        int maxlen = Math.max(cur.length() - offset, product.length());
        int carry = 0;

        for (int i = 0; i < maxlen; i++) {
            int a = i + offset < cur.length() ? cur.charAt(i + offset) - '0' : 0;
            int b = i < product.length() ? product.charAt(i) - '0' : 0;
            int sum = a + b + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) {
            sb.append(carry);
        }        
        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "123";
        String b = "456";
        Solution so = new Solution();
        System.out.println(so.multiply(a, b));
    }
}