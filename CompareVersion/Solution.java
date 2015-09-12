import java.util.*;
public class Solution {
    public int compareVersion(String version1, String version2) {
        int a = version1.length();
        int b = version2.length();
        int n = a < b ? a : b;
        char c, d;

        for (int i = 0; i < n; i++) {
            c = version1.charAt(i);
            d = version2.charAt(i);
            if (c != '.' && d != '.') {
                if (c > d) {
                    return 1;
                } else if (c < d) {
                    return -1;
                }
            }

            if (c != '.' && d == '.') {
                return 1;
            }
            if (c == '.' && d != '.') {
                return -1;
            }
        }

        if (a > b) {
            return 1;
        } else if (a < b) {
            return -1;
        } else {
            return 0;
        }
    }

    public int compareVersion1(String version1, String version2) {
        int a = 0;
        int b = 0;
        char c, d;
        int v1 = 0;
        int v2 = 0;

        while (a < version1.length() || b < version2.length()) {
            c = version1.charAt(a);
            d = version2.charAt(b);

            if (c != '.' && d != '.') {
                v1 = v1 * 10 + c -'0';
                v2 = v2 * 10 + d -'0';
                a++;
                b++;
            } else if (c == '.' && d != '.') {
                v2 = v2 * 10 + d -'0';
                b++;
            } else if (c != '.' && d == '.') {
                v1 = v1 * 10 + c -'0';
                a++;
            } else {
                if (v1 > v2) {
                    return 1;
                } else if (v1 < v2) {
                    return -1;
                } else {
                    v1 = 0;
                    v2 = 0;
                    a++;
                    b++;
                }
            }
        }

        if (version1.length() > version2.length()) {
            return 1;
        } else if (version1.length() < version2.length()) {
            return -1;
        } else {
            return 0;
        }

    }

    public int compareVersion2(String version1, String version2) {
        ArrayList<Integer> v1 = new ArrayList<Integer>();
        ArrayList<Integer> v2 = new ArrayList<Integer>();

        getVersion(v1, version1);
        getVersion(v2, version2);

        int a = v1.size();
        int b = v2.size();
        int n = a < b? a : b;

        for (int i = 0; i < n; i++) {
            if (v1.get(i) > v2.get(i)) {
                return 1;
            } else if (v1.get(i) < v2.get(i)) {
                return -1;
            }
        }

        if (a > b) {
            return 1;
        } else if (a < b) {
            return -1;
        }
        // if (a > b && !isZero(v1, b)) {
        //     return 1;
        // } else if (a < b && !isZero(v2, a)) {
        //     return -1;
        // }
        return 0;
    }

    public void getVersion(List<Integer> v, String s) {
        char c;
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c != '.') {
                n = n * 10 + c - '0';
            } else {
                v.add(n);
                n = 0;
            }
        }
        v.add(n);

        int i = v.size() - 1;
        while (v.get(i) == 0) {
            v.remove(i);
            i--;
        }
    }

    // public boolean isZero(List<Integer> v, int a) {
    //     for (int i = a; i < v.size(); i++) {
    //         if (v.get(i) != 0) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    public class VersionComparator implements Comparator<String, String> {
        public int compare(String s1, String s2) {
            return compareVersion(s1, s2);
        }
    }

    public void sortVersion(String[] s) {
        Arrays.sort(s, new VersionComparator());
    }

    public static void main(String[] args) {
        String a = "1.3";
        String b = "3.4.5";
        String c = "3.4.0005";
        String e = "1.3.0";
        Solution s = new Solution();
        System.out.println(s.compareVersion2(a, e));
    }
}