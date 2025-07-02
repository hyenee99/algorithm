const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");
let arr = input[0].split("-");
let result = arr[0].includes("+") ? plus(arr[0]):Number(arr[0]);
function plus(str) {
  let numbers = str.split("+").map(Number);
  let sum=0;
  for (let num of numbers) {
    sum += num;
  }
  return sum;
}

let sumOfMinus=0;
for (let i = 1; i < arr.length; i++) {
  if(arr[i].includes("+")){
    sumOfMinus+=plus(arr[i]);
  }
  else {
    sumOfMinus+=Number(arr[i]);
  }
}

result-=sumOfMinus;
console.log(result);

