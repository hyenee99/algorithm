package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//운동
public class P1173 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 운동 시간
		int m = Integer.parseInt(st.nextToken()); // 초기 맥박
		int M = Integer.parseInt(st.nextToken()); // 맥박이 M을 넘으면 안됨
		int T = Integer.parseInt(st.nextToken()); // 증가
		int R = Integer.parseInt(st.nextToken()); // 감소

		int count = 0;// 운동을 한 시간을 세는 변수
		int min = 0; // 시간의 최솟값 (= 반복문을 돈 횟수)
		int now_pulse = m; // 현재 맥박

		if (M - m < T) // 운동을 할 수 없는 경우 (최대 맥박과 최소 맥박의 차이 < 운동하면 상승하는 T)
			min = -1;
		else {
			while (count<N) {
				if (now_pulse + T > M) { // 휴식 하는 경우
					now_pulse -= R; // 맥박을 R만큼 감소

					if (now_pulse < m) // 감소시킨 맥박이 m보다 작다면
						now_pulse = m; // 맥박의 값을 m으로 변경
				} else { // 운동 하는 경우
					now_pulse += T; // 맥박을 T만큼 증가
					count++; // 운동 횟수 증가
				}
				min++;
			}
		}

		System.out.println(min);
	}

}
