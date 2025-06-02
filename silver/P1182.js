const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");
const [N, S] = input[0].split(" ").map(Number);
let numbers = input[1].split(" ").map(Number);
let count = 0;

function dfs(idx, sum, arrLen) { // 인덱스, 합, 선택한 원소 개수
  if (idx === N) {
    if (sum === S && arrLen > 0) count++;
    return;
  }

  // 현재 원소를 선택하는 경우
  dfs(idx + 1, sum + numbers[idx], arrLen + 1);
  // 현재 원소를 선택하지 않는 경우
  dfs(idx + 1, sum, arrLen);
}

dfs(0, 0, 0);
console.log(count);
