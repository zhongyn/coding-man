public class FindMinSortedArray {
    public int findMin(int[] num) {
        int a = 0;
        int b = num.length - 1;
        int c;

        while (a != b) {
            if (num[a] < num[b]) {
                return num[a];
            }
            c = (a + b) / 2;
            System.out.println("a"+a);
            System.out.println("b"+b);
            System.out.println("c"+c);
            if (num[c] >= num[a]) {
                a = c + 1;
            } else {
                b = c;
            }
        }
        return num[a];
    }

    public int findMin1(int[] num) {
        int a = 0;
        int b = num.length - 1;
        int c;

        while (a != b) {
            if (num[a] < num[b]) {
                return num[a];
            }
            c = (a + b) / 2;
            System.out.println("a"+a);
            System.out.println("b"+b);
            System.out.println("c"+c);
            if (num[c] >= num[a]) {
                a = num[a] == num[b] ? a+1 : c + 1;
            } else {
                b = c;
            }
        }
        return num[a];
    }

    public int search(int[] A, int target) {
        int a = 0;
        int b = A.length - 1;
        int c;

        while (a != b) {
            c = (a + b) / 2;
            System.out.println("a"+a);
            System.out.println("b"+b);
            System.out.println("c"+c);
            
            if (A[c] == target) {
                return c;
            } else if (A[c] < target) {
                if (A[a] > A[b] && A[c] <= A[b] && target >= A[a]) {
                    b = c;
                } else {
                    a = c + 1;
                }
            } else {
                if (A[a] > A[b] && A[c] >= A[a] && target <= A[b]) {
                    a = c + 1;
                } else {
                    b = c;
                }
            }
        }
        return A[a] == target? a : -1;        
    }

    public boolean search1(int[] num, int target) {
        int a = 0;
        int b = num.length - 1;
        int c;

        while (a != b) {
            if (num[a] < num[b]) {
                break;
            }
            c = (a + b) / 2;
            if (num[c] >= num[a]) {
                a = num[a] == num[b] ? a + 1 : c + 1;
            } else {
                b = c;
            }
        }

        int min = a;
        while (min > 0 && num[min] == num[min-1]) {
             min--;
        }
        
        System.out.println(min);

        a = 0;
        b = num.length - 1;

        if (min > 0) {
            if (target <= num[b]) {
                a = min;
            } else if (target <= num[min-1]) {
                b = min - 1;
            }
        }

        while (b > a) {
            c = (a + b) / 2;
            if (num[c] == target) {
                return true;
            } else if (num[c] < target) {
                a = c + 1;
            } else {
                b = c;
            }
        }

        return num[a] == target;
    }

    public boolean search2(int[] A, int target) {

        int a = 0;
        int b = A.length - 1;
        int c;

        while (a != b) {
            c = (a + b) / 2;
            System.out.println("a"+a);
            System.out.println("b"+b);
            System.out.println("c"+c);
            
            if (A[c] == target) {
                return true;
            } else if (A[c] < target) {
                if (A[a] > A[b] && A[c] <= A[b] && target >= A[a]) {
                    b = c;
                } else {
                    a = A[a] == A[b]? a + 1 : c + 1;
                }
            } else {
                if (A[a] > A[b] && A[c] >= A[a] && target <= A[b]) {
                    a = c + 1;
                } else {
                    b = A[a] == A[b]? b - 1 : c;
                }
            }
        }

        return A[a] == target;        

    }

    public static void main(String[] args) {
        int[] a = {2,1,2,2,2};
        int[] b = {3,3,1};
        int[] A = {3,4,5,0,1,2};
        int[] B = {1,3,5};
        int[] C = {0,1,1,2,0,0};
        FindMinSortedArray ra = new FindMinSortedArray();
        // System.out.println(new FindMinSortedArray().findMin(new int[] {3,4,5,0,1,2}));
        // System.out.println(new FindMinSortedArray().findMin(a));
        // System.out.println(new FindMinSortedArray().findMin1(a));
        System.out.println(ra.search2(C, 4));
    }
}