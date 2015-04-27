import java.util.*;

public class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> newPath = new ArrayList<>();

        int j = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                j = i;
            } else if (i == path.length() - 1 || path.charAt(i + 1) == '/') {
                String s = path.substring(j + 1, i + 1);
                // System.out.println(s);
                // System.out.println(newPath);
                if (s.equals("..")) {
                    if (newPath.size() > 0) {
                        newPath.remove(newPath.size() - 1);
                    }
                } else if (!s.equals(".")) {
                    newPath.add(s);
                }
                j = i + 1;
            }
        }

        for (String s : newPath) {
            sb.append('/');
            sb.append(s);
        }
        if (sb.length() == 0) {
            sb.append('/');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "/abc///./bn/.//";
        Solution so = new Solution();
        System.out.println(so.simplifyPath("/.."));
    }

}