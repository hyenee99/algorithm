const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

// 단지 번호 붙이기
let n = Number(input[0].trim());
let map = new Array(n);
let visited = new Array(n);
let dx = [0,-1,0,1];
let dy = [1,0,-1,0];

for(let i=0;i<n;i++){
  map[i]= new Array(n);
  visited[i]=new Array(n).fill(false);
}

let start =0;
for(let i=1;i<=n;i++){
  let str = input[i].trim();

  for(let i=0;i<str.length;i++){
    map[start][i] = Number(str[i]);
  }
  start++;
}

let queue=[];
let answer =[];

function bfs() {
  let count = 1;

  while (queue.length) {
    const [x, y] = queue.shift();

    for (let i = 0; i < dx.length; i++) {
      const nx = x + dx[i];
      const ny = y + dy[i];

      if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
        if (map[nx][ny] === 1 && !visited[nx][ny]) {
          visited[nx][ny] = true;
          queue.push([nx, ny]);
          count++;
        }
      }
    }
  }
  return count; 
}

for(let i =0 ; i< map.length;i++){
  for(let j=0;j<map[i].length;j++){
    if(map[i][j]!==0 && !visited[i][j]){
      queue.push([i,j]);
      visited[i][j] = true;
      let houses = bfs();
      answer.push(houses);
    }
  }
}

answer.sort((a,b)=>a-b);
let result = [answer.length,...answer];
console.log(result.join('\n'));
