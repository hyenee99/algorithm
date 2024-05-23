class Solution {
        public int[] solution(String[] park, String[] routes) {
            char arr[][]=new char[park.length][park[0].length()];
            int start=0,end=0;
            //2차원 배열에 값 넣기 
            for(int i=0;i<arr.length;i++){
                String s=park[i];

                for(int j=0;j<arr[i].length;j++){
                    arr[i][j]=s.charAt(j);

                    if(arr[i][j]=='S'){ //시작 위치 저장
                        start=i;
                        end=j;
                    }
                }
            }

            for(int i=0;i<routes.length;i++){
                String where[]=routes[i].split(" ");
                int n=Integer.parseInt(where[1]);

                int temp_s=start;
                int temp_e=end;
                
                if(where[0].equals("N")){
                        temp_s=temp_s-n;
                }
                if(where[0].equals("S")){
                        temp_s=temp_s+n;
                }
                if(where[0].equals("W")){
                        temp_e=temp_e-n;
                }
                if(where[0].equals("E")){
                        temp_e=temp_e+n;
                } 
                
                boolean stopped=false;
                if(temp_s>arr.length-1||temp_s<0||temp_e>arr[0].length-1||temp_e<0) //범위를 넘어가면
                        continue;
                else { // 범위를 넘어가지 않았을 때, 중간에 장애물(X) 가 있는지 확인
                    for(int k=Math.min(start,temp_s);k<=Math.max(start,temp_s);k++){
                        for(int j=Math.min(end,temp_e);j<=Math.max(end,temp_e);j++){
                            if(arr[k][j]=='X'){
                                stopped=true;
                                break;
                            }

                        }
                    }
                }
                
                if(!stopped){ //장애물이 없었다면 위치 변경
                    start=temp_s;
                    end=temp_e;
                }
            }

          int[] answer = {start,end};
          return answer;
        }
 }
