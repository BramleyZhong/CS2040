//Zhong Zhaoping  A0194519U
import java.util.*;

class Teque {
    public static void main(String[] args){
        Kattio io = new Kattio(System.in, System.out);

        int n = io.getInt(); // 
        int[] front = new int[10000000]; // create a large array to store all the numbers
        int[] back = new int[10000000];
        int frontHead = (front.length-1)/2; // set Head and Tail at the middle of the array to make sure enough space to expend
        int frontTail = (front.length-1)/2;	
        int backHead = (back.length-1)/2; 
        int backTail = (back.length-1)/2;
        int frontSize = frontTail-frontHead;	
        int backSize = backTail-backHead;

        for(int i=0; i<n; i++){
            frontSize = frontTail-frontHead;
			backSize = backTail-backHead;
			String op = io.getWord();
            int item = io.getInt();
            
            if (op.equals("push_back")) {
				backTail++;
				back[backTail] = item;
            } 

            if (op.equals("push_front")) {
				front[frontHead] = item;
				frontHead--;
            } 

            if (op.equals("push_middle")) {
				int mid = (frontSize+backSize+1)/2;
				if(mid > frontSize) {
                    // balencing the two parts
					while(mid > frontSize) {
						frontTail++;
						front[frontTail] = back[backHead+1];
                        backHead++;
                        backSize--;
						frontSize++;
					}
				} else {
					while(mid < frontSize) {
						back[backHead] = front[frontTail];
                        backHead--;
                        backSize++;
						frontTail--;
						frontSize--;
					}
                }
                back[backHead] = item;
				backHead--;
            }

            if (op.equals("get")) {
                int index = item;
				if(index > frontSize-1) {
					io.println(back[backHead+index-frontSize+1]);
				} else {
					io.println(front[frontHead+index+1]);
				}
			}
        }
        io.close();

    }
}