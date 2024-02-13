package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 쉽게 푸는 문제 
public class P1292 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int count = 0;
		int sum = 0;

		int i = 1;
		boolean repeat=true;
		
		while (true) {
			if(!repeat) {
				break;
			}
			else {
				for (int j = 1; j <= i; j++) {
					if (count == b) {
						repeat=false;
						break;
					}
					if (count >= a-1) {
						sum += i;
					}
					count++;
				}
				i++;
			}
		}
		System.out.println(sum);
	}

}
