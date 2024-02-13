package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1037 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine()); //진짜 약수의 개수
		int arr[]=new int[n];
		int answer=0;
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr); //배열 정렬
		
		if(arr.length==1)
			answer=arr[0]*arr[0];
		else
			answer=arr[0]*arr[arr.length-1];
		
		System.out.println(answer);
		
	}

}
