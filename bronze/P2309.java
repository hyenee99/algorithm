package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//일곱 난쟁이
public class P2309 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int height[]=new int[9]; //9명의 난쟁이 키를 저장할 배열
		int sum=0;
		
		for(int i=0;i<height.length;i++) {
			height[i]=Integer.parseInt(br.readLine());
			sum+=height[i]; //9명의 난쟁이의 키의 합
		}
		int fakeIndex_1=0; //가짜 난쟁이의 인덱스 
		int fakeIndex_2=0;
		
		//2명의 가짜 난쟁이를 찾기 위함
		for(int i=0;i<height.length-1;i++) {
			for(int j=i+1;j<height.length;j++) {
				if(sum-height[i]-height[j]==100) { //전체 합에서 i번째 난쟁이와 j번째 난쟁이의 키를 뺐을 때 100이면 그 둘이 가짜 난쟁이이다.
					fakeIndex_1=i; //첫번째 가짜 난쟁이의 인덱스를 저장
					fakeIndex_2=j; //두번째 가짜 난쟁이의 인덱스를 저장
				}
			}
		}
		//가짜 난쟁이들의 키 배열값을 0으로 바꿔줌
		height[fakeIndex_1]=0;
		height[fakeIndex_2]=0;
		
		Arrays.sort(height); //오름차순 정렬
		
		for(int i=0;i<height.length;i++) {
			if(height[i]!=0)
				System.out.println(height[i]); //값이 0이 아닌(진짜 난쟁이) 키만 출력 
		}
		
	}

}
