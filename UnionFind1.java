import java.util.*;

class UnionFind1 {                                              
  public int[] p;
  public int[] rank;
  public int numSets;

  public UnionFind(int N) {
    p = new int[N];
    rank = new int[N];
    numSets = N;
    for (int i = 0; i < N; i++) {
      p[i] = i;
      rank[i] = 0;
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
      if (rank[x] > rank[y]) 
      	p[y] = x;
      else { 
      	p[x] = y;
        if (rank[x] == rank[y]) 
          rank[y] = rank[y]+1; 
      } 
    } 
  }

  public int numDisjointSets() { return numSets; }
  public void updateSetSize(int i){
    int x = findSet(i);
    setSize.set(x, setSize.get(x)-1);
  }
  public int sizeOfSet(int i) { return setSize.get(findSet(i)); }
}