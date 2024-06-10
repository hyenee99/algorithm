import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int cnt=0;
        
        HashMap<Integer,Integer>map=new HashMap<>(); // (일치한 개수, 등수)
        int rank=1;
        for(int i=6;i>=0;i--){
            if(i==0)
                map.put(i,6);
            else{
                map.put(i,rank);
                rank++;
            }  
        }
        
        //맞은 개수 구하기 
        for(int i=0;i<win_nums.length;i++){
            for(int j=0;j<lottos.length;j++){
                if(win_nums[i]==lottos[j])
                    cnt++;
            }
        }
        
        int zero_cnt=0;
        for(int i=0;i<lottos.length;i++){
            if(lottos[i]!=0)
                continue;
            else
                zero_cnt++;
        }
        
        int highest=map.get(cnt+zero_cnt);
        int lowest=map.get(cnt);
        
        int[] answer = {highest,lowest};
        return answer;
    }
}
