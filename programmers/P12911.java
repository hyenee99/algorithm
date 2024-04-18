package programmers;

public class P12911 {
	//다음 큰 숫자 
	static String binary;
	static int count_1;

	static int count_1(int num) {
		binary = Integer.toBinaryString(num);
		binary = binary.replace("0", ""); // 0을 제거하기

		count_1 = binary.length(); // 1만 남았으므로 1의 개수==문자열의 길이

		return count_1; // 개수 반환
	}

	public int solution(int n) {
		int answer = 0;

		int num = count_1(n);
		for (int i = n + 1; i <= 1000000; i++) {
			if (count_1(i) == num) {
				answer = i;
				break;
			}
		}
		return answer;
	}
}
