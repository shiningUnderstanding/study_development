package basic;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_3053_taxicab {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int r = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append(Math.PI * Math.pow(r, 2)).append('\n');
		sb.append(2*Math.pow(r, 2));
		System.out.println(sb);
	}
}
