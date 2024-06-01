import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer>stack=new Stack<>();
        int answer = 0;
        
        for(int i=0;i<moves.length;i++){
            int num=moves[i]; // 작동시킨 위치 
            
            for(int j=0;j<board.length;j++){
                if(board[j][num-1]==0) // 값이 0이면 다음 행으로 넘어감
                    continue;
                else{ // 값이 0이 아니다 => 인형이 있다. 
                    if(stack.isEmpty()){ // 스택이 비어있으면
                        stack.push(board[j][num-1]);
                    }
                    else { //스택이 비어있지 않으면 
                        if(stack.peek()==board[j][num-1]){ // 스택 맨 위의 값 == 현재 값   
                            stack.pop(); // 스택에서 빼기
                            answer+=2; // 사라진 인형 개수 2개 증가 
                        }
                        else //스택 맨 위의 값 != 현재 값  
                            stack.push(board[j][num-1]); //스택에 넣어주기 
                    }
                    board[j][num-1]=0; // 인형을 뺐으면 0으로 값 변경
                    break; // 인형을 빼고 나면 다음 행으로 넘어가지 않기 위해 break 해주기 
                }      
            }
        }

        return answer;
    }
}
