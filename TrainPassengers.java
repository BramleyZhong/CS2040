//Zhong Zhaoping  A0194519U
import java.util.*;
	
public class TrainPassengers{
    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
		int Capacity = sc.nextInt();
        int stationNo = sc.nextInt();
        int ontrain = 0;
        Boolean possible = true;
        
        for(int currentStation = 0; currentStation < stationNo; currentStation++){
            int left = sc.nextInt();
			int enter = sc.nextInt();
            int stay = sc.nextInt();
            

            if (currentStation == 0){
                if (left != 0) {
                    possible = false;//check 1st station
                    break;
                }
            } 
            

            ontrain += (enter - left);
            if ((ontrain > Capacity) || ((ontrain < Capacity) && (stay > 0) ) || (ontrain < 0 )){
                possible = false;
                break;
            }

            if (currentStation == stationNo - 1) {
                if (ontrain != 0){
                    possible = false;//check the last station
                    break;
                }
            }

        }
        if (possible == true){
            System.out.println("possible");
        } else {
            System.out.println("impossible");
        }

    }
}