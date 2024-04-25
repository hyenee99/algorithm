package programmers;

public class P12985 {
	public int solution(int n, int a, int b) {
		int answer = 0;
		double num1 = (double) a;
		double num2 = (double) b;

		while (a != b) {
			num1 = Math.ceil(num1 / 2);
			num2 = Math.ceil(num2 / 2);

			a = (int) num1;
			b = (int) num2;
			answer++;
		}

		return answer;
	}
}
