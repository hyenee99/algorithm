const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");
let [n,m] = input[0].split(" ").map(Number);
let visited = new Array(n+1).fill(false);

function dfs(depth, arr){
  if(depth == m){
    console.log(arr.join(" "));
    return;
  }

  for(let i=1;i<=n;i++){
    if(!visited[i]){
      visited[i] = true;
      arr.push(i);
      dfs(depth+1, arr);
      arr.pop();
      visited[i] = false;
    }
  }
}

dfs(0,[]);
