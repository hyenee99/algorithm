package silver;

import java.util.ArrayList;
import java.util.Scanner;

public class P12873 {
	//기념품
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt(); //캠프 참가자의 수
		ArrayList<Integer>list=new ArrayList<>();
		
		for(int i=1;i<=n;i++) {
			list.add(i);
		}
		
		int stage=1;
		int index=0;
		
		while(true) {
			if(list.size()==1) 
				break;
			
			long delete=(long)Math.pow(stage,3);
			index=(int)((index+delete-1)%list.size());
			
			list.remove(index);
			stage++;
		}
		
		System.out.println(list.get(0));
		scanner.close();
	}

}
