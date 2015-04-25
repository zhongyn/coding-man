public class CountAndSay {
    public String countAndSay(int n) {
        StringBuilder s = new StringBuilder("1");
        int count;
        char c;
        int len;

        for (int i = 1; i < n; i++) {
            len = s.length();
            c = s.charAt(0);
            count = 1;
            StringBuilder result = new StringBuilder();

            for (int j = 1; j < len; j++) {
                if (s.charAt(j) == c) {
                    count++;
                } else {
                    result.append(count);
                    result.append(c);
                    c = s.charAt(j);
                    count = 1;
                }
            }

            result.append(count);
            result.append(c);

            s = result;
            // s = result + Integer.toString(count) + c;
        }
        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(20));
    }
}