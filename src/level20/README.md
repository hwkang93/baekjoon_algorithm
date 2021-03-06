[참고블로그](https://st-lab.tistory.com/227)

### 분할 정복

분할 정복은 기본적으로 **재귀에 대한 이해와 탐색(search)에 대한 이해** 가 전제되어야 한다.

분할 정복 과정 3단계
1. 현재 상태의 문제를 풀 수 없는 경우, 문제를 분할할 수 있는지를 확인한다.
2. 문제를 분할하여 각각 풀이한다. (풀이할 수 없는 경우 1번 과정으로 간다.)
3. 풀린 문제들을 합친다.

> 문제를 풀다 보니 난이도가 있는 분할 정복의 경우에는 대부분 행렬로 푸는 문제였음.



### 모듈러 연산

> 모듈러 연산에 대해 이해가 부족한 것 같아 다시 한번 정리하려고 한다.

- 모듈러 연산은 나머지 연산과 같은 말이다.
- 모듈러 연산을 표현할 때는 a mod m = r 과 같이 'mod' 라는 표현을 사용하는데,
  이는 ** a % m = r ** 과 같은 의미이다.
- **m으로 나눈 나머지 r에 대하여 a는 유일하지 않다.**
  - 예를 들어, 2로나눴을 때 나머지가 1이 되는 a라는 정수는 한개 이상이다.(3,5,7...)
- 이러한 특징을 거꾸로 뒤집어보면 ** a = km + r ** 라는 식이 도출이 가능하다.

> 마저 정리하기
> https://st-lab.tistory.com/19#%EB%AA%A8%EB%93%88%EB%9F%AC
> https://st-lab.tistory.com/241


### 행렬 곱하기

i x j 행렬과 j x k 행렬을 곱하면 결과 행렬의 크기는 i x k가 된다. 

(첫 번째 행렬의 열과 두 번째 행렬의 행의 크기가 같아야 함)

예를 들어 2 x 3 행렬과 3 x 2 행렬을 곱하는 경우 

<br/>

<img src="https://latex.codecogs.com/svg.image?\begin{bmatrix}a&space;&&space;b&space;&&space;c&space;\\d&space;&&space;e&space;&&space;f&space;\\\end{bmatrix}*\begin{bmatrix}g&space;&&space;h&space;\\i&space;&&space;j&space;\\k&space;&&space;l&space;\\\end{bmatrix}&space;=\begin{bmatrix}ag&plus;bi&plus;ck&space;&&space;ah&plus;bj&plus;cl&space;\\dg&plus;di&plus;dk&space;&&space;dh&plus;ej&plus;fl&space;\\\end{bmatrix}&space;" title="\begin{bmatrix}a & b & c \\d & e & f \\\end{bmatrix}*\begin{bmatrix}g & h \\i & j \\k & l \\\end{bmatrix} =\begin{bmatrix}ag+bi+ck & ah+bj+cl \\dg+di+dk & dh+ej+fl \\\end{bmatrix} " />

와 같은 방법으로 곱셈이 이루어진다.

위 행렬을 코드로 구현하면

```java
public class Main {
    
    //행렬 곱셈 메소드 
    public int[][] multiply(int[][] matrix1, int[][] matrix2) {
        int n = matrix1.length;     //matrix1의 행
        int m = matrix2[0].length;  //matrix2의 열
        int[][] resultMatrix = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = 0; k < matrix1[0].length; k++) {
                    resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        
        return resultMatrix;
    }
}
```


### 1629. 곱셈
[문제 바로가기](https://www.acmicpc.net/problem/1629)

#### 접근 방법을 모르겠음

