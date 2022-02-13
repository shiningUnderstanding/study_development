package stack;

import java.util.Stack;

public class StackStudy {
	public static void main(String[] args) {
		Stack<String> coin = new Stack<>();
		coin.push("bitcoin");
		coin.push("ripple");
		coin.push("etherium");
		coin.push("cardano");
		coin.push("stella");
		
		while(!coin.isEmpty()) {
			String coinName = coin.pop();
			System.out.println("꺼낸coin은 " + coinName);
		}
	}
}
