package programmers;

import java.util.*;

public class P138476 {
	class Solution {
	    public int solution(int k, int[] tangerine) {
	        int answer = 0;
	        int arr[]=new int[10000001];
	        
	        for(int i=0;i<tangerine.length;i++){
	            arr[tangerine[i]]++;
	        }
	       
	        Arrays.sort(arr);
	        
	        int index=arr.length-1;
	        while(k>0){
	            k=k-arr[index];
	            index--;
	            answer++;
	        }
	        return answer;
	    }
	}
}
