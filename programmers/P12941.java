package programmers;

import java.util.*;

public class P12941 {
	//최솟값 만들기
	public int solution(int[] A, int[] B) {
		Integer b[] = new Integer[B.length];

		for (int i = 0; i < B.length; i++) {
			b[i] = B[i];
		}

		Arrays.sort(A); // A 배열을 오름차순으로 정렬
		Arrays.sort(b, Collections.reverseOrder()); // b 배열을 내림차순으로 정렬

		int answer = 0;
		for (int i = 0; i < A.length; i++) {
			int times = A[i] * b[i];
			answer += times;
		}

		return answer;
	}
}
