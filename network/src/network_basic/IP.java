package network_basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IP {

	public static void main(String[] args) {
		try {
			InetAddress ia = InetAddress.getLocalHost();
			System.out.println("my ip : " + ia);
			
			ia = InetAddress.getByName("youtube.com");
			System.out.println("youtube ip : " + ia);
			
			InetAddress[] iaArr = InetAddress.getAllByName("naver.com");
			for(InetAddress ia1 : iaArr) {
				System.out.println("naver ip : " + ia1);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
