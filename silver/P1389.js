const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");
const [n, m] = input[0].split(" ").map(Number);
let person = new Array(n + 1).fill(null).map(() => []);

for (let i = 1; i <= m; i++) {
  const [a, b] = input[i].split(" ").map(Number);
  person[a].push(b);
  person[b].push(a);
}

function kevinBacon(p, target) {
  let queue = [[p, 0]];
  let visited = new Array(n + 1).fill(false);

  while (queue.length) {
    let [num, step] = queue.shift();

    if (num === target) return step;

    if (visited[num] == true) continue;
    visited[num] = true;

    for (let i = 0; i < person[num].length; i++) {
      let next = person[num][i];
      if (!visited[next]) queue.push([next, step + 1]);
    }
  }
}

let answers = [];
for (let i = 1; i <= n; i++) {
  let sum = 0;
  for (let target = 1; target <= n; target++) {
    if (i === target) continue;
    else {
      let num = Number(kevinBacon(i, target));
      sum += num;
    }
  }
  answers.push([i, sum]);
}
answers.sort((a, b) => a[1] - b[1]);
console.log(answers[0][0]);
