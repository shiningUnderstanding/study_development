package sort;

import java.util.Arrays;

public class Programmers_HIndex {
	public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int h;
        int answer = 0;
        for(int i = 0; i < citations.length; i++){
        	h = citations.length - i;
            if(citations[i] >= h){
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}
