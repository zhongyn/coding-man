import java.util.*;
public class SolveSudoku {

    private Cell[][] cellTable;
    private final static char[] number = {'1','2','3','4','5','6','7','8','9'};

    public void solveSudoku(char[][] board) {
        initCellTable(board);
        System.out.println(backtrack(board, cellTable));
    }

    public void initCellTable(char[][] table) {
        cellTable = new Cell[9][9];
        Cell c;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (table[i][j] == '.') {
                    c = new Cell(i, j);
                    for (int k = 0; k < 9; k++) {
                        if (isConsistent(number[k], i, j, table)) {
                            c.addVal(number[k]);                            
                        }
                    }
                    cellTable[i][j] = c;
                }
            }
        }

    }


    public boolean backtrack(char[][] sTable, Cell[][] cTable) {
        if (isCompleted(sTable)) {
            return true;
        }       
        Cell var = unassignedVariable(sTable, cTable);
        int x = var.x;
        int y = var.y;
        for (char v : var.values) {
            if (isConsistent(v, x, y, sTable)) {
                Cell[][] newCTable = copyCtable(cTable);
                sTable[x][y] = v;
                if (inference(v, x, y, sTable, newCTable)) {
                    if (backtrack(sTable, newCTable)) {
                        return true;
                    }
                }
                sTable[x][y] = '.';
            }
        }
        return false;
    }

    public boolean inference(char v, int x, int y, char[][] sTable, Cell[][] cTable) {
        cTable[x][y] = null;

        for (int i = 0; i < 9; i++) {
            if (sTable[x][i] == '.' && cTable[x][i].contain(v)) {
                cTable[x][i].removeVal(v);
                if (cTable[x][i].size() == 0) {
                    return false;
                }
            }                
            if (sTable[i][y] == '.' && cTable[i][y].contain(v)) {
                cTable[i][y].removeVal(v);
                if (cTable[i][y].size() == 0) {
                    return false;
                }
            }                
        }
        int nx = (x / 3) * 3;
        int ny = (y / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sTable[nx + i][ny + j] == '.' && cTable[nx + i][ny + j].contain(v)) {
                    cTable[nx + i][ny + j].removeVal(v);
                    if (cTable[nx + i][ny + j].size() == 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public Cell[][] copyCtable(Cell[][] cTable) {
        Cell[][] table = new Cell[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (cTable[i][j] != null) {
                    table[i][j] = new Cell(cTable[i][j]);
                }
            }
        }
        return table;
    }

    public boolean isCompleted(char[][] table) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (table[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isConsistent(char v, int x, int y, char[][] table) {
        for (int i = 0; i < 9; i++) {
            if (table[x][i] == v || table[i][y] == v) {
                return false;
            }
        }

        int nx = (x / 3) * 3;
        int ny = (y / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[nx + i][ny + j] == v) {
                    return false;
                }
            }
        }
        return true;
    }

    public Cell unassignedVariable(char[][] table, Cell[][] cTable) {
        // return a cell with minimum remaining values
        Cell c = new Cell();
        int num = 10;
        int len;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (table[i][j] == '.') {
                    len = cTable[i][j].size();
                    if (len < num) {
                        c = cTable[i][j];
                        num = len;                        
                    }
                }
            }
        }
        return c;
    }

    public char[][] testInput(String[] s) {
        char[][] result = new char[9][];
        for (int i = 0; i < 9; i++) {
            result[i] = s[i].toCharArray();
        }
        return result;
    }

    public static void main(String[] args) {
        String[] data = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
        SolveSudoku su = new SolveSudoku();
        char[][] array = su.testInput(data);
        System.out.println(Arrays.deepToString(array));
        su.solveSudoku(array);
        System.out.println(Arrays.deepToString(array));

    }
}

class Cell {

    int x;
    int y;
    LinkedList<Character> values = new LinkedList<Character>();

    public Cell() {}

    public Cell(int i, int j) {
        x = i;
        y = j;
    }

    public Cell(Cell cell) {
        x = cell.x;
        y = cell.y;
        values = new LinkedList(cell.values);
    }

    public void addVal(Character v) {
        values.add(v);
    }

    public void removeVal(Character v) {
        values.remove(v);
    }

    public int size() {
        return values.size();
    }

    public boolean contain(Character v) {
        return values.contains(v);
    }

}
