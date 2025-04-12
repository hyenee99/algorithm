const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

//스타트링크
const [f,s,g,u,d] = input[0].trim().split(" ").map(Number);
const visited = new Array(f+1).fill(false);
let queue =[[s,0]];
visited[s] = true;

while(queue.length!==0){
  const [position, times] = queue.shift();

  if(position === g){
    console.log(times);
    return;
  }

  const nextPostions = [position+u , position-d];
  for(let i=0;i<nextPostions.length;i++){
    let next = nextPostions[i];
    if(next>0 && next<=f && !visited[next]){
      visited[next] = true;
      queue.push([next,times+1]);
    }
  }
}

console.log("use the stairs");
