public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int alen = a.length();
        int blen = b.length();

        int len = alen > blen? alen : blen;
        for (int i = 1; i < len + 1; i++) {
            int c = alen >= i? a.charAt(alen - i) - '0' : 0;
            int d = blen >= i? b.charAt(blen - i) - '0' : 0;
            int e = c + d + carry;
            sb.append(e % 2);
            carry = e / 2;
          }

        if (carry == 1) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "111";
        String b = "101";
        Solution s = new Solution();
        System.out.println(s.addBinary(a, b));
    }
}