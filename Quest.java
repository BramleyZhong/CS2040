import java.util.*;
	
	class Quest {
		public static void main(String[] args) {
			Kattio io = new Kattio(System.in, System.out);
			int n = io.getInt();	// num of operations
			TreeMap<EnergyGold,Integer> tm = new TreeMap<>(new TreeComparator());
			for(int i=0; i<n; i++) {
				if(io.getWord().equals("add")) {
					EnergyGold eg = new EnergyGold(io.getInt(), io.getInt());
					if(tm.containsKey(eg)) {
						int count = tm.get(eg);
						tm.replace(eg, count+1);
					} else {
						tm.put(eg,1);
					}
				} else {
					int x = io.getInt();	long ans = 0;
					while(tm.floorKey(new EnergyGold(x,10000000)) != null) {
						EnergyGold temp = tm.floorKey(new EnergyGold(x,10000000));
						ans += temp.gold;
						x -= temp.energy;
						if(tm.get(temp) > 1) {
							int count = tm.get(temp);
							tm.replace(temp, count-1);
						} else {
							tm.remove(temp);
						}
					}
					io.println(ans);
				}
			}
			io.close();
		}
	}
	
	class TreeComparator implements Comparator<EnergyGold> {
		@Override
		public int compare(EnergyGold e1, EnergyGold e2) {
			if(e1.energy != e2.energy) {
				return e1.energy - e2.energy;
			} else {
				return e1.gold - e2.gold;
			} 
		}
	}
	
	class EnergyGold {
		int energy;
		int gold;
	
		public EnergyGold (int e, int g) {
			this.energy = e;
			this.gold = g;
		}
	}