package basic;

public class WatchTV {
	public static void main(String[] args) {
		TV tv;
		tv = new TV();
//		tv.power = true;//전원을 켠다.
//		tv.channel = 7;//채널을 7번으로 바꾼다.
//		tv.volume = 10;//소리는 10으로 설정한다.
//		
//		System.out.println("TV전원은 " + tv.power);
//		System.out.println("채널은 " + tv.channel);
//		System.out.println("볼륨은 " + tv.volume);
		
		boolean powerFlag = tv.isPower();
		if(!powerFlag) {
			tv.powerOn();
			tv.setChannel(7);
			for(int i = 0; i < 10; i++) {
				tv.volumeUp();
			}
			//System.out.println("볼륨은 " + tv.volume);
			tv.printInfo();
		}else {
			tv.powerOff();
		}
		System.out.println(powerFlag);
	}
}
