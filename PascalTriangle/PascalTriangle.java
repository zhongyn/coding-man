import java.util.*;

public class PascalTriangle {
    public List<Integer> getRow(int k) {
        ArrayList<Integer> line = new ArrayList<Integer>();
        line.add(1);

        int range;

        for (int i = 2; i < k + 1; i++) {
            range = line.size() - 1;

            if (i % 2 == 0) {
                line.add(line.get(line.size() - 1) * 2);
            }

            for (int j = range; j > 0; j--) {
                line.set(j, line.get(j) + line.get(j - 1));
            }
        }

        range = k % 2 == 0? line.size() - 1 : line.size();

        for (int i = 0; i < range; i++) {
            line.add(line.get(range - i - 1));
        }
        return line;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        list.add(a);

        ArrayList<Integer> b;

        for (int i = 1; i < numRows; i++) {
            b = new ArrayList<Integer>();
            b.add(1);
            for (int j = 0; j < a.size() - 1; j++) {
                b.add(a.get(j) + a.get(j + 1));
            }
            b.add(1);
            list.add(b);
            a = b;
        }

        return list;
    }

    public static void main(String[] args) {
        int idx = 6;
        PascalTriangle pt = new PascalTriangle();
        List<Integer> re = pt.getRow(idx);
        System.out.println(re);
        List<List<Integer>> aa = pt.generate(idx);

    }
}