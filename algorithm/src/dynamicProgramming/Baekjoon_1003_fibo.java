package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1003_fibo {
	static Integer[][] fibo_no = new Integer[41][2];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		fibo_no[0][0] = 1;
		fibo_no[0][1] = 0;
		fibo_no[1][0] = 0;
		fibo_no[1][1] = 1;
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N;
		
		for(int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			fibo(N);
			sb.append(fibo_no[N][0]).append(' ').append(fibo_no[N][1]).append('\n');
		}
		System.out.println(sb);
	}
	
	static Integer[] fibo(int num) {
		if(fibo_no[num][0] == null || fibo_no[num][1] == null) {
			fibo_no[num][0] = fibo(num - 1)[0] + fibo(num - 2)[0];
			fibo_no[num][1] = fibo(num - 1)[1] + fibo(num - 2)[1];
		}
		
		return fibo_no[num];
	}
}
