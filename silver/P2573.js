const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

// 빙산
const [row, column] = input[0].trim().split(" ").map(Number);
let array = new Array(row);
for (let i = 0; i < row; i++) {
  array[i] = input[i + 1].trim().split(" ").map(Number);
}

const dx = [0, 1, 0, -1];
const dy = [1, 0, -1, 0];

// 주위의 0 개수 만큼 값을 변경하는 함수
function melt(arr) {
  let new_arr = arr.map((row) => [...row]);

  for (let i = 1; i < arr.length - 1; i++) {
    for (let j = 1; j < arr[i].length - 1; j++) {
      let count = 0;
      for (let dir = 0; dir < dx.length; dir++) {
        let nx = i + dx[dir];
        let ny = j + dy[dir];

        if (arr[nx][ny] === 0) {
          count++;
        }
      }
      let height = arr[i][j] - count;
      if (height < 0 ? (new_arr[i][j] = 0) : (new_arr[i][j] = height));
    }
  }

  return new_arr;
}

// 너비 우선 탐색
function bfs(x, y, visited) {
  const queue = [[x, y]];
  visited[x][y] = true;

  while (queue.length > 0) {
    const [cx, cy] = queue.shift();

    for (let i = 0; i < dx.length; i++) {
      const nx = cx + dx[i];
      const ny = cy + dy[i];

      if (nx >= 0 && nx < row && ny >= 0 && ny < column) {
        if (array[nx][ny] !== 0 && !visited[nx][ny]) {
          visited[nx][ny] = true;
          queue.push([nx, ny]);
        }
      }
    }
  }
}

let year = 0;
while (true) {
  array = melt(array);
  year++;

  // 모든 빙산이 녹았는지 확인
  const allZero = array.every((row) => row.every((v) => v === 0));
  if (allZero) {
    console.log(0);
    return;
  }

  // 연결된 빙산 덩어리 개수 계산
  const visited = new Array(row)
    .fill()
    .map(() => new Array(column).fill(false));
  let count = 0;
  for (let i = 0; i < row; i++) {
    for (let j = 0; j < column; j++) {
      if (array[i][j] > 0 && !visited[i][j]) {
        bfs(i, j, visited);
        count++;
      }
    }
  }

  if (count >= 2) {
    console.log(year);
    return;
  }
}
