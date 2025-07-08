const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

const [n, k] = input[0].split(" ").map(Number);
const visited = new Array(100001).fill(false);
let queue = [[n, 0]];
visited[n] = true;

while (queue.length > 0) {
  const [current, time] = queue.shift();

  if (current === k) {
    console.log(time);
    break;
  }

  const nextPositions = [current * 2, current - 1, current + 1];
  for (let i = 0; i < nextPositions.length; i++) {
    let next = nextPositions[i];
    if (next >= 0 && next <= 100000 && !visited[next]) {
      visited[next] = true;

      if (i == 0) queue.push([next, time]);
      else queue.push([next, time + 1]);
    }
  }
}
