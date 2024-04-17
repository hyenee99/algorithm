package programmers;
import java.util.*;

public class P12909 {
	//올바른 괄호
	 boolean solution(String s) {
        boolean answer = true;
        Stack <Character> stack=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            stack.push(s.charAt(i)); //스택에 값을 넣음
        }
        
        boolean isCompleted=false;
        if(stack.peek()=='('){
            answer=false;
        }
        else {
            int close_count=0;
            int open_count=0;
            
            while(!stack.isEmpty()){
                char c=stack.pop();
                
                if(c==')'){
                    ++close_count;
                    isCompleted=false;
                }
                if(c=='(') {
                    ++open_count;
                    if(close_count==0){
                        answer=false;
                        break;
                    }
                    
                    if(close_count==open_count){
                        close_count=0;
                        open_count=0;
                        isCompleted=true;
                    }
                }
            }
        }
        
        if(!isCompleted)
            answer=false;
        
        return answer;
    }
}
