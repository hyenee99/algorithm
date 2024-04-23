package programmers;

public class P12981 {
	//영어 끝말잇기
	public int[] solution(int n, String[] words) {
		int num = 0; // 번호
		int turn = 0; // 차례
		boolean wrong = false;

		for (int i = 1; i < words.length; i++) {
			char last = words[i - 1].charAt(words[i - 1].length() - 1);

			if (last != words[i].charAt(0)) { // 끝말잇기 잘못됨
				num = i % n + 1;
				turn = i / n + 1;
				break;
			}

			for (int j = 0; j <= i - 1; j++) { // 앞에 나온적 있는지 확인
				if (words[j].equals(words[i])) {
					num = i % n + 1;
					turn = i / n + 1;
					wrong = true;
					break;
				}
			}

			if (wrong)
				break;
		}

		int[] answer = { num, turn };
		return answer;
	}
}
