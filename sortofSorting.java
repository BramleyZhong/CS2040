//Zhong Zhaoping  A0194519U
import java.util.*;
	
	class sortofSorting {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
	
			int c = Integer.parseInt(sc.nextLine());
			while(c!=0) {
				String[] name = new String[c];
				for(int i=0; i<c; i++) {
					name[i] = sc.nextLine();
				}
				Arrays.sort(name, new sortofsortingComparator());
				for(int i=0; i<c; i++) {
					System.out.println(name[i]);
				}
				c = Integer.parseInt(sc.nextLine());
			}
		}
	}
	
	class sortofsortingComparator implements Comparator<String> {
        public int compare(String m, String n) {
            if(m.charAt(0) != n.charAt(0)) return m.charAt(0) - n.charAt(0);
            if(m.charAt(0) == n.charAt(0)) return m.charAt(1) - n.charAt(1);
            return 0;
        }
                
        public boolean equals(String n, String m) {
            return  m == n;
		}
	}