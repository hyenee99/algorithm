const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");
const [n, s] = input[0].split(" ").map(Number);
const numbers = input[1].split(" ").map(Number);

let minLength = n + 1;
let sum = 0;
let left = 0;

for (let right = 0; right < n; right++) {
  sum += numbers[right];

  while (sum >= s) {
    minLength = Math.min(minLength, right - left + 1);
    sum -= numbers[left];
    left++;
  }
}

console.log(minLength === n + 1 ? 0 : minLength);
