const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

// 카드
let N = Number(input[0]); //카드의 개수
let map = new Map();
let answer=[];

for(let i=1;i<=N;i++){
  let num = BigInt(input[i]);
  if(map.get(num)){
    map.set(num, map.get(num)+1);
  }
  else {
    map.set(num, 1);
  }
}

let max_num = 0;
map.forEach((value, key) => {
  max_num = Math.max(max_num, value);
})

map.forEach((value, key) => {
  if(value === max_num){
    answer.push(key);
  }
})
answer.sort((a, b) => a < b ? -1 : 1);
console.log(answer[0].toString());
