class Solution {
    public int solution(String s) {
        char x=s.charAt(0);
        int x_cnt=0,not_x=0;
        int answer = 0;
        
        for(int i=0;i<s.length();i++){
            if(x_cnt==not_x){
                answer++;
                x=s.charAt(i);
                x_cnt=0;
                not_x=0;
            }
            if(x==s.charAt(i))
                x_cnt++;
            else
                not_x++;
        }
        
        return answer;
    }
}
