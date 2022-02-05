package Hash;

import java.util.HashMap;
import java.util.Map;

public class Programmers_bestMusic {
	 public int[] solution(String[] genres, int[] plays) {
	        //장르별, 고유번호별 hash
	        Map<String,Integer> genresMap = new HashMap<>();
	        for(int i = 0; i < genres.length; i++){
	            genresMap.put(genres[i], genresMap.getOrDefault(plays[i], 0) + plays[i]);
	        }
	        int[] answer = new int[genresMap.size() * 2];
	         
	        return answer;
	    }
}
