import java.util.*;

class Teque1 {
    public static void main(String[] args){
        Kattio io = new Kattio(System.in, System.out);

        int n = io.getInt(); // 
        int[] front = new int[200000000]; // create a large array to store all the numbers
        int[] back = new int[200000000];
        int frontHead = (front.length-1)/2; // set Head and Tail at the middle of the array to make sure enough space to go through
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
			} else if (op.equals("push_front")) {
				front[frontHead] = item;
				frontHead--;
			} else if (op.equals("push_middle")) {
				//int mid = (frontSize+backSize+1)/2;
				
                back[backHead] = item;
				backHead--;
            }
            if (op.equals("get")) {
				if(item > frontSize-1) {
					int pos = item-frontSize;
					io.println(back[backHead+pos+1]);
				} else {
					io.println(front[frontHead+item+1]);
				}
			}
        }
        io.close();

    }
}