import java.util.*;
class Solution {
    static boolean check(String today,int year,int month,int day){
        String td[]=today.split("\\.");
        int td_year=Integer.parseInt(td[0]);
        int td_month=Integer.parseInt(td[1]);
        int td_day=Integer.parseInt(td[2]);
        
        if(td_year>year)
            return false;
        else if(td_year==year){
            if(td_month<month)
                return true;
            else if(td_month==month){
                if(td_day<=day)
                    return true;
                else
                    return false;
            }
            else
                return false;
        }
        else
            return true;
    }
    public ArrayList solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<>();
        
        for(int i=0;i<terms.length;i++){
            String term[]=terms[i].split(" ");
            map.put(term[0],Integer.parseInt(term[1])); // map에 약관 별 유효기간 저장
        }
        
        for(int i=0;i<privacies.length;i++){
            String privacy[]=privacies[i].split(" ");
            String date[]=privacy[0].split("\\.");
            
            int year=Integer.parseInt(date[0]); //년
            int month=Integer.parseInt(date[1]); //월
            int day=Integer.parseInt(date[2]); //일
            int expiration=map.get(privacy[1]); //약관 종류에 따른 유효기간 가져오기
            
            month+=expiration;
			
	    if (month > 12) {
		 year += (month/12);
		 month%=12;
                
                if(month==0){ 
                    year--;
                    month=12;
                }
	    } 
            
            if(day==1){
              day=28;
              month--;
            }
            else {
              day--;
            }
            
            boolean ok=check(today,year,month,day); // 유효기간이 지났는지 안지났는지 확인
            if(!ok)
                answer.add(i+1);
        }
        
        
        return answer;
    }
}
