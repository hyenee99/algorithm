const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");
let [n,m] = input[0].split(" ").map(Number);

function dfs(depth,start,arr){
  if(depth == m){
    console.log(arr.join(" "));
    return;
  }

  for(let i=start;i<=n;i++){
    arr.push(i);
    dfs(depth+1,i+1,arr);
    arr.pop();
  }
}

dfs(0,1,[]);
