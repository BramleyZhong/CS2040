//Zhong Zhaoping  A0194519U
import java.util.*;
import java.io.*;
	
class BestRelayTeam{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Runner[] runnerArray = new Runner[num];
        sc.nextLine();

        for(int i=0; i<num; i++) {
            String name = sc.next();
            double first = sc.nextDouble();
            double other = sc.nextDouble();
            runnerArray[i] = new Runner(name, first, other);
        }

        Runner[] sortRunner = Arrays.copyOf(runnerArray, num);
        Arrays.sort(sortRunner, new timeSort());
        String[] finalTeam = new String[4];		
		double totalTime = 10000;//set a big original totalTime

        for(int i = 0; i < num; i++) {
            double currTime = 0;
            currTime += runnerArray[i].first;
            int teamNum = 1;
            for(int j = 0; j < num; j++) {
                if(teamNum<4 && !(runnerArray[i].name.equals(sortRunner[j].name))) {
                    teamNum++;
                    currTime += sortRunner[j].other;
                }
                if (teamNum == 4){
                    break;
                }
            }

            if(currTime < totalTime) {
                totalTime = currTime;
                finalTeam[0] = runnerArray[i].name;
                int team = 1;
                for(int j = 0; j < num; j++) {
                    if(team < 4 && !(runnerArray[i].name.equals(sortRunner[j].name))) {
                        finalTeam[team] = sortRunner[j].name;
                        team++;						
                    }
                    if (team == 4){
                        break;
                    }
                }
            }
        }
        System.out.println(totalTime);
		for(int i = 0; i < 4; i++) {
			System.out.println(finalTeam[i]);
		}
    }
}

class Runner {
    public String name;
    public double first;
    public double other;

    public Runner(String name, double first, double other) {
        this.name = name;
        this.first = first;
        this.other = other;
    }
}

class timeSort implements Comparator<Runner>{
    public int compare(Runner a, Runner b){
      if (a.other > b.other) return 1;
      if (a.other < b.other) return -1;
      return 0;
    }
}
