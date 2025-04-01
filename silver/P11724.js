const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

// 연결 요소의 개수
let [n,m] = input[0].split(" ").map(Number); // 정점의 개수: n, 간선의 개수: m
let graph = new Array(n + 1).fill(null).map(() => []);

for (let i = 1; i <=m; i++) {
  let [from, to] = input[i].split(" ").map(Number);
  graph[from].push(to);
  graph[to].push(from);
}
let visited = new Array(n + 1).fill(0);

function dfs(node) {
  if(visited[node]) return;
  visited[node] = 1;

  for(let i=0;i<graph[node].length;i++){
    let next=graph[node][i];
    if(visited[next]===0)
      dfs(next);
  }
}

let answer= 0;
for(let i=1;i<visited.length;i++){
  if(visited[i]===0){
    dfs(i);
    answer++;
  }
}
console.log(answer);
