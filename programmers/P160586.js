function solution(keymap, targets) {
    var answer = [];
    for(let i=0;i<targets.length;i++){
        let sum=0;
        let stopped=false;
        
        for(let j=0;j<targets[i].length;j++){ //target 의 문자 하나 하나 
            let c=targets[i][j]; // 현재 검사할 문자 
            
            let temp=Number.MAX_VALUE;
            for(let k=0;k<keymap.length;k++){
                let index=keymap[k].indexOf(c); //검사할 문자의 위치 찾기 
                
                if(index!=-1&& index<=temp)
                    temp=index;
            }
            if(temp==Number.MAX_VALUE){
                answer.push(-1);
                stopped=true;
                break;
            }
            else
                sum+=(temp+1);
        }
        if(!stopped)
            answer.push(sum);
    }
    return answer;
}
