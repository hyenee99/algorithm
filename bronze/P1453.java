package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//피시방 알바
public class P1453 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		boolean seated[]=new boolean[101];
		int refuse=0; //거절당하는 사람의 수
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine()); //손님의 수 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int seat=Integer.parseInt(st.nextToken()); //앉고 싶은 자리 
			if(seated[seat]!=true) { //자리가 비어있을 때
				seated[seat]=true;
			}
			else { //자리가 차있을 때
				refuse++; //거절 당한 사람의 수 증가 
			}
		}
		System.out.println(refuse);
	}

}
