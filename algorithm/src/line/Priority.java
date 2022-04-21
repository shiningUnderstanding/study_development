package line;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Priority {
	public static void main(String[] args) {
		Integer[] abilities = {2, 8, 3, 6, 1, 9, 1, 9};
		int k = 2;
		Arrays.sort(abilities, (e1, e2) -> {
			return e2 - e1;
		});
		int count = (abilities.length + 1) / 2;
		
//		Map<Integer, Integer> priority = new HashMap<Integer, Integer>();
//		priority.put(1, 0);
//		priority.put(2, 0);
		
		Integer[] dif = new Integer[count];
		
		for(int i = 0; i < count; i++) {
			dif[i] = abilities[0 + 2 * i] - abilities[1 + 2 * i];
		}
		
		int max1 = 0;
		int index1 = 0;
		int max2 = 0;
		int index2 = 0;
		for(int i = 0; i < count; i++) {
			if(dif[i] >= max1) {
				max1 = dif[i];
				index1 = i;
			}
			
			if(dif[i] < max1 && dif[i] >= max2) {
				max2 = dif[i];
				index2 = i;
			}
		}
		System.out.println(max1);
		System.out.println(max2);
	}
}
