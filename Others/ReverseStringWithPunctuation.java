import java.util.*;

public class ReverseStringWithPunctuation {
    public String reverse(String s) {
        List<String> words = new ArrayList<>();

        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (j == s.length() - 1 ||
                (Character.isLetter(s.charAt(j)) && !Character.isLetter(s.charAt(j + 1))) ||
                (!Character.isLetter(s.charAt(j)) && Character.isLetter(s.charAt(j + 1)))) {
                words.add(s.substring(i, j + 1));
                i = j + 1;                
            }
        }

        int lh = 0;
        int rh = words.size() - 1;

        while (lh < rh) {
            if (!Character.isLetter(words.get(lh).charAt(0))) {
                lh++;
            } else if (!Character.isLetter(words.get(rh).charAt(0))) {
                rh--;
            } else {
                String tmp = words.get(lh);
                words.set(lh, words.get(rh));
                words.set(rh, tmp);
                lh++; rh--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(w);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseStringWithPunctuation so = new ReverseStringWithPunctuation();
        System.out.println(so.reverse("this...is?//a;;word  "));

    }
}