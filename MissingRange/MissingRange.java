import java.util.*;

public class MissingRange {
    public List<String> missingRange(int[] range) {
        List<String> miss = new ArrayList<>();
        if (range.length == 0) {
            insert(miss, 0, 99);
            return miss;
        } 

        insert(miss, 0, range[0] - 1);
        for (int i = 0; i < range.length - 1; i++) {
            insert(miss, range[i] + 1, range[i + 1] - 1);
        }
        insert(miss, range[range.length - 1] + 1, 99);

        return miss;
    }

    public void insert(List<String> list, int a, int b) {
        if (a == b) {
            list.add(Integer.toString(a));
        }
        if (a < b) {
            list.add(a + "->" + b);
        }
    }

    public static void main(String[] args) {
        int[] a = {2,5,56,78,89};
        MissingRange so = new MissingRange();
        System.out.println(so.missingRange(a));
    }
}