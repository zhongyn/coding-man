public class Sudoku {
    public boolean isValidSudoku(char[][] board) {
        int len = board.length;
        ArrayList<Character> list = new ArrayList<Character>();
        char c;

        for (int i = 0; i < len; i++) {
            list.clear();
            for (int j = 0; j < len; j++) {
                c = board[i][j];
                if (c != '.') {
                    if (list.contains(c)) {
                        return false;                  
                    } else {
                        list.add(c);
                    }   
                }                     
            }
        }

        for (int i = 0; i < len; i++) {
            list.clear();
            for (int j = 0; j < len; j++) {
                c = board[j][i];
                if (c != '.') {
                    if (list.contains(c)) {
                        return false;                  
                    } else {
                        list.add(c);
                    }   
                }                     
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                list.clear();
                for (int k = 0; k < 3; k++) {
                    for (int m = 0; m < 3; m++) {
                        c = board[i * 3 + k][j * 3 + m];
                        if (c != '.') {
                            if (list.contains(c)) {
                                return false;                  
                            } else {
                                list.add(c);
                            }   
                        }                     
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        
    }
}