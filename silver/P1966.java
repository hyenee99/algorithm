package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
//프린터 큐
class Printer {
	int sequence; //순서
	int importance; //중요도
	
	Printer(int sequence, int importance){
		this.sequence=sequence;
		this.importance=importance;
	}
	
}
public class P1966 {
	//몇 번째로 출력되는지 계산하는 함수 
	static int solution(Queue<Printer> q, PriorityQueue<Integer> pq, int m) {
		int count=1;
		
		while(true) {
			while(pq.peek()!=q.peek().importance) {
				q.offer(q.poll());
			}
			if(q.peek().sequence==m) {
				break;
			}
			q.poll();
			pq.poll();
			count++;
		}
		return count;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int test_case=Integer.parseInt(br.readLine());
		
		for(int i=0;i<test_case;i++) {
			st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken()); //문서의 개수
			int m=Integer.parseInt(st.nextToken()); //궁금한 문서가 현재 몇 번째에 놓여있는지
			
			Queue<Printer> q=new LinkedList<>(); // 큐 생성
			//우선순위큐 내림차순 정렬
			PriorityQueue<Integer> pq= new PriorityQueue<>(Comparator.reverseOrder());
			
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) { //문서의 중요도 
				int importance=Integer.parseInt(st.nextToken());
				q.offer(new Printer(j,importance)); //큐에는 Printer 객체(순서, 중요도) 를 저장
				pq.offer(importance); //우선순위큐에는 중요도만 저장 
			}
			
			System.out.println(solution(q,pq,m));
		}
	}

}
