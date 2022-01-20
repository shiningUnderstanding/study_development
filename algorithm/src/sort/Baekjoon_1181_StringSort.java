package sort;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;

public class Baekjoon_1181_StringSort {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] words = new String[N];
		for(int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}
		
		Arrays.sort(words, (w1, w2) -> {
			if(w1.length() == w2.length()) {
				return w1.compareTo(w2);
			}else {
				return w1.length() - w2.length();
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			if(i > 0 && words[i].equals(words[i - 1])) {
				continue;
			}
			sb.append(words[i]).append('\n');
		}
		System.out.println(sb);
	}
}
