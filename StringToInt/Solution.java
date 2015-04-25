public class Solution {
    public int myAtoi(String str) {
        int sign = 1;
        Integer sum = null;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (sum == null) {
                if (isDigit(c)) {
                    sum = c  - '0';
                    start = i;
                } else if (c == '-' || c == '+') {
                    sign = c == '-'? -1 : 1;
                    if (i < str.length() - 1 && !isDigit(str.charAt(i + 1))) {
                        return 0;
                    }
                } else if (c != ' ') {
                    return 0;
                }
            } else if (isDigit(c)) {
                if (isOverflow(sum, c - '0', sign)) {
                    return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                sum = sum * 10 + c - '0';
            } else {
                break;
            }
        }
        return sum == null? 0 : sum * sign;
    }

    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public boolean isOverflow(int a, int b, int sign) {
        return (sign == 1 && a > (Integer.MAX_VALUE - b) / 10) || (sign == -1 && a > -((Integer.MIN_VALUE + b) / 10));
    }

    public static void main(String[] args) {
        String s = "ahnb-45111111jhns67";
        String a = "    + 00134";
        Solution so = new Solution();
        System.out.println(so.myAtoi(a));
    }
}