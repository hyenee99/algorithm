package programmers;
import java.util.*;

public class P12973 {
	//짝지어 제거하기
	public int solution(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (!stack.isEmpty() && stack.peek() == c)
				stack.pop();
			else
				stack.push(c);
		}

		return stack.isEmpty() ? 1 : 0;
	}
}