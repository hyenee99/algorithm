const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

// 토마토
const [m, n, h] = input[0].split(" ").map(Number); // 상자 가로칸의 수, 세로칸의 수, 상자의 수

// 3차원 배열 초기화
let box = new Array(h);
for (let i = 0; i < box.length; i++) {
  box[i] = new Array(n);
  for (let j = 0; j < box[i].length; j++) {
    box[i][j] = new Array(m).fill(0);
  }
}

// 입력값을 box 배열에 저장
let line = 1;
for (let floor = 0; floor < h; floor++) {
  for (let i = 0; i < n; i++) {
    let tomatoes = input[line].trim().split(" ").map(Number);
    for (let j = 0; j < m; j++) {
      box[floor][i][j] = tomatoes[j];
    }
    line++;
  }
}

let queue = [];
// 초기 익은 토마토 탐색
for (let floor = 0; floor < h; floor++) {
  for (let i = 0; i < n; i++) {  // n: 행 개수
    for (let j = 0; j < m; j++) {  // m: 열 개수
      if (box[floor][i][j] === 1) {
        queue.push([floor, i, j]); 
      }
    }
  }
}

bfs();

function bfs() {
  const dz = [-1, 1, 0, 0, 0, 0]; // 위아래층
  const dx = [0, 0, -1, 1, 0, 0]; // 좌우
  const dy = [0, 0, 0, 0, -1, 1]; // 앞뒤
  let days = -1;
  let head = 0; // 큐 헤드 포인터

  while (head < queue.length) {
    days++;
    const levelSize = queue.length - head; // 현재 레벨의 토마토 수

    for (let k = 0; k < levelSize; k++) {
      const [z, x, y] = queue[head++];

      for (let i = 0; i < 6; i++) {
        const nz = z + dz[i];
        const nx = x + dx[i];
        const ny = y + dy[i];

        if (
          nz >= 0 && nz < h &&
          nx >= 0 && nx < n &&
          ny >= 0 && ny < m &&
          box[nz][nx][ny] === 0
        ) {
          box[nz][nx][ny] = 1;
          queue.push([nz, nx, ny]);
        }
      }
    }
  }

  // 안 익은 토마토 체크
  for (let floor of box) {
    for (let row of floor) {
      if (row.includes(0)) {
        days = -1;
        break;
      }
    }
  }

  console.log(days);
}
