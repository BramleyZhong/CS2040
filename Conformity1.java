//Zhong Zhaoping  A0194519U
import java.util.*;

class Conformity1{
    public static void main(String[] args){
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        int courses = 5;
        HashMap<HashSet<Integer>,Integer> popularity = new HashMap<>(); // use the combination of courses as key and popularity as value
        for(int i=0; i<n; i++){                                         
            HashSet<Integer> combination = new HashSet<>();
			for(int j=0; j<courses; j++) {
				combination.add(io.getInt());
            }
            if(popularity.containsKey(combination) == true) { // if that combination is alr in the hashmap, then popularity++
				int pop = popularity.get(combination);
				popularity.replace(combination, pop+1);
			} 
            if(popularity.containsKey(combination) == false){ // if that combination is not in the hashmap, then put 1
                popularity.put(combination, 1);
            }
			
        }

        int maxpopularity = 0;	
        for(HashSet<Integer> key : popularity.keySet()) { // find the max popularity, 
			if(popularity.get(key) > maxpopularity) {     // there may be several combinations with the same max popularity
				maxpopularity = popularity.get(key);
			}
        }
        
        
        int sum = 0;
		for(HashSet<Integer> key : popularity.keySet()) {
			if(popularity.get(key) == maxpopularity){
				sum += maxpopularity; // add up combination with same max popularity, if any
			}
        }
        
        io.println(sum);
		io.close();


    }
}
