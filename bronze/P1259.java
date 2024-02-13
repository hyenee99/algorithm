package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//팰린드롬 수 
public class P1259 {
	static boolean check_palindrome(String s) { //팰린드롬 수인지 확인하는 함수 
		int start = 0;
		int end = s.length() - 1;
		boolean isPalindrome = true;

		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(start) != s.charAt(end)) {
				isPalindrome = false;
				break;
			} else {
				start++;
				end--;
			}
		}
		return isPalindrome;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String s = br.readLine();
			if (s.equals("0")) { //문자열 비교는 == 아니고 equals 사용해야한다. 
				break;
			} else {
				boolean result = check_palindrome(s);

				if (result) {
					System.out.println("yes");
				} else {
					System.out.println("no");
				}
			}

		}
	}

}
