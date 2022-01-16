package sort;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Baekjoon_11650_coordinateSort {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] coordinate = new int[N][2];
		StringTokenizer st;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			coordinate[i][0] = Integer.parseInt(st.nextToken());
			coordinate[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//정렬하기
		int temp;
		for(int i = 0; i < N - 1; i++) {
			for(int j = i+1; j < N; j++) {
				if(coordinate[i][0] > coordinate[j][0]) {
					temp = coordinate[i][0];
					coordinate[i][0] = coordinate[j][0];
					coordinate[j][0] = temp;
					temp = coordinate[i][1];
					coordinate[i][1] = coordinate[j][1];
					coordinate[j][1] = temp;
				}else if(coordinate[i][0] == coordinate[j][0] && coordinate[i][1] > coordinate[j][1]) {
					temp = coordinate[i][0];
					coordinate[i][0] = coordinate[j][0];
					coordinate[j][0] = temp;
					temp = coordinate[i][1];
					coordinate[i][1] = coordinate[j][1];
					coordinate[j][1] = temp;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(coordinate[i][0]).append(' ').append(coordinate[i][1]).append('\n');
		}
		
		System.out.println(sb);
	}
}
