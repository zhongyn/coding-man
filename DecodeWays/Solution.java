public class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int a = 1;
        int b = 1;
        char[] charArr = s.toCharArray();

        for (int i = 1; i < len; i++) {
            if (charArr[i - 1] == '0' && charArr[i] == '0') {
                return 0;
            } else if (charArr[i - 1] == '0') {
                a = b;
            } else if (charArr[i] == '0') {
                if (charArr[i - 1] > '2') {
                    return 0;
                }
                b = a;
                a = 0;
            } else {
                if (charArr[i - 1] > '2' || (charArr[i - 1] == '2' && charArr[i] > '6')) {
                    a = b;
                } else {
                    int tmp = b;
                    b = a + b;
                    a = tmp;
                }
            }
        }
        return b;
    }

    public static void main(String[] args) {
        String s = "1234";
        Solution so = new Solution();
        System.out.println(so.numDecodings(s));
    }
}