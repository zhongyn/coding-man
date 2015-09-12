public class Solution {
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        int tmp;
        for (int i = 0; i < n; i++) {
            while (A[i] > 0 && A[i] < n && A[A[i] - 1] != A[i]) {
                tmp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}

public class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int head = n;
        
        for (int i = n - 1; i > -1; i--) {
            if (s.charAt(i) != ' ' && head == n) {
                head = i;
            }

            if (s.charAt(i) == ' ' && head != n) {
                return head - i;
            }
        }

        if (head < n) {
            return head + 1;
        }

        return 0;
    }

    public int lengthOfLastWord(String s) {
        int p = s.length() - 1;
        while (p >= 0 && s.charAt(p) == ' ') {
            p--;
        }
        if (p < 0) {
            return 0;
        }
        int q = p;
        while (q >= 0 && s.charAt(q) != ' ') {
            q--;
        }
        return p - q;
    }
}