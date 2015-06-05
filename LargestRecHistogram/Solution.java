import java.util.*;
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

    public int largestRectangleArea2(int[] height) {
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

    public int largestRectangleArea3(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                int h = height[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, h * (i - left - 1));
            }
            stack.push(i);
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int len = height.length;
        stack.push(-1);
        int maxArea = 0;

        for (int i = 0; i <= len; i++) {
            int h = i == len ? 0 : height[i];
            while (stack.size() > 1 && height[stack.peek()] > h) {
                int hei = height[stack.pop()];
                maxArea = Math.max(maxArea, hei * (i - stack.peek() - 1));
                // System.out.println("i: " + i);
                // System.out.println("maxArea: " + maxArea);
                // System.out.println();
            }
            while (i < len - 1 && height[i] == height[i + 1]) {
                i++;
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] a = {0,1,0,1};
        int[] b = {5,5,1,7,1,1,1,1,1,1,5,2,7,6};
        Solution so = new Solution();
        // System.out.println(so.largestRectangleArea(a));
        System.out.println(so.largestRectangleArea(b));
    }
}