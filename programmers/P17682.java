class Solution {
    public int solution(String dartResult) {
        String num="";
        int score[]=new int[3];
        int index=0;
        
        for(int i=0;i<dartResult.length();i++){
            char c=dartResult.charAt(i);
            if(c>='0'&&c<='9'){ //문자가 숫자일 때
                num+=c;
            }
            if(c=='S'||c=='D'||c=='T'){
                int n=Integer.parseInt(num);
                if(c=='S'){
                    score[index]=n;
                }
                else if(c=='D'){
                    score[index]=(int)Math.pow(n,2);
                }
                else{
                    score[index]=(int)Math.pow(n,3);
                }
                index++;
                num="";
            }
            if(c=='*'||c=='#'){
                if(c=='*'){
                    if(index-2>=0)
                        score[index-2]*=2;
                    score[index-1]*=2;
                }
                else{
                    score[index-1]*=(-1);
                }
            }
        }
        int answer = score[0]+score[1]+score[2];
        return answer;
    }
}
