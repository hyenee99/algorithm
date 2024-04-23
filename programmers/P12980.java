package programmers;

public class P12980 {
	//점프와 순간이동
	public int solution(int n) {
		int ans = 0;
		while (n > 0) {
			if (n % 2 == 1) {
				ans += 1;
			}
			n /= 2;
		}
		return ans;
	}
}
