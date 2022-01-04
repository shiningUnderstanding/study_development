package sort;

import java.util.*;

public class Programmers_BigNumber {
    public String solution(int[] numbers) {
        String answer = "";
        String[] strNumbers = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            strNumbers[i] = "" + numbers[i];
        }
        
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
            }
        });
        
        if (strNumbers[0].equals("0")) return "0";

        for(int i = 0; i < strNumbers.length; i++){
            answer += strNumbers[i];
        }
        return answer;
    }
}