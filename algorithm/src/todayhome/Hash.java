package todayhome;

import java.util.HashMap;
import java.util.Map;

class Hash {
    static Map<String, String> variableMap = new HashMap<>();

    public String solution(String tstring, String[][] variables) {
        check(variables);

        String answer = tstring;

        for(String key: variableMap.keySet()){
            answer = answer.replaceAll("\\{" + key + "\\}", variableMap.get(key));
        }

        return answer;
    }

    static void check(String[][] variables){
        String s = "";
        String[][] copyVariables = variables.clone();
        for(int i = 0; i < variables.length; i++){
            variableMap.put(variables[i][0], variables[i][1]);
            if(variables[i][1].charAt(0) == '{' && variables[i][1].charAt(variables[i][1].length() - 1) == '}'){
                s = variables[i][1].substring(1, variables[i][1].length() - 1);
                System.out.println(s);
                for(int j = 0; j < copyVariables.length; j++){
                    if(copyVariables[j][0].equals(s)){
                        copyVariables[i][1] = copyVariables[j][1];
                    }
                }
            }
        }

        for(int i = 0; i < variables.length; i++){
            if(!variables[i][1].equals(copyVariables[i][1])){
                System.out.println("copyVariables[i][1]");
                check(copyVariables);

            }
        }
        return;
    }
}