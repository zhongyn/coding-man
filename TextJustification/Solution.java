import java.util.*;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int start = 0;
        int end = 0;
        int sum = 0;
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            sum += words[i].length();
            if (sum >= maxWidth) {
                end = sum > maxWidth ? --i : i;
                result.add(makeLine(words, maxWidth, start, end));
                start = end + 1;
                sum = 0;
            } else {
                sum += 1;
            }
        }

        if (start < words.length) {
            result.add(leftJustify(words, maxWidth, start, words.length - 1));
        }
        return result;
    }

    public String makeLine(String[] words, int maxWidth, int start, int end) {
        int sum = 0;
        int size = end - start;
        if (size == 0) {
            return leftJustify(words, maxWidth, start, end);
        }

        for (int i = start; i <= end; i++) {
            sum += words[i].length();
        }

        int emptySum = maxWidth - sum;
        StringBuilder sb = new StringBuilder();

        int base = emptySum / size;
        int remain = emptySum % size;

        String baseEmpty = emptySlot(base);
        String remainEmpty = baseEmpty + ' ';

        for (int i = start; remain != 0 && i < start + remain; i++) {
            sb.append(words[i]);
            sb.append(remainEmpty);
        }
        for (int i = start + remain; i < end; i++) {
            sb.append(words[i]);
            sb.append(baseEmpty);
        }
        sb.append(words[end]);
        return sb.toString();
    }

    public String leftJustify(String[] words, int maxWidth, int start, int end) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(words[i]);
            sb.append(' ');
            sum += words[i].length();
            sum++;
        }
        if (sum < maxWidth) {
            sb.append(emptySlot(maxWidth - sum));
        } else if (sum > maxWidth) {
            sb.deleteCharAt(maxWidth);
        }
        return sb.toString();
    }

    public String emptySlot(int n) {
        char[] s = new char[n];
        Arrays.fill(s, ' ');
        return new String(s);
    }

    public static void main(String[] args) {
        String[] w = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] a = {"Listen","to","many,","speak","to","a","few."};
        String[] b = {"My","momma","always","said,","\"Life","was","like","a","box","of","chocolates.","You","never","know","what","you're","gonna","get."};
        Solution so = new Solution();
        // System.out.println(so.fullJustify(w, 16));
        // System.out.println(so.fullJustify(a, 6));
        System.out.println(so.fullJustify(b, 20));
    }
}