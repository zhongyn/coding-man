public class Solution1 {
    public int trap(int[] A) {
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;
        int a = 0;
        int b = A.length-1;

        while (a <= b) {
            leftMax = Math.max(leftMax, A[a]);
            rightMax = Math.max(rightMax, A[b]);
            if (leftMax < rightMax) {
                water += leftMax - A[a];
                a++;
            } else {
                water += rightMax - A[b];
                b--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[] high = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Solution1().trap(high)); 
    }
}