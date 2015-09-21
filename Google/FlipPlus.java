import java.util.*;
public class FlipPlus {
    public List<List<String>> flip(String s) {
        List<List<String>> res = new ArrayList<>();
        if (gameover(s)) {
            res.add(new ArrayList<>());
            res.get(0).add(s);
            return res;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String f = s.substring(0, i) + "--" + s.substring(i + 2, s.length());
                for (List<String> ls : flip(f)) {
                    ls.add(s);
                    res.add(ls);
                }
            }
        }
        return res;
    }

    public boolean gameover(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                return false;
            }
        }       
        return true; 
    }

    public List<List<String>> flip1(String s) {
        List<List<List<String>>> dp = new ArrayList<>(s.length() + 1);
        dp.add(new ArrayList<>());
        dp.add(new ArrayList<>());
        dp.get(0).add(new ArrayList<>());
        dp.get(1).add(new ArrayList<>());
        // System.out.println(dp);

        for (int i = 1; i < s.length(); i++) {
            dp.add(new ArrayList<>());
            if (s.charAt(i) == '+') {
                if (s.charAt(i - 1) == '+') {
                    String f = s.substring(0, i - 1) + "--" + s.substring(i + 1, s.length());
                    for (List<String> ls : dp.get(i - 1)) {
                        for (int j = 0; j <= ls.size(); j++) {
                            List<String> copy = new ArrayList<>(ls);
                            copy.add(j, f);
                            // System.out.println(copy);
                            dp.get(i + 1).add(copy);
                        }
                     }
                }
            }
            dp.get(i + 1).addAll(dp.get(i));
        }
        // System.out.println(dp);
        return dp.get(s.length());

    }

    public static void main(String[] args) {
        FlipPlus so = new FlipPlus();
        String s = "+++--++-+";
        List<List<String>> res = so.flip(s);
        for (List<String> ls : res) {
            System.out.println(ls);
        }
    }
}