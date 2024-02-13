package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//단어의 개수
public class P1152 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		
		StringTokenizer st=new StringTokenizer(s," "); //st에 공백을 기준으로 나눈 토큰을 저장
		System.out.println(st.countTokens()); //countTokens()를 통해 토큰의 개수 반환 
	}

}
