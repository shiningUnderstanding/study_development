package line;

public class Log {
	static String[] log_type= {"team_name", "application_name", "error_level", "message"};
	
	public static void main(String[] args) {
		//String[] logs = {"team_name : db application_name : dbtest error_level : info message : test", "team_name : test application_name : I DONT CARE error_level : error message : x", "team_name : ThisIsJustForTest application_name : TestAndTestAndTestAndTest error_level : test message : IAlwaysTestingAndIWillTestForever", "team_name : oberervability application_name : LogViewer error_level : error"};
		String[] logs = {"team_name : MyTeam application_name : YourApp error_level : info messag : IndexOutOfRange", "no such file or directory", "team_name : recommend application_name : recommend error_level : info message : RecommendSucces11", "team_name : recommend application_name : recommend error_level : info message : Success!", "   team_name : db application_name : dbtest error_level : info message : test", "team_name     : db application_name : dbtest error_level : info message : test", "team_name : TeamTest application_name : TestApplication error_level : info message : ThereIsNoError"};
		int answer = 0;
		for(String log : logs) {
			if(!check(log)) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	
	static boolean check(String log) {
		//로그의 길이가 100 이하인가
		if(log.length() > 100) {
			System.out.println("100");
			return false;
		}
		String[] check_logs = log.split(" ");
		System.out.println(check_logs.length);
		//4개의 로그가 정확히 들어가는가
		if(check_logs.length != 12) {
			System.out.println("length");
			return false;
		}
		
		for(int i = 0; i < 12; i++) {
			if( i % 3 != 1) {
				if(i % 3 == 0) {
					//로그형식이 지켜졌는가
					for(int j = 0; j < log_type[i / 3].length(); j++) {
						try {
							if(check_logs[i].charAt(j) != log_type[i / 3].charAt(j)) {
								System.out.println("type");
								return false;
							}
						}catch(Exception e){
							return false;
						}
					}
				}else {
					//알파벳 대문자 소문자인지 판단
					for(int j = 0; j < check_logs[i].length(); j++) {
						if(check_logs[i].charAt(j) >= 'a' && check_logs[i].charAt(j) <= 'z') {
							continue;
						}else if(check_logs[i].charAt(j) >= 'A' && check_logs[i].charAt(j) <= 'Z') {
							continue;
						}else {
							System.out.println("alphabet");
							return false;
						}
					}	
				}
			}
		}
		System.out.println("성공");
		return true;
	}
}
