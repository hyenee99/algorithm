package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//회전 초밥
public class P2531 {
	static int n,d,k,c;
	static ArrayList<Integer> list=new ArrayList<>(); //먹을 수 있는 가짓수를 저장하는 list
	
	static void count_flavor(int arr[]) { //맛의 수를 세는 함수 
		boolean visited[]=new boolean[d+1]; // 초밥의 종류가 1번부터 시작하므로 배열의 크기를 d+1로 생성 
		visited[c]=true; //쿠폰으로 받은 초밥
		int count=1; // 쿠폰으로 받은 초밥이 있으므로 1부터 시작 
		
		for(int i=0;i<arr.length;i++) {
			int flavor=arr[i];
			if(!visited[flavor]) { // 이전에 똑같은 초밥을 먹은 적이 없으면 
				visited[flavor]=true; // 값을 true로 변경
				count++; //개수 증가 
			}
		}
		list.add(count); //계산한 가짓수를 list에 저장 
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken()); //접시의 수
		d=Integer.parseInt(st.nextToken()); //초밥의 가짓수
		k=Integer.parseInt(st.nextToken()); //연속해서 먹는 접시의 수
		c=Integer.parseInt(st.nextToken()); //쿠폰 번호
		int arr[]=new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine()); //회전 초밥 순서
		}
		
		for(int i=0;i<n;i++) {
			int flavor[]=new int[k]; //맛을 저장하는 배열 
			int start=i; //시작점
			int count=0; //접시의 수를 세는 변수 
			
			for(int j=0;j<k;j++) { //연속해서 먹는 접시의 수만큼 반복문 
				// 아직 연속해서 먹는 접시의 수만큼 세지 않았고, start 변수 값이 배열 끝까지 갔으면 
				if(count<k && start==arr.length) { 
					start=0; //start의 값을 0으로 변경 ex)arr의 크기가 8일 때, arr[7]은 arr[0]과 이어져있음 
				}
				flavor[j]=arr[start]; //맛을 저장하는 배열에 초밥의 번호 저장 
				start++; //시작점 증가 
				count++; //접시의 개수 증가 
			}
			count_flavor(flavor);
		}
		/* 초밥의 가짓수가 저장되어 있는 list에서 최댓값 구하기 */
		int max=0;
		for(int i=0;i<list.size();i++) {
			if(list.get(i)>max)
				max=list.get(i);
		}
		
		System.out.println(max); //최댓값 출력 
	}

}
