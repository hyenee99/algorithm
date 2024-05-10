package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2578 {
	// 빙고
	static int bingo[][];
	static int called[][];
	static int count = 0; // 빙고 개수를 세는 변수

	static void vertical() { // 세로 검사
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			cnt = 0;
			for (int j = 0; j < 5; j++) {
				if (bingo[j][i] == 0)
					cnt++;
			}
			if (cnt == 5)
				count++;
		}

	}

	static void horizontal() { // 가로 검사
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			cnt = 0;
			for (int j = 0; j < 5; j++) {
				if (bingo[i][j] == 0)
					cnt++;
			}
			if (cnt == 5)
				count++;
		}
	}

	static void intersection_1() { // 대각선 검사
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (bingo[i][i] == 0)
				cnt++;
		}
		if (cnt == 5)
			count++;
	}

	static void intersection_2() { // 대각선 검사
		int cnt = 0;
		int j = bingo.length - 1;
		for (int i = 0; i < 5; i++) {
			if (bingo[i][j] == 0) {
				cnt++;
			}
			j--;
		}
		if (cnt == 5)
			count++;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bingo = new int[5][5];
		StringTokenizer st;

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int k = 1; k <= 25; k++) {
			int num = Integer.parseInt(st.nextToken());

			if (k % 5 == 0)
				st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (bingo[i][j] == num) // 사회자가 부른 숫자와 같다면 0으로 바꾸기
						bingo[i][j] = 0;
				}
			}

			vertical();
			horizontal();
			intersection_1();
			intersection_2();
			
			
			if (count >= 3) { // 3줄 이상 빙고이면 몇 번째 숫자인지 출력하고 종료
				System.out.println(k);
				break;
			}
			count=0; //계속 세로,가로,대각선 검사를 수행하므로 다음 반복문으로 넘어갈 때는 count를 0으로 바꿔줘야함
		}
	}

}
