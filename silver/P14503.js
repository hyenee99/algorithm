const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

let [n, m] = input[0].split(" ").map(Number);
let [r, c, d] = input[1].split(" ").map(Number); // 로봇 청소기 좌표, 방향
let room = Array.from({ length: n }, () => Array(m).fill(0));
let visited = Array.from({ length: n }, () => Array(m).fill(false));

let start = 2;
for (let i = 0; i < n; i++) {
  let state = input[start].split(" ").map(Number);
  for (let j = 0; j < m; j++) {
    room[i][j] = state[j];
  }
  start++;
}

// 북 동 남 서
let dx = [-1, 0, 1, 0];
let dy = [0, 1, 0, -1];
let count =0;

while(true){
  if(room[r][c]==0 && !visited[r][c]){
    count++;
    visited[r][c] = true;
  }
  let found = false;

  for(let i=0;i<dx.length;i++){
    d = (d + 3) % 4;
    let nx = r+dx[d];
    let ny= c+dy[d];

    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
      if (room[nx][ny] === 0 && !visited[nx][ny]) { 
        r=nx;
        c=ny;
        found=true;
        break;
      }
    }
  }

  if(!found){
    let back = (d+2)%4;
    let bx = r+dx[back];
    let by= c+dy[back];

    if (bx < 0 || bx >= n || by < 0 || by >= m || room[bx][by] === 1) {
      break; 
    }
    r = bx;
    c = by; 
  }
}

console.log(count);
