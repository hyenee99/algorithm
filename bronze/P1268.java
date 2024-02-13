package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 임시 반장 정하기
public class P1268 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine()); //학생 수를 나타내는 정수
		int s_class[][]=new int[n][5]; //학생들의 5학년까지의 반을 저장하기 위한 배열
		boolean overlap[]=new boolean[n]; //중복 확인 
		int leader[]= new int[n]; //같은 반이었던 학생 수를 세기 위한 배열 
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				s_class[i][j]=Integer.parseInt(st.nextToken()); // 배열에 값을 입력받음
			}
		}
		
		for(int i=0;i<n;i++) { //학생 번호 
			for(int j=0;j<5;j++) { // 학년 
				for(int k=0;k<n;k++) {
					if(i!=k) { //자기 자신은 비교하지 않음 
						if(!overlap[k]&&s_class[i][j]==s_class[k][j]) { // k번 학생과 같은 반 된 적 없고, 반이 같을 때 
							overlap[k]=true; // k번 학생과 같은 반 된 적 있음 
							leader[i]++; // i번 학생과 같은 반이었던 학생 수 증가 
						}
							
					}
				}
			}
			Arrays.fill(overlap, false); //다음 학생으로 넘어갈 때는 중복을 확인하는 배열 값을 모두 false로 바꿔준다. 
		}
		
		int max=0; //가장 큰 값을 찾기 위한 변수
		int answer=0; //정답 출력을 위한 변수 
		for(int i=0;i<leader.length;i++) {
			if(leader[i]>max) {
				max=leader[i];
				answer=i+1; //i가 0번째 학생부터 시작하므로 해당 인덱스에서 +1을 해줘야함 
			}
		}
		if(max==0) //만약 max가 0이라면
			answer=1; // 임시 반장은 1번째 학생
		
		System.out.println(answer); // 정답 출력 
	}

}
