import java.util.*;
public class SumAreaTable {
    private int[][] table;

    public SumAreaTable(int row, int col) {
        table = new int[row + 1][col + 1];
    }

    public int sum(int x1, int y1, int x2, int y2) {
        return table[x1][y1] + table[x2][y2] - table[x1][y2] - table[x2][y1];
    }

    private int get(int x, int y) {
        return sum(x - 1, y - 1, x, y);
    }

    public void set(int x, int y, int val) {
        int diff = val - get(x, y);
        for (int i = x; i < table.length; i++) {
            for (int j = y; j < table[0].length; j++) {
                table[i][j] += diff;
            }
        }
    }

    public void printTable() {
        System.out.println(Arrays.deepToString(table));
    }

    public static void main(String[] args) {
        SumAreaTable so = new SumAreaTable(2, 2);
        so.set(1, 1, 1);
        so.set(1, 2, 2);
        so.set(2, 1, 3);
        so.set(2, 2, 4);
        so.printTable();
        System.out.println(so.sum(1, 1, 2, 2));
        
    }
}