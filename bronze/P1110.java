package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 더하기 사이클
public class P1110 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int count=0; //사이클의 길이를 구하는 변수
		int num=n;
		
		while(true) {
			int front= num/10; //앞자리 수 
			int back=num%10; //뒷자리 수
			num=back*10+((front+back)%10); //새로운 수 만들기
			
			count++; //사이클 증가
			
			if(num==n) //새로운 수가 처음 입력받은 n과 같아지면
				break; //반복문 탈출
		}
		System.out.println(count); //사이클 개수 출력 
	}

}
