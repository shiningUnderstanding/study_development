package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2775_apartment {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int k;
		int n;
		int[][] apartment = new int[15][14];
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < 14; i++) {
			apartment[0][i] = i + 1;//0층
			apartment[i][0] = 1;//1호
		}
		
		apartment[14][0] = 1;
		
		for(int i = 1; i < 15; i++) {//1층부터
			for(int j = 1; j < 14; j++) {//2호부터
				apartment[i][j] = apartment[i - 1][j] + apartment[i][j-1];
			}
		}
		
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 14; j++) {
				System.out.print(apartment[i][j] + " ");
			}
			System.out.println();
		}
		for(int i = 0; i < T; i++) {
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());
			sb.append(apartment[k][n-1]).append("\n");
		}
		System.out.println(sb);
	}
}
