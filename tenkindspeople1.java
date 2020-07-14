//Zhong Zhaoping  A0194519U
import java.util.*;
	
public class tenkindspeople1{
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		int r = io.getInt();    
		int c = io.getInt();    
			
		int[][] map = new int[r][c];
		visitedArray[][] visitedarr = new visitedArray[r][c];
			
		for(int i=0; i<r; i++) {
			String text = io.getWord();
			for(int j=0; j<c; j++) {
				int a = Integer.parseInt(""+text.charAt(j));
				map[i][j] = a;
				visitedarr[i][j] = new visitedArray(a,0); // 0 for not visited, 1 for visited
			}
		}
	
        int counter = 0;    
		for(int i=0; i<r; i++) { //use bfs to do a preprocess
			for(int j=0; j<c; j++) {
				if(visitedarr[i][j].visited==0) {
					counter++;
					int temp = visitedarr[i][j].value;
					visitedarr[i][j].value = counter;
					bfs(visitedarr, i, j, temp);
				}
            }
		}
	
		int q = io.getInt();
		for(int i=0; i<q; i++) {
			int r1 = io.getInt()-1; 
			int c1 = io.getInt()-1;
			int r2 = io.getInt()-1; 
			int c2 = io.getInt()-1;

			if(visitedarr[r1][c1].value == visitedarr[r2][c2].value) {
				if(map[r1][c1]==1){
					io.println("decimal");
				}else{             
					io.println("binary");}
			}else{
				io.println("neither");
			}
		}
		io.close();
	}
	
	
	public static void bfs(visitedArray[][] visitedarr, int i, int j, int temp) {
        visitedarr[i][j].visited = 1;  
		int temp1 = visitedarr[i][j].value;
		Queue<Integer> x = new LinkedList<>();
		Queue<Integer> y = new LinkedList<>();
		x.add(i);
		y.add(j);
		while (!x.isEmpty()) {
			i = x.remove();
			j = y.remove();
			if((i-1)>=0 && visitedarr[i-1][j].visited==0 && visitedarr[i-1][j].value==temp) {
				visitedarr[i-1][j].visited = 1;
				visitedarr[i-1][j].value = temp1;
				x.add(i-1);
				y.add(j);
			}
			if((i+1)<visitedarr.length && visitedarr[i+1][j].visited==0 && visitedarr[i+1][j].value==temp) {
				visitedarr[i+1][j].visited = 1;
				visitedarr[i+1][j].value = temp1;
				x.add(i+1);
				y.add(j);
			}
			if((j-1)>=0 && visitedarr[i][j-1].visited==0 && visitedarr[i][j-1].value==temp) {
				visitedarr[i][j-1].visited = 1;
				visitedarr[i][j-1].value = temp1;
				x.add(i);
				y.add(j-1);
			}
			if((j+1)<visitedarr[0].length && visitedarr[i][j+1].visited==0 && visitedarr[i][j+1].value==temp) {
				visitedarr[i][j+1].visited = 1;
				visitedarr[i][j+1].value = temp1;
				x.add(i);
				y.add(j+1);
			}		
		}
	}
}
	
class visitedArray {
	int value;
	int visited;
	
	public visitedArray(int value, int visited) {
		this.value = value;
		this.visited = visited;
	}
}