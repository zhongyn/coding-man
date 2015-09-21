public class LongestConsecutivePath {
    class Node {
        int x;
        int y;
        int maxEndHere = 1;

        public Node(int i, int j) {
            x = i;
            y = j;
        }
    }

    public final static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public int lcp(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int size = rows * cols;

        Node[] map = new Node[size];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                map[grid[i][j] - 1] = new Node(i, j);
            }
        }

        // worst case: 4 * n^2

        int maxLen = 1;
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < dir.length; j++) {
                int x = map[i].x + dir[j][0];
                int y = map[i].y + dir[j][1];
                if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == i) {
                    map[i].maxEndHere = map[grid[x][y] - 1].maxEndHere + 1;
                    if (map[i].maxEndHere > maxLen) {
                        maxLen = map[i].maxEndHere;
                    }
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestConsecutivePath so = new LongestConsecutivePath();
        int[][] a = {{1,3,5},{2,4,6},{9,8,7}};
        System.out.println(so.lcp(a));
    }
}