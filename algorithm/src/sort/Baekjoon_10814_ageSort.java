package sort;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Baekjoon_10814_ageSort {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Object[][] people = new Object[N][2];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			people[i][0] = Integer.parseInt(st.nextToken());
			people[i][1] = (String)st.nextToken();
		}
		
		Arrays.sort(people, (p1,p2) -> {
			return (int)p1[0] - (int)p2[0];
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(people[i][0]).append(' ').append(people[i][1]).append('\n');
		}
		System.out.println(sb);
	}
}
