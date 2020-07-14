import java.util.*;

public class AssWorksta{
    public static void main(String[] args){
      Kattio sc = new Kattio(System.in, System.out);
      int numResearchers = sc.getInt();
      int inactivity = sc.getInt();
      int result = 0;
      Researcher[] res = new Researcher[numResearchers];
      for (int i=0; i<numResearchers; i++){
        res[i] = new Researcher(sc.getInt(), sc.getInt());
      }
      Arrays.sort(res, new rescomparator());
      
      PriorityQueue<Station> unlockedStations = new PriorityQueue<>(new stacomparator());
      PriorityQueue<Station> lockedStations = new PriorityQueue<>(new stacomparator());
  
      for (int i=0; i<numResearchers; i++){
        boolean isAssigned = false;
        if (unlockedStations.isEmpty()&&lockedStations.isEmpty()){
          unlockedStations.offer(new Station(res[i].arrTime, res[i].useTime, inactivity));
          isAssigned = true;
        }else if (unlockedStations.isEmpty()&&!lockedStations.isEmpty()){
          Station curr = lockedStations.poll();
          curr.use(res[i].arrTime, res[i].useTime, inactivity);
          unlockedStations.offer(curr);
          isAssigned = true;
        } else {
          while(!unlockedStations.isEmpty()){
            Station curr = unlockedStations.poll();
            if (curr.lockTime<res[i].arrTime){
              curr.isLocked = true;
              lockedStations.offer(curr);
            }else if (curr.endUse>res[i].arrTime){
              unlockedStations.offer(curr);
              break;
            }else {
              curr.use(res[i].arrTime, res[i].useTime, inactivity);
              result++;
              isAssigned = true;
              unlockedStations.offer(curr);
              break;
            }
          }
          if(!isAssigned){
            if (!lockedStations.isEmpty()){
              Station curr = lockedStations.poll();
              curr.use(res[i].arrTime, res[i].useTime, inactivity);
              unlockedStations.offer(curr);
            }else{
              unlockedStations.offer(new Station(res[i].arrTime, res[i].useTime, inactivity));
            }
          }
        }
      }
      sc.println(result);
      sc.close();
  
    }
  
    
  }

  class Station{
    public boolean isLocked;
    // boolean isUsed;
    public int endUse;
    public int lockTime;
  
    public Station(int arrTime, int useTime, int inactivity){
      this.isLocked = false;
      this.endUse = arrTime + useTime;
      this.lockTime = this.endUse+inactivity;
    }
  
    public void use(int arrTime, int useTime, int inactivity){
      this.isLocked = false;
      this.endUse = arrTime + useTime;
      this.lockTime = this.endUse+inactivity;
    }
  
    public int getLockTime(){
      return this.lockTime;
    }
  }
  
  class Researcher{
    int arrTime;
    int useTime;
  
    public Researcher(int a, int u){
      arrTime = a;
      useTime = u;
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



  