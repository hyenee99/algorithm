const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");
const n = Number(input[0]);
const fruits = input[1].split(" ").map(Number);

const count = new Map();
let left = 0;
let maxLen = 0;

for (let right = 0; right < n; right++) {
  const fruit = fruits[right];
  count.set(fruit, (count.get(fruit) || 0) + 1);

  while (count.size > 2) {
    const popFruit = fruits[left];
    count.set(popFruit, count.get(popFruit) - 1);

    if (count.get(popFruit) === 0) {
      count.delete(popFruit);
    }
    left++;
  }
  maxLen = Math.max(maxLen, right - left + 1);
}

console.log(maxLen);
