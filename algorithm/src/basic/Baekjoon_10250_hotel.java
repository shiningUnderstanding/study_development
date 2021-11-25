package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_10250_hotel {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();;
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int H;
		int N;
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			if(N % H == 0) {
				sb.append((H * 100) + (N / H)).append("\n");
			}else {
				//괄호를 잘 넣으면 속도 향상
				sb.append(((N % H) * 100) + (N / H + 1)).append("\n");
			}
		}
		System.out.print(sb.toString());
	}
}
