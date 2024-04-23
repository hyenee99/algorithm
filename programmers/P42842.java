package programmers;

public class P42842 {
	//카펫
	public int[] solution(int brown, int yellow) {
		int width = 0, length = 0;

		for (int i = 3; i <= brown + yellow; i++) {
			length = i; // 세로
			width = (brown + yellow) / length; // 가로

			if (width < 3)
				continue;
			else {
				if ((width - 2) * (length - 2) == yellow)
					break;
			}

		}

		int[] answer = { width, length };
		return answer;
	}
}
