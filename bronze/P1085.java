package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1085 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		//현재의 위치
		int x=Integer.parseInt(st.nextToken());
		int y=Integer.parseInt(st.nextToken());
		//오른쪽 위 꼭짓점
		int w=Integer.parseInt(st.nextToken());
		int h=Integer.parseInt(st.nextToken());
		
		int x_min=Math.min(x, w-x); //x 축 최소 거리
		int y_min=Math.min(y, h-y); //y 축 최소 거리
		
		System.out.println(Math.min(x_min, y_min));
	}

}
