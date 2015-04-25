public class Solution {
    public String convert(String s, int nRows) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int cycle = 2 * nRows - 2;
        int i = 0;

        if (nRows == 1) {
            return s;
        }

        while (i < n) {
            sb.append(s.charAt(i));
            i += cycle;
        }

        for (i = 1; i < nRows - 1; i++) {
            int k = i;
            int j = cycle - i;
            while (k < n || j < n) {
                if (k < n) {
                    sb.append(s.charAt(k));
                    k += cycle;
                }
                if (j < n) {
                    sb.append(s.charAt(j));
                    j += cycle;
                }
            }
        }

        i = nRows - 1;
        while (i < n) {
            sb.append(s.charAt(i));
            i += cycle;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        Solution so = new Solution();
        System.out.println(so.convert("AB", 1));
    }
}