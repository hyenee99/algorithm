function solution(s, skip, index) {
    let alphabet='abcdefghijklmnopqrstuvwxyz';
    let answer = '';
    for(let i=0;i<skip.length;i++){
        alphabet=alphabet.replace(skip[i],'');
    }
    for(let i=0;i<s.length;i++){
        let change=alphabet.indexOf(s[i])+index;
        answer+=alphabet[change%alphabet.length];
    }
    
    return answer;
}
