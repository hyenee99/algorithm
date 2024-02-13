package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//저항
public class P1076 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String color[]= {"black", "brown","red","orange","yellow","green",
				"blue","violet","grey","white"};
		int multiply[]= {1,10,100,1000,10000,100000,1000000,10000000,100000000,1000000000};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String color1=br.readLine();
		String color2=br.readLine();
		String color3=br.readLine();
		
		int index=0;
		String answer="";
		long result=0;
		
		for(int i=0;i<color.length;i++) {
			if(color[i].equals(color1)) //문자열은 == 이 아닌 equals를 사용해야 비교 가능 
				answer=String.valueOf(i); // String.valueof : int 형을 String 으로 변환 
			if(color[i].equals(color3))
				index=i;
		}
		for(int i=0;i<color.length;i++) {
			if(color[i].equals(color2))
				answer=answer+String.valueOf(i);
		}
		
		result=Long.parseLong(answer)*multiply[index]; //곱하면 int 범위 초과하므로 long 형으로 하기 
		System.out.println(result);
	}

}
