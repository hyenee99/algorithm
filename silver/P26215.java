package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P26215 {
	// 눈 치우기
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 집의 수
		int house[] = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			house[i] = Integer.parseInt(st.nextToken());
		}

		int time = 0;
		int max_index = n - 1;
		
		if(n==1) {
			time= house[0];
		}
		else {
			while (true) {
				Arrays.sort(house); // 오름차순 정렬

				if (house[max_index] == 0 && house[max_index - 1] == 0)
					break;

				house[max_index]--;

				if (house[max_index - 1] != 0)
					house[max_index - 1]--;

				time++;

			}
		}

		if (time > 1440)
			System.out.println("-1");
		else
			System.out.println(time);
	}

}
