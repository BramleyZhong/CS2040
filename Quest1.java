//Zhong Zhaoping  A0194519U
import java.util.*;
    
class Quest1{
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();    
        int bigthreshold = 99999999;
        TreeMap<Quest,Integer> tm = new TreeMap<>(new QuestComparator());
        
        for(int i=0; i<n; i++) {
            String cmd = io.getWord();
            if(cmd.equals("add")) {
                Quest q = new Quest(io.getInt(), io.getInt());
                if(tm.containsKey(q)) { // if that quest alr existed, count++
                    int count = tm.get(q);
                    tm.replace(q, count+1);
                } else {
                    tm.put(q,1);
                }
            } else if(cmd.equals("query")){
                int eng = io.getInt();  
                long finalgold = 0;
                while(tm.floorKey(new Quest(eng,bigthreshold)) != null) { // bigthreshold can be replaced by any other very big integer
                    Quest curr = tm.floorKey(new Quest(eng,bigthreshold)); // use floorkey to find the biggest <= currentX
                    finalgold += curr.gold;
                    eng -= curr.energy;
                    if(tm.get(curr) > 1) { // removing(deducting) the quest from current pool
                        int count = tm.get(curr);
                        tm.replace(curr, count-1);
                    } else {
                        tm.remove(curr);
                    }
                }
                io.println(finalgold);
            }
        }
        io.close();
    }
}
    
class QuestComparator implements Comparator<Quest> { // sort the quest first by energy, then by gold
    public int compare(Quest q1, Quest q2) {
        if(q1.energy == q2.energy) {
            return q1.gold - q2.gold;
        } else {
            return q1.energy - q2.energy;
        }     
    }
}
    
class Quest {
    int energy;
    int gold;
    
    public Quest (int e, int g) {
        this.energy = e;
        this.gold = g;
    }
}