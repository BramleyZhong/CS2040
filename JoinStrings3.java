import java.util.*;

@SuppressWarnings("unchecked")
	class JoinStrings3 {
		public static void main(String[] args) {
			Kattio io = new Kattio(System.in, System.out);
	
			int n = io.getInt();	
			List<TailedLinkedList> list = new ArrayList<TailedLinkedList>();
			list.add(new TailedLinkedList()); // add an empty TailedLinkedList to align index
			for(int i=0; i<n; i++) {
				TailedLinkedList word = new TailedLinkedList();
				word.addBack(io.getWord());
				list.add(word);
			}
	
			int a = 0;
			int b = 0;
			for(int j=0; j<n-1; j++) {
				a = io.getInt();
				b = io.getInt();
				TailedLinkedList one = list.get(a);
				TailedLinkedList two = list.get(b);
				one.getTail().setNext(two.getHead()); // connect a and b
				one.numNodes = one.numNodes + two.numNodes;
				one.tail = two.getTail();
			}
	
			//if(list.size()>2) {
				//TailedLinkedList ll = list.get(a);
                //ll.print();
                //System.out.println(ll);
				//System.out.println(Arrays.toString(ll.toArray()));
				System.out.println(list.get(a));
			//} 
			//else {
                //list.get(1).print();
                //System.out.println(list.get(1));
                //System.out.println(Arrays.toString(list.get(1).toArray()));
            //}
            
	
	
			io.close();
		}
	}