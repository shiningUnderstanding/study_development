package Hash;

import java.util.HashMap;
import java.util.Map;

public class Programmers_spy {
	public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> clothesMap = new HashMap<>();
        for(String[] sArr: clothes){
            clothesMap.put(sArr[1], clothesMap.getOrDefault(sArr[1], 0) + 1);
        }
        for(String category : clothesMap.keySet()){
            answer *= (clothesMap.get(category) + 1);
        }
        return answer - 1;
    }
}
