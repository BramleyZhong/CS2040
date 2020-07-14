//Zhong Zhaoping  A0194519U
import java.util.*;
	
class Islands {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		int r = io.getInt(); 
		int c = io.getInt();
		int answer = 0;
		Grid[][] grid = new Grid[r][c];
	
		for(int i=0; i<r; i++) { // read the input into an 2D array 
            String word = io.getWord();
			for(int j=0; j<c; j++) {
				grid[i][j] = new Grid(word.charAt(j), false);
			}
		}
	
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(grid[i][j].LWC == 'L' && grid[i][j].isvisited == false) { // using dfs
					dfs(grid, i, j);
					answer++;
				}
			}
		}
	
        
        io.println(answer);
	    io.close();
	}
	
	public static void dfs(Grid[][] grid, int p, int q) {
		grid[p][q].isvisited = true;
		ArrayList<IntegerPair> neighbors = new ArrayList<>(); // find neighbors of the current grid
		if((p+1)<grid.length){
            neighbors.add(new IntegerPair(p+1,q));}	
		if((p-1)>=0){
			neighbors.add(new IntegerPair(p-1,q));}	
		if((q+1)<grid[0].length){
			neighbors.add(new IntegerPair(p,q+1));}		
		if((q-1)>=0){
			neighbors.add(new IntegerPair(p,q-1));}	
	
		for(int i=0; i<neighbors.size(); i++) {
			int x = neighbors.get(i).x;
			int y = neighbors.get(i).y;
			if(grid[x][y].LWC == 'C' || grid[x][y].LWC == 'L') {
				if(grid[x][y].isvisited == false) {
					dfs(grid, x, y);
				}
			}
		}
	}
}
	
	
class Grid {
	char LWC; // LWC for Land, Water, Clouds
	boolean isvisited;
	
	public Grid (char LWC, boolean isvisited) {
		this.LWC = LWC;
		this.isvisited = isvisited;
	}
}

class IntegerPair {
	int x;
	int y;
	
	public IntegerPair (int x, int y) {
		this.x = x;
		this.y = y;
	}
}