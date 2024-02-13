package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1032 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine()); //테스트케이스 개수
		String arr[]=new String[t];
		
		for(int i=0;i<t;i++) {
			arr[i]=br.readLine();
		}
		StringBuilder sb=new StringBuilder(arr[0]); //첫번째 문자열을 sb에 저장
		
		for(int i=1;i<arr.length;i++) { //배열의 크기만큼, 문자열의 개수만큼 반복문 (0번째는 sb에 저장했으므로 1번째부터 반복문)
			for(int j=0;j<arr[i].length();j++) { //해당 문자열의 길이만큼 반복문 돌기
				if(sb.charAt(j)!=arr[i].charAt(j)) // 문자가 다른 부분을 찾아서
					sb.setCharAt(j, '?'); // 해당 부분의 값을 ?로 바꾸기
			}
		}
		System.out.println(sb);
	}	

}
