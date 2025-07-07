const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");
const [n, k] = input[0].split(" ").map(Number);
let items = [];

for (let i = 1; i < input.length; i++) {
  const [weight, value] = input[i].split(" ").map(Number);
  items.push({ w: weight, v: value });
}

let dp = Array(k + 1).fill(0);

for (let i = 0; i < n; i++) {
  for (let j = k; j >= items[i].w; j--) {
    dp[j] = Math.max(dp[j], dp[j - items[i].w] + items[i].v);
  }
}
console.log(dp[k]);
