package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17952 {
	// 과제는 끝나지 않아! 
	static int notCompleted(int arr[]) { //끝내지 않은 과제를 찾아주는 함수 (뒤에서부터 돌아서 가장 최근 추가된 과제의 인덱스를 반환)
		int index=0;
		
		for(int i=arr.length-1;i>0;i--) {
			if(arr[i]!=0) { // 0이 아니다 => 과제를 완료하지 않았다. 
				index=i;
				break;
			}
		}
		
		return index;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int semester=Integer.parseInt(br.readLine()); //이번 학기가 몇 분인지 
		int scores[]= new int[semester+1]; //점수를 저장하는 배열
		int times[]=new int[semester+1]; //과제를 하는데 걸리는 시간을 저장하는 배열
		
		int homeworkNum=0; //현재 과제 번호
		int result=0; // 결과를 출력하기 위한 변수 
		
		for(int i=1;i<=semester;i++) { // 1분 ~ 이번 학기 동안 
			StringTokenizer st=new StringTokenizer(br.readLine());
			int num=Integer.parseInt(st.nextToken()); //과제가 주어졌는지 여부를 알려주는 변수 
			
			if(num==0) { // 0일 경우: 새로운 과제 없음
				times[homeworkNum]--;
			}
			else { // 0이 아닌 경우: 새로운 과제 있음 
				int score=Integer.parseInt(st.nextToken()); //과제 점수 입력 받음
				int time=Integer.parseInt(st.nextToken()); // 과제 해결하는데 걸리는 시간 입력 받음
				homeworkNum++;
					
				scores[homeworkNum]=score; //현재 과제 번호에 해당하는 점수 저장
				times[homeworkNum]=time-1; //현재 과제 번호에 해당하는 시간 저장 (바로 시작하므로 1분 감소시켜 저장)
				
			}
			
			if(times[homeworkNum]==0) { //만약 현재 과제 번호의 해당하는 배열의 시간이 0이면 => 과제 완료했으면
				result+=scores[homeworkNum]; // 현재 과제 점수를 결과에 저장 
				homeworkNum=notCompleted(times); // 현재 과제 번호 바꾸기(이전에 완료하지 않은)
			}
		}
		
		System.out.println(result);
		
	}

}
