const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");
const n = Number(input[0]);
const graph = new Array(n).fill().map(() => []);
const answer = new Array(n).fill().map(() => new Array(n).fill(0));

for (let i = 1; i < input.length; i++) {
  let numbers = input[i].split(" ").map(Number);
  for (let j = 0; j < numbers.length; j++) {
    if (numbers[j] === 1) {
      graph[i - 1].push(j);
    }
  }
}

for (let i = 0; i < n; i++) {
  let visited = new Array(n).fill(false);
  let queue = [i];

  while (queue.length) {
    let node = queue.shift();

    for (let next of graph[node]) {
      if (!visited[next]) {
        visited[next] = true;
        queue.push(next);
      }
    }
  }

  // visited가 true면 i→j 경로가 있다는 뜻
  for (let j = 0; j < n; j++) {
    if (visited[j]) answer[i][j] = 1;
  }
}

for (let i = 0; i < n; i++) {
  console.log(answer[i].join(" "));
}
