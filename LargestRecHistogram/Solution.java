public class Solution {
    public int largestRectangleArea1(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            int minH = height[i];
            for (int j = 0; j < height.length - i; j++) {
                minH = Math.min(minH, height[i + j]);
                maxArea = Math.max(maxArea, minH * (j + 1));
            }
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] height) {
        return divide(height, 0, height.length - 1);
    }

    public int divide(int[] h, int start, int end) {
        if (start > end) {
            return 0;
        }

        int lo = start;
        int loh = h[start];
        for (int i = start; i <= end; i++) {
            lo = h[i] < loh ? i : lo;
        }

        int a = divide(h, start, lo - 1);
        int b = divide(h, lo + 1, end);
        return Math.max(Math.max(a, b), h[lo] * (end - start + 1));
    }

    public static void main(String[] args) {
        int[] a = {1,2,1};
        Solution so = new Solution();
        System.out.println(so.largestRectangleArea(a));
    }
}