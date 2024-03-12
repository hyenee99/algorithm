package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1138 {
	//한 줄로 서기
	static int n;
	static boolean visited[];
	static int height[];
	static int sequence[]; 
	static int taller[];
	
	static void permutation(int depth) { 
		if(depth==n) {
			condition(sequence);
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(visited[i])
				continue;
			
			sequence[depth]=height[i];
			visited[i]=true;
			permutation(depth+1);
			visited[i]=false;
		}
		
	}
	
	static void condition(int arr[]) { //조건을 만족하는지 확인하는 함수 
		boolean satisfied=true;
		
		for(int i=0;i<arr.length;i++) {
			int count=0;
			
			if(i==0) {
				if(taller[arr[i]]!=0) {
					satisfied=false;
					break;
				}
			}
			else {
				for(int j=0;j<i;j++) {
					if(arr[j]>arr[i])
						count++;
				}
				
				if(count!=taller[arr[i]]) {
					satisfied=false;
					break;
				}
			}
		}
		
		if(satisfied) {
			for(int i=0;i<arr.length;i++) {
				System.out.print(arr[i]+" ");
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine()); //사람의 수
		visited=new boolean[n+1];
		height=new int[n]; //키를 저장하는 배열
		sequence=new int[n]; //순서를 정하는 배열
		taller=new int[n+1]; //자기보다 큰 사람이 왼쪽에 몇 명 있는지  
		
		for(int i=0;i<n;i++) {
			height[i]=i+1;
		}
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			taller[i]=Integer.parseInt(st.nextToken());
		}
		
		permutation(0);
	}

}
