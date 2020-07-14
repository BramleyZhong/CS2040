//Zhong Zhaoping  A0194519U
import java.util.*;

public class MillionaireMadness {

    static boolean isVisited[][]; // use static to save memory space
	static int temp;
	static int grid[][];
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        
        int r = io.getInt();
        int c = io.getInt();
        grid = new int[r][c];
	    isVisited = new boolean[r][c];
        
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                grid[i][j] = io.getInt();
            }
        }
        
        int low = 0;
        int high = 1000000000; // 10^9
        
        while (high > low) {
            temp = (low + high) / 2; // use binary search to find the shortest ladder
            
            for (boolean[] row : isVisited) 
                Arrays.fill(row, false); // all grids are not visited (false) at the begining
            
            boolean isPath = dfs(0, 0); // for each temp, use dfs
            
            if (isPath) {
                high = temp;
            } else {
                low = temp+1;
            }
        }
        io.println(low);
        io.close();
    }
    

    static boolean dfs(int x, int y) {
        // if already at the last point
        if (x == grid.length - 1 && y == grid[0].length -1) {
            return true;
        }

        if (isVisited[x][y]) return false;
        isVisited[x][y] = true;
        
        
        boolean isPath = false;
        
        if (x > 0 && grid[x-1][y] - grid[x][y] <= temp) {
            isPath = isPath || dfs(x-1, y);
        }
        
        if (x < grid.length-1 && grid[x+1][y] - grid[x][y] <= temp) {
            isPath = isPath || dfs(x+1, y);
        }
        
        if (y > 0 && grid[x][y-1] - grid[x][y] <= temp) {
            isPath = isPath || dfs(x, y-1);
        }
        
        if (y < grid[0].length-1 && grid[x][y+1] - grid[x][y] <= temp) {
            isPath = isPath || dfs(x, y+1);
        }
        
        return isPath;
    }
 
}