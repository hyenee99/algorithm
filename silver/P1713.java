package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1713 {
	static int photo[];
	static int number[];
	static int recommend[];
	static int updated[];
	static int updateNum=1;
	
	static void post(int num) {
		boolean isPosted=false;
		int index=-1;
		
		for(int i=0;i<photo.length;i++) {
			if(photo[i]==num) { //이미 사진이 게시되어 있음
				recommend[num]++; //해당 번호를 가진 학생의 추천횟수 증가 
				updated[num]=updateNum; //업데이트 번호 넣기 
				updateNum++;
				isPosted=true; // 사진 게시됨
			}
		}
		
		if(!isPosted) { // 게시되지 않은 경우
			for(int i=0;i<photo.length;i++) {
				if(photo[i]==0) { // 사진 비어있는 곳이 있으면
					index=i; //인덱스 저장
					break;
				}
			}
			
			if(index==-1) { //사진 칸이 꽉 차 있는 경우 
				int deletedIndex=counting(photo); //추천 횟수를 확인하는 함수 실행 
				photo[deletedIndex]=num;
			}
			else { //사진 칸이 비어있는 곳이 있는 경우
				photo[index]=num;
			}
			recommend[num]++;
			updated[num]=updateNum;
			updateNum++;
		}
	}
	static int counting(int arr[]) {
		int min=recommend[arr[0]];
		int oldest=updated[arr[0]];
		int count=0;
		int index=0;
		
		for(int i=0;i<arr.length;i++) {
			min=Math.min(min, recommend[arr[i]]); //min => 추천 횟수가 가장 작은 값
		}
		
		for(int i=0;i<arr.length;i++) {
			if(recommend[arr[i]]==min)
				count++;
		}
		
		if(count>=2) { //추천 받은 횟수가 적은 사람이 2명 이상
			for(int i=0;i<arr.length;i++) {
				oldest=Math.min(oldest,updated[arr[i]]); //제일 값이 작은 값을 찾음 => 가장 오래 게시되어있던
			}
			
			for(int i=0;i<arr.length;i++) {
				if(updated[arr[i]]==oldest) {
					System.out.println(arr[i]);
					recommend[arr[i]]=0; //추천 받은 횟수 0으로 변경 => 삭제 
					index=i;
				}
			}
		}
		else { //추천 받은 횟수가 적은 사람이 1명 
			for(int i=0;i<arr.length;i++) {
				if(recommend[arr[i]]==min) {
					recommend[arr[i]]=0; //추천 받은 횟수 0으로 변경 => 삭제 
					index=i;
				}
			}
		}
		return index;
	}
	//후보 추천하기
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine()); //사진 틀의 개수 
		int count=Integer.parseInt(br.readLine()); //전체 학생의 총 추천 횟수 
		
		photo=new int[n];
		number=new int[count]; //추천 학생 번호를 저장하는 배열 
		recommend=new int[101]; //추천 받은 횟수를 저장하는 배열
		updated=new int[101]; //업데이트된 걸 저장하는 함수 (숫자가 작을수록 오래됐다는 뜻)
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<count;i++) {
			number[i]=Integer.parseInt(st.nextToken()); //추천 학생 번호 저장
		}
		for(int i=0;i<number.length;i++) {
			post(number[i]);
		}
//		for(int i=1;i<=6;i++) {
//			System.out.print("recommend"+i+":"+recommend[i]);
//		}
		Arrays.sort(photo);
		for(int i=0;i<photo.length;i++) {
			System.out.print(photo[i]+" ");
		}
	
	}

}
