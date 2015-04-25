import java.util.Arrays;

public class RotateImage {

    public int[][] m;

    public void rotate(int[][] matrix) {
        // rotation matrix
        // x' = x * cos(a) - y * sin(a)
        // y' = x * sin(a) + y * cos(a)
        // a = -90 degree, clockwise, x' = y, y' = n - x
        // counter-clockwise, x' = n - y, y' = x
        int tmp;
        int a, b, c, d;
        int n = matrix.length;

        int xrange = n / 2;
        int yrange = n / 2;
        if (n % 2 == 1) {
            xrange++;
        }

        for (int i = 0; i < xrange; i++) {
            for (int j = 0; j < yrange; j++) {
                c = i;
                d = j;
                tmp = matrix[c][d];
                System.out.println("tmp: " + c + d);
                for (int k = 0; k < 3; k++) {
                    a = n - d - 1;
                    b = c;
                    System.out.println("a: " + a);
                    System.out.println("b: " + b);
                    System.out.println("c: " + c);
                    System.out.println("d: " + d);
                    matrix[c][d] = matrix[a][b];
                    System.out.println(matrix[c][d]);
                    System.out.println();
                    c = a;
                    d = b;
                }
                System.out.println("c,d: " + c + d);
                matrix[c][d] = tmp;
            }
        }
    }

    public void rotate1(int[][] matrix) {
        // divide and conquer
        int n = matrix.length;
        m = matrix;
        divideRotate(0, n-1, 0, n-1);
    }

    public void divideRotate(int xL, int xR, int yL, int yR) {
        if (xL == xR && yL == yR) {
            return;
        }

        int xM = (xL + xR) / 2;
        int yM = (yL + yR) / 2;
        divideRotate(xL, xM, yL, yM);
        divideRotate(xL, xM, yM + 1, yR);
        divideRotate(xM + 1, xR, yL, yM);
        divideRotate(xM + 1, xR, yM + 1, yR);
        translate(xL, xR, yL, yR);
    }

    public void translate(int xL, int xR, int yL, int yR) {
        int tmp;
        int x1, x2, y1, y2;
        int tr = (xR - xL) / 2 + 1; // translation

        for (int i = 0; i < tr; i++) {
            for (int j = 0; j < tr; j++) {
                x1 = xL + i;
                x2 = x1 + tr;
                y1 = yL + j;
                y2 = y1 + tr;
                tmp = m[x1][y1];
                m[x1][y1] = m[x2][y1];
                m[x2][y1] = m[x2][y2];
                m[x2][y2] = m[x1][y2];
                m[x1][y2] = tmp;
            }
        }
    }

    public void test(int[][] ma) {
        System.out.println(Arrays.toString(ma[0]));
        // rotate(ma);
        rotate1(ma);
        System.out.println(Arrays.toString(ma[0]));        
    }

    public static void main(String[] args) {
        int[][] ma = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] mb = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        int[][] mc = {{1,2}, {3,4}};
        RotateImage ri = new RotateImage();
        ri.test(ma);
    }
}