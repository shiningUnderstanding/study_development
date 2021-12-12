package recursiveFunction;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_11729_hanoi {
	
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		sb.append((int)Math.pow(2, n) - 1).append('\n');
		
		hanoi(n, 1, 2, 3);
		
		System.out.println(sb);
	}
	
	public static void hanoi(int n, int depart, int mid, int dest) {
		if(n == 1) {
			sb.append(depart + " " + dest + "\n");
			return;
		}
		
		hanoi(n - 1, depart, dest, mid);
		
		sb.append(depart + " " + dest + "\n");
		
		hanoi(n - 1, mid, depart, dest);
	}
}
