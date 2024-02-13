package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1009 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int t=Integer.parseInt(br.readLine()); //테스트 케이스 개수
		
		for(int i=0;i<t;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int answer=1;
			
			for(int j=1;j<=b;j++) {
				answer=answer*a%10; //계속 뒷자리만 구하는 식으로 해야 데이터 범위를 넘지 않아서 정확한 값이 나옴, Math.pow 사용하면 무조건 초과 
			}
			if(answer==0) //마지막 숫자가 0일 경우
				answer=10; //컴퓨터 번호는 10 
			
			sb.append(answer).append("\n");
		}
		System.out.print(sb);
	}

}
