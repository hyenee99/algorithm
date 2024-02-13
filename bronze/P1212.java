package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//8진수 2진수
public class P1212 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n=br.readLine();
		String binary[]= {"000","001","010","011","100","101","110","111"};
		
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<n.length();i++) {
			int num=n.charAt(i)-'0';
			sb.append(binary[num]);
		}
		if(n.equals("0")) //입력받은 수가 0일 때
			System.out.println(n); //0을 출력
		else { //입력 받은 수가 0이 아닐때 
			while(sb.charAt(0)=='0') { //맨 앞의 수가 0인 경우 반복문 돌기
				sb=new StringBuilder(sb.substring(1)); //문자열 자르기 
			}
			System.out.println(sb);
		}	
	}

}
