package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 팀 이름 정하기
public class P1296 {
	static int count_L;
	static int count_O;
	static int count_V;
	static int count_E;
	
	static void count(String name) {
		for(int i=0;i<name.length();i++) {
			switch(name.charAt(i)) {
			case 'L':
				count_L++;
				break;
			case 'O':
				count_O++;
				break;
			case 'V':
				count_V++;
				break;
			case 'E':
				count_E++;
				break;
			default:
				continue;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name=br.readLine(); //연두 이름
		int n=Integer.parseInt(br.readLine()); //팀 이름 후보의 개수
		String team[]=new String[n]; //팀 이름 후보를 저장할 배열
		int percentage[]=new int[n]; //우승 확률을 저장할 배열
		String answer=""; //정답을 출력하기 위한 변수
		
		for(int i=0;i<n;i++) {
			team[i]=br.readLine();
		}
		Arrays.sort(team); //알파벳 순으로 정렬
		
		for(int i=0;i<n;i++) {
			count(name);
			count(team[i]);
			
			percentage[i]=((count_L+count_O)*(count_L+count_V)*(count_L+count_E)*(count_O+count_V)*(count_O+count_E)*(count_V+count_E))%100;
			count_L=0;
			count_O=0;
			count_V=0;
			count_E=0;
		}
		
		int max=-1; //max를 0으로 설정하면 확률이 0인 경우 max 값이 바뀌지 않으므로 -1로 설정 
		//알파벳 순으로 이미 정렬을 완료했으므로 max 값을 찾아서 해당 인덱스의 이름을 출력하면 됨! 
		for(int i=0;i<percentage.length;i++) {
			if(percentage[i]>max) {
				max=percentage[i];
				answer=team[i];
			}
		}
		
		System.out.println(answer);
		
	}

}
