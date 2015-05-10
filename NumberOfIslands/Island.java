import java.util.*;

class Node {
    int x;
    int y;
    public Node(int nx, int ny) {
        x = nx;
        y = ny;
    }
}

public class Island {

    public int numIslands(char[][] grid) {
        int count = 0;
        Node one = hasIsland(grid);
        Queue<Node> frontier = new LinkedList<>();

        while (one != null) {
            frontier.add(one);
            while (!frontier.isEmpty()) {
                Node cur = frontier.remove();
                grid[cur.x][cur.y] = '0';
                frontier.addAll(getChildren(cur, grid));
            }
            count++;
            one = hasIsland(grid);
        }
        return count;
    }

    public List<Node> getChildren(Node node, char[][] grid) {
        List<Node> children = new ArrayList<>();
        int x = node.x;
        int y = node.y;

        if (x > 0 && grid[x - 1][y] == '1') {
            children.add(new Node(x - 1, y));
        }
        if (x < grid.length - 1 && grid[x + 1][y] == '1') {
            children.add(new Node(x + 1, y));
        }
        if (y > 0 && grid[x][y - 1] == '1') {
            children.add(new Node(x, y - 1));
        }
        if (y < grid[0].length - 1 && grid[x][y + 1] == '1') {
            children.add(new Node(x, y + 1));
        }
        return children;
    }

    public Node hasIsland(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    return new Node(i, j);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','0'},{'0','0','1'},{'1','0','0'}};
        Island so = new Island();
        System.out.println(so.numIslands(grid));
    }
}