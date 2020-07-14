//Zhong Zhaoping  A0194519U
import java.util.*;

public class Ladice{
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int items =io.getInt();
        int Drawers = io.getInt();
  
        UnionFind drawers = new UnionFind(Drawers);
  
        for (int i=0; i<items; i++){
            int a = io.getInt()-1;
            int b = io.getInt()-1;
            drawers.unionSet(a, b);

            if (drawers.getSize(a)>0){
                drawers.updateSize(a);
                io.println("LADICA");
            }else{
                io.println("SMECE");
            }
        }
        io.close();
    }
}

class UnionFind {                                              
  public int[] p;
  public int[] rank;
  public int[] setSize;
  public int numSets;
  

  public UnionFind(int N) {
    p = new int[N];
    rank = new int[N];
    setSize = new int[N];
    numSets = N;
    for (int i = 0; i < N; i++) {
      p[i] = i;
      rank[i] = 0;
      setSize[i] = 1;
    }
  }

  public int findSet(int i) { 
    if (p[i] == i) return i;
    else {
      p[i] = findSet(p[i]);
      return p[i]; 
    } 
  }

  public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

  public void unionSet(int i, int j) { 
    if (!isSameSet(i, j)) { 
      numSets--; 
      int x = findSet(i), y = findSet(j);
      // rank is used to keep the tree short
      if (rank[x] > rank[y]) {
        p[y] = x;
        setSize[x] = setSize[x] + setSize[y];}
      else { 
        p[x] = y;
        setSize[y] = setSize[y] + setSize[x];
        if (rank[x] == rank[y]) 
          rank[y] = rank[y]+1; 
      } 
    } 
  }

  public int numDisjointSets() { return numSets; }

  public void updateSize(int i){
    int x = findSet(i);
    setSize[x] = setSize[x]-1;
  } 

  public int getSize(int i){ return setSize[findSet(i)]; }
}
