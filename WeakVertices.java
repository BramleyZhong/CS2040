import java.util.*;
	
	class WeakVertices {
		public static void main(String[] args) {
			Kattio io = new Kattio(System.in, System.out);
	
			int a = io.getInt();
			while(a != -1) {
				int v = a;
				int[][] arr = new int[v][v];
				for(int i=0; i<v; i++) {
					for(int j=0; j<v; j++) {
						arr[i][j] = io.getInt();
					}
				}
				weakV(arr);
				a = io.getInt();
			}
		}
	
		public static void weakV(int[][] arr) {
			List<Integer> weak = new ArrayList<>();
			for(int i=0; i<arr.length; i++) {
				List<Integer> temp = new ArrayList<>();
				for(int j=0; j<arr.length; j++) {
					if(arr[i][j] == 1) {
						temp.add(j);
					}
				}
				boolean isWeak = true;
				for(int k=0; k<temp.size(); k++) {
					for(int l=k+1; l<temp.size(); l++) {
						if(arr[temp.get(k)][temp.get(l)] == 1) {
							isWeak = false;
							break;
						}
					}
				}
				if(isWeak) {
					weak.add(i);
				}
			}
	
			for(int p=0; p<weak.size(); p++) {
				System.out.print(weak.get(p)+" ");
			}
			System.out.println();
		}
	}


	for (int i = 0; i < weakCount-1; i++) {
		io.print(weak.get(i) + " ");
	}
	io.println(weak.get(weakCount-1));