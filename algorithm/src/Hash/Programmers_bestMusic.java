package Hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programmers_bestMusic {
	 static int[] solution(String[] genres, int[] plays) {
	        //장르별, 고유번호별 hash
	        Map<String,Integer> genresMap = new HashMap<>();
	        for(int i = 0; i < genres.length; i++){
	            genresMap.put(genres[i], genresMap.getOrDefault(genres[i], 0) + plays[i]);
	        }
	        List<String> genreList = new ArrayList<>(genresMap.keySet());

	        Collections.sort(genreList, (e1, e2) -> genresMap.get(e2) - genresMap.get(e1));
	        
	        List<Integer> bestList = new ArrayList<>();
	        for(String genre: genreList) {
	        	int max = 0;
	        	int bestIndex = -1;
	        	for(int i = 0; i < genres.length; i++) {
	        		if(genre.equals(genres[i]) && max < plays[i]) {
	        			max = plays[i];
	        			bestIndex = i;
	        		}
	        	}
	        	
	        	max = 0;
	        	int secondIndex = -1;
	        	for(int i = 0; i < genres.length; i++) {
	        		if(genre.equals(genres[i]) && max < plays[i] && bestIndex != i) {
	        			max = plays[i];
	        			secondIndex = i;
	        		}
	        	}

	        	bestList.add(bestIndex);
	        	if(secondIndex != -1) {
	        		bestList.add(secondIndex);
	        	}
	        }
	        
	        int[] answer = new int[bestList.size()];
	        
	        for(int i = 0; i < answer.length; i++) {
	        	answer[i] = bestList.get(i);
	        }
	        return answer;
	    }
	 
	 public static void main(String[] args) {
		 String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		 int[] plays = {500, 600, 150, 800, 2500};
		 int[] answer = solution(genres, plays);
		 for(int i: answer) {
			 System.out.println(i);
		 }
	 }
}
