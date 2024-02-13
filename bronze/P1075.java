package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1075 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int f=Integer.parseInt(br.readLine());
		int answer=0;
		
		n=n/100*100; //뒤의 두 자리를 00으로 바꿔줌
		while(true) {
			if(n%f==0) {
				answer=n%100;	
				break;
			}
			else
				n++;
		}
		if(answer<10) //한 자리이면 앞에 0 붙여서 출력 
			System.out.println("0"+answer); //그냥 출력형식만 해주면 되는데 왜 어렵게 생각했지? 
		else
			System.out.println(answer);			
	}

}
