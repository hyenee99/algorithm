package programmers;

public class P12951 {
	//JadenCase 문자열 만들기
	public String solution(String s) {
		StringBuilder sb = new StringBuilder(s);

		boolean isEmpty = false;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				isEmpty = true;
				continue;
			} else {
				if (isEmpty) {
					sb.setCharAt(i, Character.toUpperCase(s.charAt(i)));
					isEmpty = false;
				} else {
					if (i == 0)
						sb.setCharAt(i, Character.toUpperCase(s.charAt(i)));
					else
						sb.setCharAt(i, Character.toLowerCase(s.charAt(i)));
				}
			}
		}

		String answer = sb.toString();
		return answer;
	}
}
