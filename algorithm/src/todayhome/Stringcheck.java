package todayhome;
import java.util.*;

class Solution {
    public String[] solution(String path) {
        //거리 1당 100미터
        int distance = 1;

        int time = 0;

        char direction = path.charAt(0);

        String leftRight = "";

        //메세지 리스트 생성
        List<String> messages = new ArrayList<>();
        String s = "";

        for(int i = 1; i < path.length(); i++){
           if(direction == path.charAt(i)){
               distance++;
           }else{
               //좌회전 우회전
               if(direction == 'E' && path.charAt(i) == 'N'){
                   leftRight = "left";
               }else if(direction == 'E' && path.charAt(i) == 'S'){
                   leftRight = "right";
               }else if(direction == 'W' && path.charAt(i) == 'S'){
                   leftRight = "left";
               }else if(direction == 'W' && path.charAt(i) == 'N'){
                   leftRight = "right";
               }else if(direction == 'S' && path.charAt(i) == 'E'){
                   leftRight = "left";
               }else if(direction == 'S' && path.charAt(i) == 'W'){
                   leftRight = "right";
               }else if(direction == 'N' && path.charAt(i) == 'W'){
                   leftRight = "left";
               }else if(direction == 'N' && path.charAt(i) == 'E'){
                   leftRight = "right";
               }
               //방향 재설정
               direction = path.charAt(i);

               //거리가 5가 넘으면 시간 추가 계산, 거리는 최대 500m
               if(distance > 5){
                   time += distance - 5;
                   s = "Time " + time + ": Go straight " + "500m and turn " + leftRight;
               }else{
                   s = "Time " + time + ": Go straight " + distance + "00m and turn " + leftRight;
               }

               //list에 추가
               messages.add(s);

               //거리가 5가 넘어가면 시간은 이미 추가된 계산이 있어 500미터 간 시간만 추가
               if(distance > 5){
                   time += 5;
               }else{
                   time += distance;
               }
               //기본 거리
               distance = 1;
           }
        }

        //리스트 사이즈로 배열 크기 설정
        String[] answer = new String[messages.size()];

        for(int i = 0; i < answer.length; i++){
            answer[i] = messages.get(i);
        }

        return answer;
    }
}