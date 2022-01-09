package bruteForce;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Baekjoon_1436_find666 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 1;
		int num = 666;
		while(N != count) {
			num++;
			if(Integer.toString(num).contains("666")) {
				count++;
			}
		}
		System.out.println(num);
	}
}
