package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2869_snail {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		//하루에 A - B 씩 올라가는데 만약 A가 나머지 없이
		//딱 V에 도달했다 치면 거기서 - B를 한번 한 곳까지의 A - B로 나누었을 때 나머지가 없다.
		int days = (V - B) / (A - B);
	
		
		if((V - B) % (A - B) != 0) {
			days++;
		}
		System.out.println(days);
	}

}
