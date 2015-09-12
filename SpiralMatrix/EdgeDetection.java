import java.util.*;
public class EdgeDetection {

    private final static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public int[] detect(int[] image, int w, int h, int threshold) {
        if (image.length < 1 || image.length != w * h) {
            System.out.println("Invalid input");
            return null;
        }

        int[] display = new int[image.length];

        for (int i = 0; i < image.length; i++) {
            int maxdiff = 0;
            for (int d = 0; d < dir.length; d++) {
                int x = i / h + dir[d][0];
                int y = i % h + dir[d][1];
                if (x >= 0 && x < w && y >=0 && y < h) {
                    int diff = Math.abs(image[i] - image[x * h + y]);
                    maxdiff = Math.max(diff, maxdiff);
                }
            }
            if (maxdiff > threshold) {
                display[i] = image[i];
            }
        }
        return display;
    }


    public static void main(String[] args){
        int[] image = {
                1,1,1,1,1,
                1,9,1,1,1,
                1,1,1,1,1,
                1,1,1,1,1,
                1,1,1,1,1,};
        EdgeDetection so = new EdgeDetection();
        System.out.println(Arrays.toString(so.detect(image, 5, 5, 2)));
        
    }
}