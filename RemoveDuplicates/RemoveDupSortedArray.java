import java.util.*;
public class RemoveDupSortedArray {
    public int removeDuplicates(int[] A) {
        int i = A.length - 1;
        int len = A.length;

        while (i >= 0) {
            int j = i;
            while (j >= 1 && A[j] == A[j-1]) {
                j--;
            }
            if (j != i) {
                move(A, j + 1, i + 1, len);
            }
            len -= (i - j);
            i = j;
            i--;
        }

        return len;
    }

    public void move(int[] A, int a, int b, int len) {
        int diff = b - a;
        for (int i = b; i < len; i++) {
            A[i - diff] = A[i];  
        }
    }

    public int removeDuplicates1(int[] A) {
        int len = A.length;
        int i = 1;
        int j = 1;

        while (i < len) {
            while (j < A.length && A[j] <= A[i - 1]) {
                j++;
            }
            if (i < j && j < A.length) {
                A[i] = A[j];
            }
            len = A.length - (j - i);
            i++;
        }

        return len;
    }

    public int removeDuplicates2(int[] A) {
        if (A.length < 2) {
            return A.length;
        }
        int id = 1;
        // int count = A[0] == A[1] ? 1 : 0;
        int count = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i - 1]) {
                A[id++] = A[i];
                count = 1;
            } else {
                if (count == 1) {
                    A[id++] = A[i];
                }
                count++;
            }
        }
        return id;
    }
    
    public static void main(String[] args) {
        int[] a = {1,1,1,2,3,4,8,8,8,8,9,9};
        int[] b = {1,1};
        RemoveDupSortedArray s = new RemoveDupSortedArray();
        System.out.println(s.removeDuplicates2(a));
        System.out.println(Arrays.toString(a));
    }
}