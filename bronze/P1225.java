package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//이상한 곱셈
public class P1225 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String a=st.nextToken();
		String b=st.nextToken();
		long result=0; //int형으로 하면 범위를 초과함
		
		for(int i=0;i<a.length();i++) {
			for(int j=0;j<b.length();j++) {
				result+=(a.charAt(i)-'0')*(b.charAt(j)-'0'); //이렇게 하면 char형이 int형으로 변환됨
			}
		}
		System.out.println(result);
	}

}
