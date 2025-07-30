const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");
const [n, m] = input[0].split(" ").map(Number);
const map = new Array(n).fill().map(() => new Array(m));
let answer = new Array(n).fill().map(() => new Array(m).fill(-1));

for (let i = 1; i < input.length; i++) {
  let ground = input[i].split(" ").map(Number);

  for (let j = 0; j < ground.length; j++) {
    map[i - 1][j] = ground[j];
  }
}

let startX = 0;
let startY = 0;

for (let i = 0; i < map.length; i++) {
  for (let j = 0; j < map[i].length; j++) {
    if (map[i][j] === 2) {
      startX = i;
      startY = j;
    } else if (map[i][j] === 0) {
      answer[i][j] = 0;
    }
  }
}

const dx = [-1, 0, 1, 0];
const dy = [0, 1, 0, -1];

const queue = [];
const visited = new Array(n).fill().map(() => new Array(m).fill(false));
queue.push([startX, startY, 0]);
visited[startX][startY] = true;
answer[startX][startY] = 0;

while (queue.length) {
  const [x, y, count] = queue.shift();

  for (let i = 0; i < dx.length; i++) {
    const nx = x + dx[i];
    const ny = y + dy[i];

    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
      if (map[nx][ny] !== 0 && !visited[nx][ny]) {
        visited[nx][ny] = true;
        answer[nx][ny] = count + 1;
        queue.push([nx, ny, count + 1]);
      }
    }
  }
}

for (let i = 0; i < n; i++) {
  console.log(answer[i].join(" "));
}
