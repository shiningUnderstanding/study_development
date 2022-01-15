package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_1427_sortInside {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number = br.readLine();
		char[] arrNumber = number.toCharArray();
		
		Arrays.sort(arrNumber);
		
		StringBuilder sb = new StringBuilder(new String(arrNumber));
		System.out.println(sb.reverse());
	}
}
