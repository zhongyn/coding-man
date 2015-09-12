import java.util.*;
public class SeparateNum {
    public String separate(String s) {
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < s.length(); j++) {
            sb.append(s.charAt(j));
            if (j == s.length() - 1 || s.charAt(j + 1) - s.charAt(j) != 1) {
                sb.append(';');
            } 
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SeparateNum so = new SeparateNum();
        System.out.println(so.separate("4678912356012356"));
    }
}