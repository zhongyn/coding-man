import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int[] array = new int[nums.length];
        int idx;
        for (int i = 0; i < nums.length; i++) {
            idx = (i+k) % nums.length;
            array[idx] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = array[i];
        }
        System.out.println(Arrays.toString(array));
    }

    public void rotateBits(int a, int k) {
        System.out.println(Integer.toBinaryString(a));
        int b = a & ((1 << k) - 1);
        int c = (b << (32-k)) | (a >>> k);
        System.out.println(Integer.toBinaryString(c));
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        // new RotateArray().rotate(a, 3);
        RotateArray ra = new RotateArray();
        ra.rotateBits(-3, 32);
    }
}