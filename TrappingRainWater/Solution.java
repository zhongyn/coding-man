public class Solution {
    public int trap(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        int[] leftHighest = new int[A.length-2];
        int[] rightHighest = new int[A.length-2];
        leftHighest[0] = A[0];
        rightHighest[A.length-3] = A[A.length-1];

        for (int i = 1; i < A.length-2; i++) {
            leftHighest[i] = Math.max(A[i], leftHighest[i-1]);
        }

        for (int i = A.length-2; i > 1; i--) {
            rightHighest[i-2] = Math.max(A[i], rightHighest[i-1]);
        }

        int diffLeft;
        int diffRight;
        int water = 0;
        for (int i = 1; i < A.length-1; i++) {
            diffLeft = leftHighest[i-1] - A[i];
            diffRight = rightHighest[i-1] - A[i];
            if (diffLeft > 0 && diffRight > 0) {
                water += Math.min(diffRight, diffLeft);
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[] high = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Solution().trap(high)); 
    }
}