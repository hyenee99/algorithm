class Solution {
    public int solution(String[][] board, int h, int w) {
        String color=board[h][w]; //현재 색깔
        int answer = 0;
        int n=board[0].length;
        
        if(h-1>=0 && board[h-1][w].equals(color)) // 위
            answer++;
        if(h+1<=n-1&&board[h+1][w].equals(color)) // 아래 
            answer++;
        if(w+1<=n-1&&board[h][w+1].equals(color)) // 오른쪽
            answer++;
        if(w-1>=0&&board[h][w-1].equals(color)) // 왼쪽
            answer++;
        
        return answer;
    }
}
