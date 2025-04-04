const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

let n=Number(input[0]); //전체 사람의 수
let [num1, num2] = input[1].trim().split(' ').map(Number); // 두 사람의 번호
let m = Number(input[2].trim()); // 부모 자식들 간의 관계의 대수
let graph = new Array(n + 1).fill().map(() => []);
let visited = new Array(n+1).fill(false);

for(let i=3;i<3+m;i++){
  let [x,y] = input[i].split(" ").map(Number);
  graph[x].push(y);
  graph[y].push(x);
}

let parent_node = Math.min(num1,num2);
let child_node = Math.max(num1,num2);

function dfs(node,depth){
  visited[node] = true;
  if(node === child_node)
    return depth;

  for(let i=0;i<graph[node].length;i++){
    let next = graph[node][i];
    if(!visited[next]){
      let result = dfs(next,depth+1);
      if(result !== -1)
        return result;
    }
  }
  return -1;
}

console.log(dfs(parent_node,0));
