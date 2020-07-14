//Zhong Zhaoping  A0194519U
import java.util.*;

public class AssWorksta2{
    public static void main(String[] args){
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt(); //number of researchers
        int m = io.getInt(); //number of minutes of inactivity after which a workstation locks itself
        int saving = 0;
        Researcher[] researchers = new Researcher[n];
        
        for (int i=0; i<n; i++){
            researchers[i] = new Researcher(io.getInt(), io.getInt());
        }
        Arrays.sort(researchers, new rescomparator()); // sort by arrTime
        PriorityQueue<Station> unlockedStations = new PriorityQueue<>(new stacomparator());
        
        for (int i=0; i<n; i++){
            boolean isAssigned = false;
            if (unlockedStations.isEmpty()){ // no station is currently in use
                unlockedStations.add(new Station(researchers[i].arrTime, researchers[i].stayTime, m)); // set one station to unlocked
                isAssigned = true;
            }
            else {
                while(!unlockedStations.isEmpty()){ // if there are still unlocked stations
                    Station curr = unlockedStations.poll();
                    if (curr.lockTime < researchers[i].arrTime){ // researcher come too late so station locked
                        curr.isLocked = true;
                    }else if (curr.arrTime + curr.stayTime > researchers[i].arrTime){ // researcher come too early so the station is occupied
                        unlockedStations.add(curr);
                        break;
                    }else{
                        curr.use(researchers[i].arrTime, researchers[i].stayTime, m); // researcher come and use an unlocked station
                        saving++;
                        isAssigned = true;
                        unlockedStations.add(curr);
                        break;
                    }
                }
                if(!isAssigned){ // if researcher is not assigned a station, unlock a new station
                    unlockedStations.add(new Station(researchers[i].arrTime, researchers[i].stayTime, m));
                }
            }
        }
        io.println(saving);
        io.close();
    }
}

class Station{
    public boolean isLocked;
    public int lockTime;
    public int arrTime;
    public int stayTime;

    public Station(int arrTime, int stayTime, int m){
        this.isLocked = false;
        this.arrTime = arrTime;
        this.stayTime = stayTime;
        this.lockTime = arrTime + stayTime + m;
    }
  
    public void use(int arrTime, int stayTime, int m){
        this.isLocked = false;
        this.lockTime = arrTime + stayTime + m;
    }
  
    public int getLockTime(){
        return this.lockTime;
    }
  }
  
class Researcher{
    int arrTime;
    int stayTime;
  
    public Researcher(int a, int s){
        this.arrTime = a;
        this.stayTime = s;
    }
  
    public int getArrTime(){
        return this.arrTime;
    }
  }


class rescomparator implements Comparator<Researcher>{
    public int compare (Researcher a, Researcher b){
        return a.getArrTime() - b.getArrTime();
    }
}

class stacomparator implements Comparator<Station>{
    public int compare (Station a, Station b){
        return a.getLockTime() - b.getLockTime();
    }
}