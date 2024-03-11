package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//근손실
public class P18429 {
	static int n; //n일동안
	static int k; //하루가 지날때마다 감소하는 중량
	static int increase[];  //운동키트의 중량 증가량 
	static int exercise[]; //운동키트 적용 순서 
	static boolean visited[];
	static int count=0; //조건을 만족하는 경우의 수를 세기 위한 변수 
	
	static void permutation(int depth) { //운동키트의 적용 순서를 구하는 함수 
		if(depth==n) {
			satisfied(exercise);
			return;
		}
		for(int i=1;i<=n;i++) {
			if(visited[i])
				continue;
			exercise[depth]=increase[i];
			visited[i]=true;
			permutation(depth+1);
			visited[i]=false;
		}
	}
	static void satisfied(int exercise[]) { //적용 순서에 따른 조건 만족 여부를 계산하는 함수 
		int weight=500;
		boolean satisfied=true;
		
		for(int i=0;i<exercise.length;i++) {
			weight=(weight-k)+exercise[i];
			
			if(weight<500) {
				satisfied=false;
				break;
			}
		}
		
		if(satisfied) //모든 시점에서 중량이 500보다 작아지지 않은 경우 
			count++; //경우의 수 증가 
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken()); 
		k=Integer.parseInt(st.nextToken()); 
		increase=new int[n+1];
		exercise=new int[n];
		visited=new boolean[n+1];
		
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			increase[i]=Integer.parseInt(st.nextToken());
		}
		
		permutation(0);
		System.out.println(count);
	}

}
