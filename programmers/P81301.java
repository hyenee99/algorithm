import java.util.*;
class Solution {
    public int solution(String s) {
        HashMap<String,Integer> map=new HashMap<>();
        String arr[]={"zero","one","two","three","four","five",
                      "six","seven","eight","nine"};
        for(int i=0;i<10;i++){
            map.put(arr[i],i); //map 에 저장
        }
        
        for(String key:map.keySet()){
            if(s.contains(key))
             s=s.replace(key,Integer.toString(map.get(key)));
        }
        
        int answer = Integer.parseInt(s);
        return answer;
    }
}
