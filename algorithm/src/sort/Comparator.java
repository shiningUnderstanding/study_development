package sort;

import java.util.Arrays;

public class Comparator {
	public static void main(String[] args) {
		int[][] arr = {{1,2},{2,3},{1,2},{5,2}};
		
//		Arrays.sort(arr, new Comparator<int[]>() {
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				return o1[0] - o2[0];
//			}
//		});
		
		Arrays.sort(arr, (e1, e2) -> {
				return e1[0] - e2[0];
		});
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i][0] + ", " + arr[i][1]);
		}
	}
}
