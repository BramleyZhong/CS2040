//Zhong Zhaoping  A0194519U
import java.util.*;

class Conformity{
    public static void main(String[] args){
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        HashMap<HashSet<Integer>,Integer> hm = new HashMap<>();
        for(int i=0; i<n; i++){
            HashSet<Integer> set = new HashSet<>();
			for(int j=0; j<5; j++) {
				set.add(io.getInt());
			}
			if(hm.containsKey(set)) {
				int curr = hm.get(set);
				curr++;
				hm.replace(set,curr);
			} else {
				hm.put(set, 1);
			}
        }

        int max = 0;	
        HashSet<Integer> temp = new HashSet<>();
        for(HashSet<Integer> key : hm.keySet()) {
			if(hm.get(key) > max) {
				max = hm.get(key);
				temp = key;
			}
        }
        
        int mmax = max;
		for(HashSet<Integer> kk : hm.keySet()) {
			if(hm.get(kk) == max && kk.containsAll(temp)==false) {
				mmax += max;
			}
        }
        
        io.println(mmax);
		io.close();


    }
}
