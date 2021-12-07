package basic;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1085_exitRectangle {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int distance = 0;
		
		//0  x  w
		if(x <= (w - x)) {
			//0  y  h
			if(y <= (h - y)) {
				if(x <= y) {
					System.out.println(x);
				}else {
					System.out.println(y);
				}
			}else {
				if(x <= (h - y)) {
					System.out.println(x);
				}else {
					System.out.println(h - y);
				}
			}
		}else {
			if(y <= (h - y)) {
				if((w - x) <= y) {
					System.out.println(w - x);
				}else {
					System.out.println(y);
				}
			}else {
				if((w - x) <= (h - y)) {
					System.out.println(w - x);
				}else {
					System.out.println(h - y);
				}
			}
		}
	}
}
