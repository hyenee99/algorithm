class Solution {
    public int[] solution(String[] wallpaper) {
        char arr[][]=new char[wallpaper.length][wallpaper[0].length()];
        for(int i=0;i<arr.length;i++){
            String s=wallpaper[i];
            for(int j=0;j<arr[i].length;j++){
                arr[i][j]=s.charAt(j); //2차원 배열에 값 넣기 
            }
        }
         
        int start_min=Integer.MAX_VALUE;
        int start_max=0;
        int end_min=Integer.MAX_VALUE;
        int end_max=0;
        
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
               if(arr[i][j]=='#'){
                   start_min=Math.min(start_min,i);
                   start_max=Math.max(start_max,i);
                   end_min=Math.min(end_min,j);
                   end_max=Math.max(end_max,j);
               }
            }
        }
        int[] answer = {start_min,end_min,start_max+1,end_max+1};
        return answer;
    }
}
