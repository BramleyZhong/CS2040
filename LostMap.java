// A0194519U Zhong Zhaoping
import java.util.*;

class LostMap {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		int village = io.getInt();

		ArrayList<IntegerSet> edgeList = new ArrayList<IntegerSet>();

		for(int i=0; i < village; i++) {
			for(int j=0; j < village; j++) {
				int dis = io.getInt();
				if(j >= i+1)
					edgeList.add(new IntegerSet(dis, i, j));
			}
		}

		Collections.sort(edgeList, new newComparator());

		UnionFind UF = new UnionFind(village);
	    int i;
	    for (i = 0; i < edgeList.size(); i++) {
			if(UF.numDisjointSets() == 0)	
				break;

	    	IntegerSet temp = edgeList.get(i);
			int a = temp.second;
			int b = temp.third;
			
	      	if (!UF.isSameSet(a, b)) { 
	        	UF.unionSet(a, b);
	        	io.println((a+1) + " " + (b+1));
	      	}
	    }

		io.close();
	}
}

class IntegerSet {
  public Integer first, second, third;

  public IntegerSet(Integer f, Integer s, Integer t) {
    this.first = f;
    this.second = s;
    this.third = t;
  }
}

  

class newComparator implements Comparator<IntegerSet> {
    public int compare(IntegerSet m, IntegerSet n) {
        if(m.first != n.first) 
            return m.first-n.first;
        else if(m.second != n.second) 
            return m.second - n.second;
        else 
            return m.third - n.third;
    }
}