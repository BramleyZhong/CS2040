//Zhong Zhaoping  A0194519U
import java.util.*;

public class WeakVertices1 {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = 0;
        
        do {
            n = io.getInt();
            if (n == -1) 
                break;

            int[][] AM = new int[n][n];
            List<Integer> weak = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    AM[i][j] = io.getInt(); // read in the AM
                }
            }
            for (int first = 0; first < n; first++) {
                boolean istriangle = false;
                for (int sec = 0; sec < n; sec++) {
                    if (AM[first][sec] == 1) { // check two (first and second) vertices are connected
                        for (int thd = 0; thd < n; thd++) { // for the neighbors of the second vertex
                            if (AM[sec][thd] == 1) { // if second and third are connected
                                if (AM[thd][first] == 1) { // if third and first are connected
                                    istriangle = true; // then those three vertices are in a triangle
                                }
                            }
                        }
                    }
                }
                if (!istriangle) {
                    weak.add(first); // if not in triangle, then the first vertex is weak
                }
            }

            int weakCount = weak.size();
            for (int i = 0; i < weakCount; i++) {
                if (i < (weakCount - 1)) {
                    io.print(weak.get(i) + " ");
                } else {
                    io.println(weak.get(i));
                }
            }
            
        } while (n != -1);
        io.close();
    }
}