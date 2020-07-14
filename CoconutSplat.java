//Zhong Zhaoping  A0194519U
import java.util.*;

public class CoconutSplat {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int s = in.nextInt(); // s for syllables
        final int n = in.nextInt(); // n for number of players
        final int fold = 3; //int numbers stand for status
        final int fist = 2;
        final int down = 1;
        final int behind = 0;



        final List<Integer> remainhands = new ArrayList<Integer>();
        final int[] handstatus = new int[n * 2];

        for (int i = 0; i < n * 2; i++) {
            handstatus[i] = fold;
            if (i % 2 == 0)
				remainhands.add(i); //create foldhands at 0, 2, 4, 6...
        }
        
        int winner = -1;
        int index = 0;

        while (winner == -1) {
            index = (index + s - 1) % remainhands.size();
            int handindex = remainhands.get(index);
            handstatus[handindex]--;

            if (handstatus[handindex] == behind){
                remainhands.remove(index);
					if (remainhands.size() == 1 ){
                        winner = remainhands.get(0);}
            }

            else if (handstatus[handindex] == down){
                index++;
            }

            else if (handstatus[handindex] == fist){
                if (index + 1 == remainhands.size()) 
                    remainhands.add(handindex + 1);
                else   
                    remainhands.add(index + 1, handindex + 1); 
                    handstatus[handindex + 1]--;
            }
            //System.out.println(remainhands);
        }
        System.out.println((winner/2)+1);
     
    }
}
