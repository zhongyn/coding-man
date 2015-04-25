public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        } else if (haystack.length() == 0) {
            return -1;
        }
        
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            boolean start = false;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    start = false;
                    break;
                } else {
                    start = true;
                }
            }
            if (start) {
                return i;
            }
        }
        return -1;
    }
}