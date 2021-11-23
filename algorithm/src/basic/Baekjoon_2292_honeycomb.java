package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2292_honeycomb {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int roomNumber = Integer.parseInt(br.readLine());
		int num = 1;
		int answer = 1;
		// 1  (1 + 0)      1
		// 7  (1 + 6 * 1)  2  
		// 19 (1 + 6 * 1 + 6 * 2)  3
		// 37 (1 + 6 * 6)  4
		// 61 (1 + 6 * 10) 5
		if(roomNumber == 1) {
			System.out.println(1);
		}else {
			while(num < roomNumber) {
				num = num + answer * 6;
				answer++;
			}
			System.out.println(answer);
		}
		
	}

}
