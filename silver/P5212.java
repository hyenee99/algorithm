package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5212 {
	// 지구 온난화
	static char origin[][]; //원본 배열
	static char changed[][];//바뀐 배열 
	static int R, C;
	
	//상하좌우가 바다인지 확인하고 3면 이상이 바다이면 바다로 바꾸는 함수 
	static void check(int x, int y) { 
		int cnt = 0;

		if (x < 1)
			cnt++;
		else {
			if (origin[x - 1][y] == '.') // 상
				cnt++;
		}

		if (x > R - 2)
			cnt++;
		else {
			if (origin[x + 1][y] == '.') // 하
				cnt++;
		}

		if (y <= 0)
			cnt++;
		else {
			if (origin[x][y - 1] == '.') // 좌
				cnt++;
		}

		if (y > C - 2)
			cnt++;
		else {
			if (origin[x][y + 1] == '.') // 우
				cnt++;
		}

		if (cnt >= 3) // 만약 바다가 3개 이상이면
			changed[x][y] = '.'; // 바다로 바꿈
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken()); // 세로
		C = Integer.parseInt(st.nextToken()); // 가로
		origin = new char[R][C];
		changed = new char[R][C];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				origin[i][j] = s.charAt(j); // 배열에 값을 저장 
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				changed[i][j] = origin[i][j]; // 2차원 배열은 clone 함수로 깊은 복사 안됨
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (origin[i][j] == 'X') { // 땅일 경우 
					check(i, j); // 상하좌우 바다인지 확인
				}
			}
		}
		
		// 좁아진 땅 출력을 위해 행의 최솟값 최댓값, 열의 최솟값 최댓값 구하기 
		int rmin=10,rmax=0,cmin=10,cmax=0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (changed[i][j] == 'X') {
					rmin=Math.min(rmin, i);
					rmax=Math.max(rmax, i);
					cmin=Math.min(cmin, j);
					cmax=Math.max(cmax, j);
				}
			}
		}
		
		//출력
		for (int i = rmin; i <=rmax; i++) {
			for (int j = cmin; j <= cmax; j++) {
				System.out.print(changed[i][j]);
			}
			System.out.println();
		}

	}

}
