package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//하얀 칸
public class P1100 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char arr[][]=new char[8][8];
		int count=0; //정답 출력을 위한 변수 count
		
		for(int i=0;i<8;i++) {
			String s=br.readLine();
			for(int j=0;j<8;j++) {
				arr[i][j]=s.charAt(j);
			}
		}
		
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(i%2==0) { //i가 짝수일 때 -> j가 짝수인 곳이 흰색 칸
					if(j%2!=0) //j가 홀수이면
						continue;
					else { //j가 짝수이면
						if(arr[i][j]=='F') //배열의 값이 F이면
							count++; // 개수 증가
					}
				}
				else { //i가 홀수일 때 -> j가 홀수인 곳이 흰색 칸
					if(j%2==0) //j가 짝수이면
						continue;
					else { //j가 홀수이면
						if(arr[i][j]=='F') //배열의 값이 F라면
							count++; // 개수 증가
					}
				}
			}
		}
		
		System.out.println(count);
		
	}

}
