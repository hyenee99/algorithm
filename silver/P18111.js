const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

let [n, m, b] = input[0].split(" ").map(Number);
let ground = [];
for (let i = 1; i <= n; i++) {
  ground.push(input[i].split(" ").map(Number));
}

let minTime = Number.MAX_SAFE_INTEGER;
let answerHeight = 0;

for (let h = 0; h <= 256; h++) {
  let time = 0;
  let block = b;

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      let diff = ground[i][j] - h;
      if (diff > 0) { 
        time += diff * 2;
        block += diff;
      } else if (diff < 0) { 
        time += -diff;
        block += diff; 
      }
    }
  }

  if (block >= 0) {
    if (time < minTime || (time === minTime && h > answerHeight)) {
      minTime = time;
      answerHeight = h;
    }
  }
}

console.log(minTime, answerHeight);
