package basic;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1002_turret {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int distance = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
			int r_in = (r1 -r2) * (r1 -r2);
			int r_out = (r1 + r2) * (r1 + r2);
			
			if(x1 == x2 && y1 == y2 && r1 == r2) {
				sb.append(-1).append('\n');
			}else if(distance > r_out || distance < r_in){
				sb.append(0).append('\n');
			}else if(distance == r_in || distance == r_out) {
				sb.append(1).append('\n');
			}else {
				sb.append(2).append('\n');
			}
		}
		System.out.println(sb);
	}
}
