const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

let arr = input[1].split(" ").map(Number);
let set = new Set(arr);
let sorted_arr = [...set];
sorted_arr.sort((a,b)=>a-b); // 중복 제거 및 정렬된 배열

let map = new Map();
for(let i=0;i<sorted_arr.length;i++){
  map.set(sorted_arr[i],i);
}

const answer = arr.map(num => map.get(num));
console.log(answer.join(" "));
