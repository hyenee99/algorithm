function solution(input_string) {
    let alphabet = new Array(26);
    let answer='';
    let answer_array=new Array();
    
    alphabet.fill(0);
    
    for(let i=0;i<input_string.length;i++){
        let code=input_string[i].charCodeAt();
        alphabet[code-97]++;
    }
    
    let repeated=new Array(); 
    for(let i=0;i<alphabet.length;i++){
        if(alphabet[i]>=2)
            repeated.push(String.fromCodePoint(i+97));
    }
    
    if(repeated.length == 0)
        return "N";
    else {
        for(let i=0;i<repeated.length;i++){
            let code=repeated[i].charCodeAt();
            let times= alphabet[code-97];  
            let index= input_string.indexOf(repeated[i]); 
            let end=index+times;
            
            for(let j=index;j<end;j++){
                let c = input_string.charAt(j);
                
                if(c!==repeated[i]){
                    answer_array.push(repeated[i]);
                    break;
                }
            }
        }
        
        if(answer_array.length==0)
            return "N";
        else
            answer_array.sort();
    }
    
    for(let i=0;i<answer_array.length;i++){
        answer+=answer_array[i];
    }
    
    return answer;
}
