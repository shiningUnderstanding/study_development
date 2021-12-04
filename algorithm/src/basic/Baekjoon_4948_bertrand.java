package basic;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_4948_bertrand {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n;
		boolean[] eratos = new boolean[246913];
		eratos[0] = true;
		eratos[1] = true;
		while((n = Integer.parseInt(br.readLine())) == 0) {
			for(int i = n; i < 2 * n; i++) {
				
			}
		}
	}
}
