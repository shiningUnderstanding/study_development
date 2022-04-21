package todayhome;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Distance {
    public String solution(String call) {
    	call = "aaabscds";
        //최대 중복이 가능한 길이
        int len = call.length() / 2;

        //중복된 갯수
        int count = 0;

        //최다 중복 패턴 횟수
        int max = Integer.MIN_VALUE;

        //패턴 문자열
        String s;

        //패턴 배열
        Map<String, Integer> patternMap = new HashMap<>();

        //1개짜리 패턴 부터 최대 n/2 패턴까지
        for(int i = 1; i < len; i++){
            //각각 개수마다의 시작점
            for(int j = 0; j < call.length() - i + 1; j++){
                s = call.substring(j, j + i);
                count = 0;
                //패턴이 몇개있는지 비교
                for(int k = 0; k < call.length() - i + 1; k++){
                    if(s.equalsIgnoreCase(call.substring(k, k + i))){
                        count++;
                    }
                }
                
                if(count >= max){
                    max = count;
                    patternMap.put(s, count);
                }
            }
        }

        List<String> patternList = new ArrayList<>(patternMap.keySet());

        //가장 긴 문자열순으로 정렬
        Collections.sort(patternList, (e1, e2) -> e2.length() - e1.length());

        String answer = call;

        //최대 문자열의 길이
        int patternLength = 0;
        for(String pattern: patternList){
            if(patternLength <= pattern.length()){
                patternLength = pattern.length();
                answer = answer.replaceAll(pattern, "");
            }
        }

        return answer;
    }
}