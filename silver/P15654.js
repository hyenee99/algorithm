const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");
let [n, m] = input[0].split(" ").map(Number);
let numbers = input[1].split(" ").map(Number);
numbers.sort((a, b) => a - b);
let result = [];
let visited = new Array(n).fill(false);

function dfs(depth, arr) {
  if (depth == m) {
    result.push(arr.join(" "));
    return;
  }

  for (let i = 0; i < numbers.length; i++) {
    if (!visited[i]) {
      visited[i] = true;
      arr.push(numbers[i]);
      dfs(depth + 1, arr);
      arr.pop();
      visited[i] = false;
    }
  }
}

dfs(0, []);
console.log(result.join("\n"));
