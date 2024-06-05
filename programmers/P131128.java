import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        int x[]=new int[10];
        int y[]=new int[10];
        
        for(int i=0;i<X.length();i++){
            int temp=X.charAt(i)-'0';
            x[temp]++;
        }
        
        for(int i=0;i<Y.length();i++){
            int temp=Y.charAt(i)-'0';
            y[temp]++;
        }
        
        ArrayList<Integer> list=new ArrayList<>();
        int num=Integer.MAX_VALUE;
        StringBuilder sb=new StringBuilder();
        String answer = "";
        
        for(int i=0;i<x.length;i++){
            if(x[i]!=0&&y[i]!=0){
               num=Math.min(x[i],y[i]);
               for(int j=0;j<num;j++){
                    list.add(i);
               }  
            }
            else
                continue;
        }
        
        for(int i=list.size()-1;i>=0;i--){
            sb.append(list.get(i));
        }
        
        answer=sb.toString();
        if(answer.equals("")) 
            answer = "-1";
        else if(answer.replace("0","") == "") 
            answer = "0";
        
        return answer;
    }
}
