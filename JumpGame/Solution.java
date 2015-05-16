import java.util.*;

public class Solution {
    private int min;

    public int jump(int[] nums) {
        min = nums.length;
        jump(nums, 0, 0);
        return min;
    }

    public void jumpCount(int[] A, int first, int count) {
        if (count >= min) {
            return;
        }
        if (A[first] >= A.length - 1 - first) {
            min = count + 1;
            return;
        }
        for (int i = 1; i <= A[first]; i++) {
            jump(A, first + i, count + 1);
        }
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

    public static void main(String[] args) {
        int[] a = {2,3,1,1,4};
        int[] b = {3,2,1,0,4};
        int[] d = {0,2};
        int[] c = new int[500];

        Arrays.fill(c, 1);
        Solution so = new Solution();
        System.out.println(so.canJump1());
        // System.out.println(so.canJump(b));
        // System.out.println(so.canJump(d));
    }
}
