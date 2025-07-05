const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");
const [k, m] = input[0].split(" ").map(Number);
let lines = [];

for (let i = 1; i <= k; i++) {
  lines[i - 1] = Number(input[i]);
}
lines.sort((a, b) => a - b);
let start = 1;
let end = lines[lines.length-1];
let sum = 0;
let result=0;

while (start<=end) {
  let mid = Math.floor((start+end)/2);
  sum = 0;

  for (let i = 0; i < lines.length; i++) {
    sum += Math.floor(lines[i] / mid);
  }

  if (sum >= m) {
    result=mid;
    start = mid+1;
  }
  else end = mid-1;
}

console.log(result);
