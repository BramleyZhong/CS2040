//Zhong Zhaoping  A0194519U
import java.util.*;
import java.io.*;

class JoinStrings{
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int n = io.getInt();	// num of strings
        int n = Integer.parseInt(br.readLine());
        List<TailedLinkedList> list = new ArrayList<>();
        list.add(new TailedLinkedList());
        for(int i=1; i<=n; i++) {
			TailedLinkedList[] temp = new TailedLinkedList();
			temp.addBack(br.readLine());
			list.add(temp);
        }

        int a = 0;
		for(int j=0; j<n-1; j++) {
			//a = io.getInt();
            //int b = io.getInt();
            String[] op = (br.readLine()).split(" ");
			TailedLinkedList[] first = list.get(a);
			TailedLinkedList[] second = list.get(b);
			first.getTail().setNext(second.getHead());
			first.num_nodes = first.num_nodes + second.num_nodes;
			first.tail = second.getTail();
        }
        
        if(list.size()>2) {
			TailedLinkedList[] ll = list.get(a);
			ll.print();
		} else {
			list.get(1).print();
        }
        
        
    }
}