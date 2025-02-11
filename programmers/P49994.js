function changeLocation(x,y,dir){
    switch(dir){
        case 'U':
            return [x,y+1];
        case 'D':
            return [x,y-1];
        case 'R':
            return [x+1,y];
        case 'L':
            return [x-1,y];
    }
}

function solution(dirs) {
    var answer = 0;
    let visited = new Set();
    
    let x=0;
    let y=0;
    
    for(let i=0;i<dirs.length;i++){
        const [nx,ny] = changeLocation(x,y,dirs[i]);
        if(nx<-5 || nx>5 || ny<-5|| ny>5)
            continue;
        
        visited.add(`${x}${y}${nx}${ny}`);
        visited.add(`${nx}${ny}${x}${y}`);
        
        x=nx;
        y=ny;
    }
    
    answer = visited.size/2;
    return answer;
}
