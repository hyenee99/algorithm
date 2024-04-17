package programmers;

public class P70129 {
	//이진 변환 반복하기
	static int removeNum = 0;
	static String remove_0(String s) { // 0을 제거하는 함수
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '0')
				str += s.charAt(i);
			else
				removeNum++; // 제거하는 0의 개수 증가
		}
		return str;
	}

	public int[] solution(String s) {
		int count = 0;
		while (!s.equals("1")) {
			s = remove_0(s); // 0을 제거
			s = Integer.toBinaryString(s.length());
			count++; // 이진 변환의 횟수
		}

		int[] answer = { count, removeNum };
		return answer;
	}
}
