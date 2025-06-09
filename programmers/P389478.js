function solution(n, w, num) {
    var answer = 0;
    let h = Math.ceil(n/w);
    let arr = new Array(h).fill().map(() => new Array(w).fill(0));
    let box_num = 1;
    
    // 배열에 값 넣기
    for(let i = h-1; i >= 0; i--){
        if((h-1-i) % 2 === 0){
            for(let j = 0; j < w; j++){
                arr[i][j] = box_num++;
                
                if(box_num > n)
                    break;
            }
        } else {
            for(let j = w-1; j >= 0; j--){
                arr[i][j] = box_num++;
                
                if(box_num > n)
                    break;
            }
        }
    }
    
    // num 의 위치 찾기
    let column = 0;
    for(let i=0;i<arr.length;i++){
        for(let j=0;j<arr[i].length;j++){
            if(arr[i][j]==num){
                column =j;
                break;
            }
        }
    }
    
    for(let i=0;i<arr.length;i++){
        if(arr[i][column]!==0)
            answer++;
        if(arr[i][column]==num)
            break;
    }
    
    return answer;
}
