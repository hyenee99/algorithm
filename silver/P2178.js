const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

// 미로 탐색
let n = Number(input[0].split(" ")[0]);
let m = Number(input[0].split(" ")[1]);
let arr = new Array(n);
let visited = new Array(n);

let dx = [0, -1, 0, 1];
let dy = [1, 0, -1, 0];

for (let i = 0; i < arr.length; i++) {
  arr[i] = new Array(m);
  visited[i] = new Array(m).fill(false);
}

// 2차원 배열에 값 저장
let start = 0;
for (let i = 1; i < input.length; i++) {
  let str = input[i].trim();
  for (let j = 0; j < str.length; j++) {
    arr[start][j] = Number(str[j]);
  }
  start++;
}
let queue = [];
// 큐 초기화 & 시작점 설정
queue.push([0, 0, 1]);
visited[0][0] = true;
let answer = bfs();
console.log(answer);

function bfs() {
  while (queue.length) {
    const [x, y, count] = queue.shift();
    // 목표 지점 도달 시
    if (x === n-1 && y === m-1) return count;

    // 4방향 탐색
    for (let i = 0; i < 4; i++) {
      const nx = x + dx[i];
      const ny = y + dy[i];
  
      // 범위 및 방문 여부 확인
      if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
        if (arr[nx][ny] === 1 && !visited[nx][ny]) {
          visited[nx][ny] = true;
          queue.push([nx, ny, count + 1]);
        }
      }
    }
  }
}

