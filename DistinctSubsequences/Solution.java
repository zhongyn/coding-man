public class Solution {
    public int numDistinct(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        int[][] table = new int[slen + 1][tlen + 1];

        for (int i = 0; i <= slen; i++) {
            table[i][0] = 1;
            for (int j = 1; j <= i && j <= tlen; j++) {
                if (s.charAt(i - 1) != t.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j];
                } else {
                    table[i][j] = table[i - 1][j - 1] + table[i - 1][j];
                }
            }
        }
        return table[slen][tlen];
    }

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabit";
        Solution so = new Solution();
        System.out.println(so.numDistinct(s, t));
    }
}