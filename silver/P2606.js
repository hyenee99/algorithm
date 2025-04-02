const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

let num = Number(input[0]); // 컴퓨터의 수 
let connected = Number(input[1]); // 컴퓨터 쌍의 수 
let visited = new Array(num + 1).fill(0);
let graph = new Array(num + 1).fill().map(() => []);

for(let i=2;i<input.length;i++) {
  let [x, y] = input[i].split(" ").map(Number);
  graph[x].push(y);
  graph[y].push(x);
}
let answer = 0;
dfs(1);

function dfs(node) {
  if(visited[node])
    return;
  visited[node] = 1;

  for(let i =0 ; i< graph[node].length;i++){
    let next = graph[node][i];

    if(visited[next] === 0){
      answer++;
      dfs(next);
    }
  }
}
console.log(answer);
