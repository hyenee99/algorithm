package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//농구 경기
public class P1159 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 선수의 수를 입력받음
		int arr[] = new int[26]; // 알파벳의 개수를 저장할 배열

		for (int i = 0; i < n; i++) {
			String name = br.readLine(); // 선수의 성을 입력받음
			int index = name.charAt(0) - 97; // 소문자 a의 아스키코드 값이 97인 것을 이용하여 인덱스 값 지정
			arr[index]++; //해당 인덱스의 배열 값 증가 
		}
		String result = "";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 5) //배열 값이 5 이상이면(= 성의 첫 글자가 같은 선수가 5명 이상)
				result += (char) (i + 97); //해당 인덱스를 문자로 변환하여 result 변수에 이어붙임
		}

		if (result.equals("")) //만약 값이 5 이상인 배열이 없어서 result 값이 변하지 않았다면
			result = "PREDAJA"; 

		System.out.println(result);
	}

}
