const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");
let currentLine = 1;

const test_case = Number(input[0]);

for (let test = 0; test < test_case; test++) {
  const n = Number(input[currentLine]);
  currentLine++;
  const positions = [];

  for (let i = 0; i < n + 2; i++) {
    const [x, y] = input[currentLine + i].split(" ").map(Number);
    positions.push([x, y]);
  }
  console.log(bfs(positions)); // 결과 출력
  currentLine += n + 2;
}

function bfs(positions) {
  const n = positions.length;
  const visited = new Array(n).fill(false);
  const queue = [];
  queue.push(0); // 시작점 인덱스, 좌표가 아닌 인덱스 저장하기
  visited[0] = true;

  while (queue.length > 0) {
    const current = queue.shift();

    // 페스티벌 도착 확인
    if (current === n - 1) {
      return "happy";
    }

    const [x1, y1] = positions[current];
    // 모든 노드 탐색
    for (let i = 0; i < n; i++) {
      if (!visited[i]) {
        const [x2, y2] = positions[i];
        const distance = Math.abs(x1 - x2) + Math.abs(y1 - y2);
        if (distance <= 1000) {
          visited[i] = true;
          queue.push(i);
        }
      }
    }
  }
  return "sad";
}
