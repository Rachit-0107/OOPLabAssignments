//You will be given a 2D grid of size of x where each cell represents a piece of land. The origin of the grid lies at the top-left corner of the grid. Each cell contains some landmines in it which is denoted by the corresponding digit in the grid. This cell might be surrounded landmines present in any of its eight neighbouring cells. You are required to perform the following two types of queries for a given cell (, ) in this grid:
//
//Count the total number of mines hidden in the cells surrounding the cell (, )
//Find the nearest cell to cell (, ) which is safe (having no mines)
//For the second type of query, if there are multiple such cells, report the leftmost and uppermost of all such cells. If no such cell exists, report "No safe cell exists".
//
//Any piece of land outside the boundaries of the given grid are invalid and should not be considered or reported in any of the queries. If the input coordinates of the cell in any query are invalid, print "Invalid query" for the query.
//
//NOTE: the coordinates of the cells in this question are 1-indexed. For example, the third cell to the right and fifth cell to the bottom of the origin is represented by (5, 3). See the sample test case for more clarification.
//
//Input Format
//
//Each testcase has multiple lines of input.
//
//The first line contains two space separated integers  and  denoting the size of the grid.
// lines follow, each of which contains a string of length  and describe a row of the grid
//The line following the previous  lines contains a single integer , denoting the number of queries.
// lines follow, whihc are either of the form  (denoting the query of type 1 on the cell (, )) or  (denoting the query of type 2 on the cell (, )).
//Constraints
//
// for all valid coordinates  in the grid
//Output Format
//
//For each testcase, output  lines. For a query of type 1, output a single integer  denoting the total number of mines in the surrounding cells. For a query of type 2, output two space separated integers  denoting the coordinates of the cell which is safe. If there is no safe cell available, print the line "No safe cell exists".



import java.io.*;

class Minesweeper {
    private int n;
    private int m;
    private int grid[][];

    /* Define an private instance variable to represent the grid */
    Minesweeper(int m, int n, int[][] grid) {
        this.m = m;
        this.n = n;
        this.grid = grid;
        /*
         * Complete the definition of the constructor and initiate the instance
         * variables
         */
    }

    private boolean isValidCell(int i, int j) {
        /*
         * Implement the method to determine if a particular cell is valid for the given
         * grid. This method should be used in the following two methods.
         */
        if (i < n && j < m && i >= 0 && j >= 0)
            return true;
        else
            return false;
    }

    public void countSurroundingMines(int i, int j) {
        /*
         * Complete the definition of the method to count the total number of mines in
         * the surrounding cells of cell (i, j)
         */
        if (!isValidCell(i, j)) {
            System.out.println("Invalid query");
            return;
        }
        int mines = 0;
        if (isValidCell(i + 1, j))
            mines += grid[i + 1][j];
        if (isValidCell(i + 1, j + 1))
            mines += grid[i + 1][j + 1];
        if (isValidCell(i + 1, j - 1))
            mines += grid[i + 1][j - 1];
        if (isValidCell(i, j + 1))
            mines += grid[i][j + 1];
        if (isValidCell(i, j - 1))
            mines += grid[i][j - 1];
        if (isValidCell(i - 1, j))
            mines += grid[i - 1][j];
        if (isValidCell(i - 1, j + 1))
            mines += grid[i - 1][j + 1];
        if (isValidCell(i - 1, j - 1))
            mines += grid[i - 1][j - 1];
        System.out.println(mines);
    }

    public void findSafeCell(int i, int j) {
        /*
         * Complete the definition of the method to find the leftmost and uppermost safe
         * cell for the cell (i, j)
         */
        if (!isValidCell(i, j)) {
            System.out.println("Invalid query");
            return;
        }
        int min = n + m + 1;
        int zp = m + 1;
        int zq = n + 1;
        for (int p = 0; p < n; p++) {
            for (int q = 0; q < m; q++) {
                int dis = Math.abs(i - p) + Math.abs(j - q);
                if (grid[p][q] == 0) {
                    if (dis <= min) {
                        if (i == p && j == q) {
                            continue;
                        }
                        if (dis != min) {
                            min = dis;
                            zq = q;
                            zp = p;
                        }
                    }
                }
            }
        }
        if (zp != n + 1 && zp != m + 1)
        {
            System.out.println((zp+1)+ " " + (zq+1));
        }
        else
        {
            System.out.println("No safe cell exists");
        }
    }
}

public class MineSweeperQueries {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int grid[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = (int) (row.charAt(j) - 48);
            }
        }
        Minesweeper ob = new Minesweeper(m, n, grid);
        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            String inp[] = br.readLine().split(" ");
            int ch = Integer.parseInt(inp[0]);
            int a = Integer.parseInt(inp[1]);
            int b = Integer.parseInt(inp[2]);
            if (ch == 2) {
                ob.findSafeCell(a-1, b-1);
            } else if (ch == 1) {
                ob.countSurroundingMines(a-1, b-1);
            }
        }
    }
}
