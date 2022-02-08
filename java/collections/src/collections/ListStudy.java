package collections;

import java.util.ArrayList;
import java.util.List;

public class ListStudy {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("이현규");
		list.add("송다현");
		String name = list.get(0);
		String herName = list.get(1);
		System.out.println("my name : " + name + " and her name is" + herName);
		for(String ourname: list) {
			System.out.println("our name is " + ourname + " and ...");
		}
	}
}
