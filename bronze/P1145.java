package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//적어도 대부분의 배수
public class P1145 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int arr[] = new int[5]; // 숫자를 입력받기 위한 배열
		int answer=0; // 적어도 대부분의 배수 (정답)

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // 배열에 값을 저장
		}
		Arrays.sort(arr); //배열 정렬
		int start=arr[0]; //배열의 첫번째 값을 시작으로 설정
		
		while(true) {
			int count=0;
			
			for(int i=0;i<arr.length;i++) {
				if(start%arr[i]==0) //나누어 떨어지면
					count++; //count 값 증가
			}
			
			if(count>=3) { //count가 3 이상이면
				answer=start;
				break;
			}
			
			start++; //값 증가
		}
		System.out.println(answer);
		

	}

}
