public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length - 1;
        int col = dungeon[0].length - 1;
        int[][] minhp = new int[row + 1][col + 1];
        minhp[row][col] = dungeon[row][col] > 0 ? 1 : -dungeon[row][col] + 1;

        for (int i = row - 1; i >= 0; i--) {
            minhp[i][col] = Math.max(minhp[i + 1][col] - dungeon[i][col], 1);
        }
        for (int i = col - 1; i >= 0; i--) {
            minhp[row][i] = Math.max(minhp[row][i + 1] - dungeon[row][i], 1);
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                int right = minhp[i][j + 1] - dungeon[i][j];
                int down = minhp[i + 1][j] - dungeon[i][j];
                minhp[i][j] = (right < 0 || down < 0) ? 1 : Math.min(down, right);
            }
        }
        return minhp[0][0];
    }

    // public int calculateMinimumHP(int[][] dungeon) {
    //     int row = dungeon.length;
    //     int col = dungeon[0].length;
    //     int[][] debt = new int[row][col];
    //     int[][] hp = new int[row][col];

    //     if (dungeon[0][0] <= 0) {
    //         debt[0][0] = dungeon[0][0] - 1;
    //         hp[0][0] = 1;
    //     } else {
    //         hp[0][0] = dungeon[0][0];
    //     }

    //     for (int i = 1; i < col; i++) {
    //         int tmp = hp[0][i - 1] + dungeon[0][i];
    //         if ( tmp <= 0) {
    //             debt[0][i] = debt[0][i - 1] + tmp - 1;
    //             hp[0][i] = 1;
    //         } else {
    //             debt[0][i] = debt[0][i - 1]; 
    //             hp[0][i] = tmp;
    //         }
    //     }

    //     for (int i = 1; i < row; i++) {
    //         int tmp = hp[i - 1][0] + dungeon[i][0];
    //         if ( tmp <= 0) {
    //             debt[i][0] = debt[i - 1][0] + tmp - 1;
    //             hp[i][0] = 1;
    //         } else {
    //             debt[i][0] = debt[i - 1][0]; 
    //             hp[i][0] = tmp;
    //         }
    //     }

    //     for (int i = 1; i < row; i++) {
    //         for (int j = 1; j < col; j++) {
    //             int up = hp[i - 1][j] + dungeon[i][j];
    //             int left = hp[i][j - 1] + dungeon[i][j];
    //             int updebt = up > 0 ? debt[i - 1][j] : debt[i - 1][j] + up - 1;
    //             int leftdebt = left > 0 ? debt[i][j - 1] : debt[i][j - 1] + left - 1;

    //             if (updebt > leftdebt) {
    //                 debt[i][j] = updebt;
    //                 hp[i][j] = up > 0 ? up : 1;
    //             } else if (updebt < leftdebt) {
    //                 debt[i][j] = leftdebt;
    //                 hp[i][j] = left > 0 ? left : 1;
    //             } else {
    //                 debt[i][j] = updebt;
    //                 hp[i][j] = up > left ? up : left;
    //                 if (hp[i][j] <= 0) {
    //                     hp[i][j] = 1;
    //                 }
    //             }
    //         }
    //     }

    //     int minDept = debt[row - 1][col - 1];
    //     return minDept >= 0 ? 1 : -minDept;
    // }

    public static void main(String[] args) {
        int[][] m = {{-2,-3,3}, {-5,-10,1}, {10,30,-5}};
        Solution so = new Solution();
        System.out.println(so.calculateMinimumHP(m));
    }
}