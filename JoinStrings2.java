import java.util.*;
import java.io.*;


class JoinStrings2 {
	public static void main(String[] args) {
        //Kattio io = new Kattio(System.in, System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
			//int n = io.getInt();	
        // num of strings
        int n = Integer.parseInt(br.readLine());
		List<TailedLinkedList> list = new ArrayList<>();
		list.add(new TailedLinkedList());
		for(int i=1; i<=n; i++) {
			TailedLinkedList temp = new TailedLinkedList();
			temp.addBack(br.readLine());//io.getWord()
			list.add(temp);
		}

		int a = 0;
		for(int j=1; j<n; j++) {
			//a = io.getInt();
            //int b = io.getInt();
            String[] op = (br.readLine()).split(" ");
            a = Integer.parseInt(op[0]); 
            int b = Integer.parseInt(op[2]); 
			TailedLinkedList first = list.get(a);
			TailedLinkedList second = list.get(b);
			first.getTail().setNext(second.getHead());
			first.numNodes = first.numNodes + second.numNodes;
			first.tail = second.getTail();
		}

		if(list.size()>2) {
			TailedLinkedList ll = list.get(a);
			//ll.print();
			System.out.println(ll);
		} else {
			//list.get(1).print();
			System.out.println(list.get(1));
		}}
		catch (IOException e){
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		}

		//io.close();
	}
}