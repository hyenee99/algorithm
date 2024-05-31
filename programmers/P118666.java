import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        char arr[][]={{'R','T'},{'C','F'},{'J','M'},{'A','N'}};
        HashMap<Character,Integer> map=new HashMap<>();
        HashMap<Integer,Integer>score= new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                map.put(arr[i][j],0);
            }
        }
        
        //선택에 따른 점수 저장
        int num=3;
        for(int i=1;i<=7;i++){
            if(i<4){
                score.put(i,num);
                num--;
            }
            else {
                score.put(i,num);
                num++;
            }
        }
        
        for(int i=0;i<survey.length;i++){
            char c1=survey[i].charAt(0);
            char c2=survey[i].charAt(1);
            
            if(choices[i]<5){
                map.put(c1, map.get(c1) + score.get(choices[i]));
            }
            else{
                map.put(c2, map.get(c2) + score.get(choices[i]));
            }
        }
        
        String answer = "";
        for(int i=0;i<arr.length;i++){
            Arrays.sort(arr[i]);//오름차순 정렬
            
            int score1=map.get(arr[i][0]);
            int score2=map.get(arr[i][1]);
            
            if(score1>=score2)
                answer+=arr[i][0];
            else
                answer+=arr[i][1];
        }
        return answer;
    }
}
