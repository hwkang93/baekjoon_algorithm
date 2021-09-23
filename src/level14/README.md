## 15649. N과 M(1)

[참고블로그](https://st-lab.tistory.com/114)

### 백트래킹

- 직역하면 **되추적**
- 어떤 노드의 '유망성' 을 판단한 뒤, 해당 노드가 유망하지 않다면 부모 노드로 돌아가 다른 자식 노드를 찾는 방법
- 모든 경우의 수를 찾아보긴 하지만, 가능성이 있는 경우의 수만 찾아보는 방법
- 예를 들어 a + b + c + d = 20일 경우, a b c d 각각의 수는 20을 절대 넘지 않기 때문에 20 안에서(가능성이 있는 범위) 모든 경우의 수를 살핌

### DFS

- 직역하면 깊이우선탐색
- 트리순회의 한 형태로 하나의 순회 알고리즘 이라고 함
- 백트래킹에 사용하는 대표적인 알고리즘(BFS 등으로도 백트래킹 구현 가능)

#### 이번 문제는 백트래킹 구현을 DFS 방법을 통해 구현해야 함.


