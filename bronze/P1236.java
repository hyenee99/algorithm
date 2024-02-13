package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//성 지키기
public class P1236 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()); //세로
		int m=Integer.parseInt(st.nextToken()); //가로
		char arr[][]=new char[n][m]; //입력 받을 배열 생성
		
		for(int i=0;i<n;i++) {
			String s=br.readLine();
			for(int j=0;j<m;j++) {
				arr[i][j]=s.charAt(j); //배열에 값 저장
			}
		}
		
		int row_security=0; //행에 필요한 경비원 수 
		int col_security=0; //열에 필요한 경비원 수 
		
		//가로(행) 검사
		for(int i=0;i<n;i++) {
			boolean add_security=true; //추가해야 할 경비원이 있음
			
			for(int j=0;j<m;j++) {
				if(arr[i][j]=='X') { // 행에 경비원이 있으면
					add_security=false; //추가해야 할 경비원 없음
					break; //해당 행 검사 탈출
				}
			}
			if(add_security) // 행에 경비원이 아예 없었으면
				row_security++; // 행에 필요한 경비원 추가 
		}
		
		//세로(열) 검사
		for(int i=0;i<m;i++) {
			boolean add_security=true;
			
			for(int j=0;j<n;j++) {
				if(arr[j][i]=='X') { //열에 경비원이 있으면
					add_security=false; //추가해야 할 경비원 없음
					break; //해당 열 검사 탈출 
				}
			}
			if(add_security) // 열에 경비원이 아예 없었으면
				col_security++; // 열에 필요한 경비원 추가 
		}
		
		System.out.println(Math.max(row_security, col_security)); // 열과 행에 필요한 경비원 수 중에 큰 값을 출력 
	}

}
