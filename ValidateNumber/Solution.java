public class Solution {
    // negative number
    // float point
    // scientific notation
    // leading and trailing space
    private final static Set<Character> num = 
        new HashSet<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'e', '.', '-', '+'));

    public boolean isNumber(String s) {
        int eCount = 0;
        int dotCount = 0;
        int digitCount = 0;
        Character lastNonSpace = null;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            } else if (!num.contains(c)) {
                return false;
            } else if (isDigit(c)) {
                if (lastNonSpace != null && s.charAt(i - 1) == ' ') {
                    return false;
                }
                digitCount++;
            } else if (c == '-' || c == '+') {
                if (lastNonSpace != null && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else if (c == 'e') {
                eCount++;
                if (lastNonSpace == null || (lastNonSpace == '.' && digitCount == 0) || (!isDigit(lastNonSpace) && lastNonSpace !='.') || eCount > 1 || s.charAt(i - 1) == ' ') {
                    return false;
                }
            } else if (c == '.') {
                dotCount++;                
                if ((lastNonSpace != null && (lastNonSpace == 'e' || s.charAt(i - 1) == ' ')) || dotCount > 1 || eCount > 0) {
                    return false;
                }
            }
            lastNonSpace = c;
        }

        if (lastNonSpace == null || digitCount == 0) {
            return false;
        }

        return lastNonSpace == '.' || isDigit(lastNonSpace);
    }

    public boolean isDigit(char a) {
        return a >= '0' && a  <= '9';
    }


}