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


### 2580. 스도쿠
[문제 바로가기](https://www.acmicpc.net/problem/2580)

내가 푼 방법
```java
package level14;

import java.util.Scanner;

public class Level14_6 {
    public static int[][] arr = getTestData();

    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
*/
        sdoku(0, 0);
    }

    public static void sdoku(int row, int col) {
        //row == 9 -> 모든 경우 순회 완료 ( 마지막으로 조회헤애 할 row, col -> (8, 8) )
        if(row == 9) {
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0; i<9; i++) {
                for(int j=0; j<9; j++) {
                    stringBuilder.append(arr[i][j]).append(' ');
                }
                stringBuilder.append('\n');
            }

            System.out.println(stringBuilder);
            System.exit(0);
        }

        //arr[row][col] == 0 -> 값을 1~9까지 중 하나를 채워넣어야 함.
        if(arr[row][col] == 0) {
            for(int i=1; i<=9; i++) {
                if(check(i, row, col)) {
                    arr[row][col] = i;
                    break;
                }
            }
        }

        //마지막 칸까지 확인 후 다음 줄 첫번째 칸으로 이동
        if(col == 8) {
            sdoku(row+1, 0);
        } else {
            sdoku(row, col+1);
        }
    }

    public static boolean check(int value, int row, int col) {
        //가로에 value 값이 있는 경우 false
        for(int i=0; i<9; i++) {
            if(value == arr[row][i]) {
                return false;
            }
        }

        //세로에 value 값이 있는 경우 false
        for(int i=0; i<9; i++) {
            if(value == arr[i][col]) {
                return false;
            }
        }

        //value가 포함된 위치의 3x3 에 value 값이 있는 경우 false
        /*
            0,1,2 -> 0
            3,4,5 -> 3
            6,7,8 -> 6
         */

        int rowStart = (row / 3) * 3;
        int colStart = (col / 3) * 3;

        for(int i = rowStart; i < rowStart + 3; i++) {
            for(int j = colStart; j < colStart + 3; j++) {
                if(value == arr[i][j]) {
                    return false;
                }
            }
        }

        //그 외의 경우 true
        return true;
    }

    private static int[][] getTestData() {
        String[] row = new String[9];
        row[0] = "0 0 0 0 0 0 0 0 0";
        row[1] = "0 0 0 0 0 0 0 0 0";
        row[2] = "0 0 0 0 0 0 0 0 0";
        row[3] = "0 0 0 0 0 0 0 0 0";
        row[4] = "0 0 0 0 0 0 0 0 0";
        row[5] = "0 0 0 0 0 0 0 0 0";
        row[6] = "0 0 0 0 0 0 0 0 0";
        row[7] = "0 0 0 0 0 0 0 0 0";
        row[8] = "0 0 0 0 0 0 0 0 0";

        int[][] data = new int[9][9];

        for(int i=0; i<row.length; i++) {
            String[] col = row[i].split(" ");
            for(int j=0; j<col.length; j++) {
                data[i][j] = Integer.parseInt(col[j]);
            }
        }

        return data;
    }

}
```

- 이 방법으로 모든 값이 0인 경우 데이터가 정상적으로 출력 안됐음
- https://st-lab.tistory.com/119 블로그 참고해서 수정해서 풀었음
- n(n>1) 번째 줄에서 빈 칸에 들어가야할 값이 없을 경우 n-1번째 줄을 다른 값으로 다시 조회해야 하는데,
  그게 제대로 안됐던 모양임
- **arr[row][col] = 0;** 초기화를 잘 해야함.
- 아직 많이 부족하구나..

- 처음에는 참고 블로그에서 출력한 값과 내가 출력한 값이 마지막 줄 공백 개수 차이때문인 줄 알았는데 아니었음.
  (나는 2줄 , 예제는 1줄)
