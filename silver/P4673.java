package silver;
//셀프 넘버
public class P4673 {
	static int create_num(int n) { //각 자리의 수를 더해 새로운 수를 반환하는 함수 
		int num=n;
		int new_num=num;
		
		while(num!=0) {
			new_num+=num%10;
			num=num/10;
		}
		return new_num;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]=new int[10001];
		
		for(int i=1;i<10001;i++) {
			int start=i;
			
			while(true) {
				int new_num=create_num(start); //start에 있는 값을 인수로 전달하여 새로운 수를 받아옴
				
				if(new_num>10000) //새로운 수가 10000을 넘으면 정지 
					break;
				else {
					arr[new_num]++; //생성된 새로운 수는 생성자가 있다는 뜻이므로 해당 인덱스의 배열 값 증가 / ex) arr[39]= 1일 경우, 39는 생성자 1개 있다는 뜻 
					start=new_num; //새로 생성된 수를 시작으로 설정 
				}
			}
		}
		
		for(int i=1;i<arr.length;i++) {
			if(arr[i]==0) { //배열 값이 0이다 => 생성자가 없다. 
				System.out.println(i);
			}
		}
	}

}