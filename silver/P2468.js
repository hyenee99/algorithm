const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

// 안전 영역
let n = Number(input[0].trim());
let array = new Array(n);
for (let i = 0; i < n; i++) {
  array[i] = input[i + 1].trim().split(" ").map(Number);
}

// 물 높이의 최대값 계산
let max = 0;
for (let i = 0; i < n; i++) {
  for (let j = 0; j < n; j++) {
    if (array[i][j] > max) max = array[i][j];
  }
}

// 방향 벡터
const dx = [0, 1, 0, -1];
const dy = [1, 0, -1, 0];

// BFS 함수
function bfs(x, y, height, visited) {
  const queue = [[x, y]];
  visited[x][y] = true;

  while (queue.length > 0) {
    const [cx, cy] = queue.shift();

    for (let i = 0; i < dx.length; i++) {
      const nx = cx + dx[i];
      const ny = cy + dy[i];

      if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
        if (array[nx][ny] > height && !visited[nx][ny]) {
          visited[nx][ny] = true;
          queue.push([nx, ny]);
        }
      }
    }
  }
}

// 물 높이별 안전 영역 계산
let maxSafeZone = 0;
let arr=[];
for (let height = 0; height <= max; height++) {
  // 방문 배열 초기화
  const visited = new Array(n).fill().map(() => new Array(n).fill(false));
  let count = 0;

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      // 현재 높이보다 높은 지역이고 방문하지 않은 경우 BFS 수행
      if (array[i][j] > height && !visited[i][j]) {
        bfs(i, j, height, visited); // 새로운 안전 영역의 시작점에서만 실행
        count++;
      }
    }
  }

  // 최대 안전 영역 갱신
  maxSafeZone = Math.max(maxSafeZone, count);
}
console.log(maxSafeZone);
