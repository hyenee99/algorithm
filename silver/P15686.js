const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");
let [n, m] = input[0].split(" ").map(Number);
let city = new Array(n);

for (let i = 0; i < n; i++) {
  city[i] = new Array(n);
}

for (let i = 1; i < input.length; i++) {
  let nums = input[i].split(" ").map(Number);
  for (let j = 0; j < nums.length; j++) {
    city[i - 1][j] = nums[j];
  }
}

let houses = [];
let chickens = [];
let pickChicken = [];

// 집의 좌표와 치킨집 좌표 각각 저장
for (let i = 0; i < city.length; i++) {
  for (let j = 0; j < city[i].length; j++) {
    if (city[i][j] === 1) {
      houses.push([i, j]);
    } else if (city[i][j] === 2) {
      chickens.push([i, j]);
    }
  }
}

// 치킨집 m 개 선택 조합 생성
function chickenComb(start, comb) {
  if (comb.length === m) {
    pickChicken.push([...comb]);
    return;
  }

  for (let i = start; i < chickens.length; i++) {
    comb.push(i);
    chickenComb(i + 1, comb);
    comb.pop();
  }
}

chickenComb(0, []);

function calculateDistance(x1, y1, x2, y2) {
  return Math.abs(x1 - x2) + Math.abs(y1 - y2);
}

let answer = Number.MAX_SAFE_INTEGER;

for (let comb of pickChicken) {
  let houseToChicken = new Array(houses.length).fill(Number.MAX_SAFE_INTEGER);

  for (let i = 0; i < houses.length; i++) {
    const [hx, hy] = houses[i];

    for (let idx of comb) {
      const [cx, cy] = chickens[idx];
      const dist = calculateDistance(hx, hy, cx, cy);
      if (dist < houseToChicken[i]) houseToChicken[i] = dist;
    }
  }

  const sum = houseToChicken.reduce((acc, cur) => acc + cur, 0);
  if (sum < answer) answer = sum;
}

console.log(answer);
