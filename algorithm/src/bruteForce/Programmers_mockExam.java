package bruteForce;

public class Programmers_mockExam {
	public int[] solution(int[] answers) {
        int[] giveup1_rule = {1, 2, 3, 4, 5};
        int[] giveup2_rule = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] giveup3_rule = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int giveup1 = 0;
        int giveup2 = 0;
        int giveup3 = 0;
        //맞출 경우 +1
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == giveup1_rule[i % 5]){
                giveup1++;
            }
            
            if(answers[i] == giveup2_rule[i % 8]){
                giveup2++;
            }
            
            if(answers[i] == giveup3_rule[i % 10]){
                giveup3++;
            }
            
        }
        //케이스 총 6개
        if(giveup1 == giveup2 && giveup2 == giveup3){
            int[] answer = {1, 2, 3};
            return answer;
        }
        if(giveup1 == giveup2 && giveup2 > giveup3){
            int[] answer = {1, 2};
            return answer;
        }
        if(giveup1 == giveup3 && giveup3 > giveup2){
            int[] answer = {1, 3};
            return answer;
        }
        if(giveup2 == giveup3 && giveup2 > giveup1){
            int[] answer = {2, 3};
            return answer;
        }
        if(giveup1 > giveup2 && giveup1 >giveup3){
            int[] answer = {1};
            return answer;
        }
        if(giveup2 > giveup1 && giveup2 >giveup3){
            int[] answer = {2};
            return answer;
        }
        if(giveup3 > giveup1 && giveup3 >giveup2){
            int[] answer = {3};
            return answer;
        }
        int[] answer = {0};
        return answer;
    }
}
