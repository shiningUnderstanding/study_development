package basic;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_4153_triangle {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == 0 && b == 0 && c == 0) {
				break;
			}
			
			if((a * a) == ((b * b) + (c * c))) {
				sb.append("right").append('\n');
			}else if((b * b) == ((a * a) + (c * c))) {
				sb.append("right").append('\n');
			}else if((c * c) == ((a * a) + (b * b))) {
				sb.append("right").append('\n');
			}else {
				sb.append("wrong").append('\n');
			}
		}
		System.out.println(sb);
	}
}
