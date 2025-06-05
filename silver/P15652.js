const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");
let [n, m] = input[0].split(" ").map(Number);
let result = [];

let start = 1;
function dfs(depth, arr) {
  if (depth == m) {
    result.push(arr.join(" "));
    return;
  }

  if (arr.length >= 1) {
    start = arr[arr.length - 1];
  }

  for (let i = start; i <= n; i++) {
    arr.push(i);
    dfs(depth + 1, arr);
    arr.pop();
  }
}

dfs(0, []);
console.log(result.join("\n"));
