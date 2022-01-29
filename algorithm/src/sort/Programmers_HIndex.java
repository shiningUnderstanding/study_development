package sort;

import java.util.Arrays;

public class Programmers_HIndex {
	public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int answer = 0;
        for(int i = 0; i < citations.length; i++){
            System.out.println(citations[i]);
        }
        
        return answer;
    }
}
