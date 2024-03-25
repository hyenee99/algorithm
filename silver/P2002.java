package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//추월
public class P2002 {
	static String input[];
	static String output[];
	static int n;
	static int count=0;
	
	static void find(String num,String arr[]) {
		int index=0;
		boolean passed=true;
		
		for(int i=0;i<output.length;i++) {
			if(output[i].equals(num)) {
				index=i;
				break;
			}
		}
		if(index==0) {
			count++;
		}
		else {
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<index;j++) {
					if(arr[i].equals(output[j])) {
						passed=false;
						break;
					}
					else
						passed=true;
				}
				if(passed) {
					count++;
					break;
				}
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine()); //차 대수 입력받음
		input=new String[n]; //들어가는 순서
		output=new String[n]; //나오는 순서 

		for(int i=0;i<n;i++) {
			input[i]=br.readLine();
		}
		for(int i=0;i<n;i++) {
			output[i]=br.readLine();
		}
		for(int i=1;i<input.length;i++) {
			String arr[]=new String[i];
			for(int j=0;j<=i-1;j++) {
				arr[j]=input[j];
			}
			find(input[i],arr);//해당 배열을 계산하는 함수에 전달 input[i],arr
		}
		System.out.println(count);
	}

}
