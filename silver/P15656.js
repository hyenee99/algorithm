const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");
let [n, m] = input[0].split(" ").map(Number);
let numbers = input[1].split(" ").map(Number);
numbers.sort((a, b) => a - b);
let result=[];

function dfs(depth,arr){
  if(depth==m){
    result.push(arr.join(" "));
    return;
  }

  for(let i=0;i<numbers.length;i++){
    arr.push(numbers[i]);
    dfs(depth+1,arr);
    arr.pop();
  }
}

dfs(0,[]);
console.log(result.join("\n"));
