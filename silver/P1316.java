package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P1316 {
	static ArrayList<Character>list=new ArrayList<>();
	static ArrayList<Character> find_alphabet(String s) { // 문자열에 들어있는 알파벳을 찾는 함수
		boolean added[]=new boolean[26]; //이미 추가 되었는지 확인
		list.clear();
		
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			
			if(!added[c-97]) {
				list.add(c);
				added[c-97]=true;
			}
		}
		return list;
	}
	static boolean check_group(String s) { //그룹 단어인지 확인하는 함수 
		int index=0;
		boolean group=true;
		
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<s.length();j++) {
				if(list.get(i)==s.charAt(j)) {
					if(j!=0&&j!=index+1) {
						group=false;
						break;
					}
					else
						index=j;
				}
			}
		}
		return group;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String arr[]=new String[n];
		int count=0; //그룹 단어의 개수를 세기 위한 변수 
		
		for(int i=0;i<n;i++) {
			arr[i]=br.readLine(); //배열에 단어를 입력받음
			find_alphabet(arr[i]);
			
			boolean check=check_group(arr[i]);
			if(check)
				count++;
		}
		System.out.println(count);
	}

}
