public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int aL = 0;
        int aR = A.length - 1;
        int bL = 0;
        int bR = B.length - 1;

        int am, bm, aLen, bLen;

        while ((aL < aR) || (bL < bR)) {
            am = (aL + aR) / 2;
            bm = (bL + bR) / 2;

            System.out.println("aL: " + aL);
            System.out.println("aR: " + aR);
            System.out.println("bL: " + bL);
            System.out.println("bR: " + bR);
            System.out.println("am: " + am);
            System.out.println("bm: " + bm);
            
            aLen = aR - aL + 1;
            bLen = bR - bL + 1;

            if (A[am] == B[bm]) {
                if (aLen % 2 == 1 || bLen % 2 == 1 ) {
                    return A[am];
                }

                if (A[am + 1] < B[bm + 1]) {
                    return (A[am] + A[am + 1]) / 2.0;
                } else {
                    return (B[bm] + B[bm + 1]) / 2.0;
                }
                 
            } else if (A[am] < B[bm]) {
                if (aLen == bLen) {
                    aL = am + 1;
                    bR = bm - 1;
                } else if (aLen < bLen) {
                    aL = am + 1;
                    bR = bR - (aLen + 1) / 2;
                } else {
                    aL = aL + (bLen + 1) / 2;
                    bR = bm - 1;
                }
            } else {
                if (aLen == bLen) {
                    bL = bm + 1;
                    aR = am - 1;
                } else if (bLen < aLen) {
                    bL = bm + 1;
                    aR = aR - (bLen + 1) / 2;
                } else {
                    bL = bL + (aLen + 1) / 2;
                    aR = am - 1;
                }
            }
        }

        if (aL == aR || bL == bR) {
            return (A[aL] + B[bL]) / 2.0;
        } else if (aL < aR) {
            return (B[bL] + B[bR]) / 2.0;
        } else {
            return (A[aL] + A[aR]) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] A = {1,3,3};
        int[] B = {1,2,3};
        Solution s = new Solution();
        double re = s.findMedianSortedArrays(A, B);
        System.out.println("result: " + re);
    }
}