package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 주사위
public class P1233 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s1=Integer.parseInt(st.nextToken());
		int s2=Integer.parseInt(st.nextToken());
		int s3=Integer.parseInt(st.nextToken());
		int arr[]=new int[s1+s2+s3+1]; //최빈합을 구하기 위한 배열 (합의 최댓값: s1+s2+s3)
		int answer=0; // 답을 출력하기 위한 변수 
		
		for(int i=1;i<=s1;i++) {
			for(int j=1;j<=s2;j++) {
				for(int k=1;k<=s3;k++) {
					int sum=i+j+k;
					arr[sum]++;
				}
			}
		}
		
		int max=0;// 가장 큰 값을 구하기 위한 변수 max
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) { // 가장 값이 큰 배열을 찾음
				max=arr[i];
				answer=i; // 가장 많이 발생하는 합 == 가장 값이 큰 배열의 인덱스
			}		
		}
		System.out.println(answer);
	}

}
