package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//단어 공부
public class P1157 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine(); // 단어 입력받기
		int arr[] = new int[26]; // 알파벳의 개수를 저장할 배열 , arr[0]='A'의 개수
		word = word.toUpperCase(); // 모두 대문자로 변경

		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 65; // 아스키 코드를 이용, 'A'=65
			arr[index]++;
		}

		int max = 0; // 배열 값이 가장 큰 걸 찾기 위한 변수 
		char answer = ' '; //정답 출력을 위한 변수 

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) { // 배열 값이 max 값보다 크면
				max = arr[i]; // max 값 변경
				answer = (char) (i + 65); // 가장 많이 사용된 알파벳 => 인덱스 + 65 
			}
			else if (arr[i] == max) //가장 많이 사용된 알파벳이 존재하는 경우(개수가 같음)
				answer = '?'; //물음표 출력
		}
		System.out.println(answer);
	}

}
