import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String,Integer> map= new HashMap<>();
        for(int i=0;i<id_list.length;i++){
            map.put(id_list[i],i); // map에 이름과 번호를 저장
        }
        
        int arr[][]=new int[id_list.length][id_list.length]; 
        int accumulated[]=new int[id_list.length]; //신고 누적 횟수 저장
        
        for(int i=0;i<report.length;i++){
            String r[]=report[i].split(" ");
            int reporter=map.get(r[0]); //신고자 번호
            int reported=map.get(r[1]); //신고 당한 사람 번호 
            
            if(arr[reporter][reported]==0){ //(신고자, 신고당한사람) 이 동일한 경우가 없으면
                arr[reporter][reported]++;
                accumulated[reported]++;
            }
        }
        
        for(int i=0;i<accumulated.length;i++){
            if(accumulated[i]<k)
                continue;
            else { //누적된 값이 k 이상일 때 
                for(int j=0;j<arr.length;j++){
                    if(arr[j][i]!=0)
                        answer[j]++;
                }
            }
        }
        
        return answer;
    }
}
