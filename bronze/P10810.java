package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10810 {
	//공 넣기
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int basket[]=new int[n+1]; //바구니 배열 생성
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			int ball=Integer.parseInt(st.nextToken());
			
			for(int j=start;j<=end;j++) {
				basket[j]=ball;
			}
		}
		
		for(int i=1;i<basket.length;i++) {
			System.out.print(basket[i]+" ");
		}
	}

}
