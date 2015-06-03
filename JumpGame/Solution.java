import java.util.*;

public class Solution {
    private int min;

    // public int jump(int[] nums) {
    //     min = nums.length;
    //     jump(nums, 0, 0);
    //     return min;
    // }

    // public void jumpCount(int[] A, int first, int count) {
    //     if (count >= min) {
    //         return;
    //     }
    //     if (A[first] >= A.length - 1 - first) {
    //         min = count + 1;
    //         return;
    //     }
    //     for (int i = 1; i <= A[first]; i++) {
    //         jump(A, first + i, count + 1);
    //     }
    // }

    // public int jump(int[] nums) {
    //     int len = nums.length;
    //     int[] minJump = new int[len];
    //     Arrays.fill(minJump, -1);
    //     minJump[0] = 0;

    //     for (int i = 0; i < len; i++) {
    //         for (int j = 1; j <= nums[i] && i + j < len; j++) {
    //             if (minJump[i + j] == -1) {
    //                 minJump[i + j] = minJump[i] + 1;
    //                 if (i + j == len - 1) {
    //                     return minJump[len - 1];
    //                 }
    //             }
    //         }
    //     }
    //     return minJump[len - 1];
    // }

    public int jump(int[] nums) {
        int reachable = 0;
        int minStep = 0;
        int preEnd = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > preEnd) {
                minStep++;
                preEnd = reachable;
            }
            reachable = Math.max(reachable, nums[i] + i);
        }
        return minStep;
    }

    public static void main(String[] args) {
        int[] a = {2,3,1,1,4};
        int[] b = {1,2};
        int[] c = new int[9];

        Arrays.fill(c, 1);
        Solution so = new Solution();
        // System.out.println(so.canJump1());
        // System.out.println(so.canJump(b));
        System.out.println(so.jump(a));
        System.out.println(so.jump(b));
        System.out.println(so.jump(c));

    }
    public boolean canJump2(int[] nums) {
        if (nums.length == 1) {
            return true;
        } else if (nums[0] == 0) {
            return false;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums.length - 1 - i) {
                return true;
            }
            if (nums[i] == 0) {
                int j = i + 1;
                while (nums[j] == 0 && j < nums.length - 1) {
                    j++;
                }
                for (int k = i - 1; k >= 0; k--) {
                    if (nums[k] >= j - k) {
                        i = j - 1;
                        break;
                    }
                    if (k == 0) {
                        return false;
                    }
                }
            }
        }
        return false;
    }


    public boolean canJump(int[] nums) {
        int i = 0;
        int reach = 0;
        while (i <= reach && reach < nums.length) {
            reach = Math.max(nums[i] + i, reach);
            i++;
        }
        return reach >= nums.length - 1;
    }


}
