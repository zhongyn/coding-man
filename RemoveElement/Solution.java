public class Solution {
    public int removeElement(int[] A, int elem) {
        if (A.length == 0) {
            return 0;
        }
        int a = 0;
        int b = A.length - 1;
        int len = A.length;
        
        while (a <= b) {
            if (A[a] != elem) {
                a++;
            } else if (A[b] != elem) {
                A[a] = A[b];
                len--;
                a++;
                b--;
            }
            if (A[b] == elem) {
                len--;
                b--;
            }
        }

        if (A[0] == elem) {
            len = 0;
        }
        return len;
    }

    public static void main(String[] args) {
        int[] a = {5,5};
        Solution s = new Solution();
        System.out.println(s.removeElement(a, 5));
    }
}