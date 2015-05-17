import java.util.*;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long a = Math.abs((long)numerator);
        long b = Math.abs((long)denominator);
        List<String> ls = new ArrayList<>();
        Map<Long, Integer> explored = new HashMap<>();

        long head = a / b;
        a %= b;

        int i = 0;
        while (a != 0) {
            String c = "";
            while (a < b) {
                a *= 10;
                c += '0';
            }
            if (explored.containsKey(a)) {
                int id = explored.get(a);
                String begin = ls.get(id);
                int last = begin.lastIndexOf(c + (a / b));
                begin = begin.substring(0, last) + "(" + begin.substring(last);
                ls.set(id, begin);
                ls.add(")");
                break;
            }
            explored.put(a, i);
            i++;
            ls.add(c + (a / b));
            a %= b;
            a *= 10;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(head);

        if (ls.size() > 0) {
            sb.append('.');
            String begin = ls.get(0).substring(1);
            ls.set(0, begin);
        }

        for (String s : ls) {
            sb.append(s);
        }

        String result = sb.toString();
        return ((numerator ^ denominator) < 0 && !result.equals("0")) ? ("-" + result) : result;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.fractionToDecimal(-2147483648, -1999));
        // System.out.println(so.fractionToDecimal(1, 90));
        System.out.println(so.fractionToDecimal(-2, -3));
        System.out.println(2147483648.0 / 1999);
    }
}