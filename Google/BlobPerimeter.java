import java.util.*;

class BlobPerimeter {
    public List<Integer> blobPerimeter(char[][] table) {
        List<Integer> res = new ArrayList<>();
        if (table.length == 0 || table[0].length == 0) {
            return res;
        }

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (table[i][j] == '1') {
                    res.add(dfs(table, i, j));
                }
            }
        }
        return res;
    }

    private int dfs(char[][] table, int x, int y) {
        if (x < 0 || y < 0 || x == table.length || y == table[0].length || table[x][y] == '0') {
            return 1;
        }
        if (table[x][y] == '2') {
            return 0;
        }
        table[x][y] = '2';
        return dfs(table, x + 1, y) + dfs(table, x - 1, y) + dfs(table, x, y + 1) + dfs(table, x, y - 1);
    }

    public static void main(String[] args) {
        char[][] table = {{'1', '0', '0'}, {'0', '1', '1'}, {'0', '0', '0'}};
        BlobPerimeter so = new BlobPerimeter();
        System.out.println(so.blobPerimeter(table)); 
    }
}