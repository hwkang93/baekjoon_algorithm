[참고블로그](https://st-lab.tistory.com/154)

### 최대공약수
- A와 B 두 수가 주어지면 A의 약수를 모두 구하고, B의 약수를 모두 구한 뒤 공통된 약수들만 찾아내서 약수들의 곱으로 다시 나타내준다.

### 유클리드호제법
- 정의된 최대공약수를 구하는 방법으로는, 너무 많은 시간을 소비하게 된다.
- 그래서 최대공약수(+최소공배수)를 구하기 위해서는 일반적으로 **유클리드 호제법** 알고리즘을 사용한다.

> **호제법**
> 
> 서로 나눈다는 의미
 

두 수  a, b 가 있고 a를 b로 나눈 나머지를 r 이라고 정의한다.
(a >= b , 0 <= r < b)

이 때 두 수 a와 b의 최대공약수를 (a,b)라고 할 때 (a,b)의 최대공약수는 (b,r)의 최대공약수와 같다.

다음을 식으로 표현하면

**GCD(a,b) = GCD(b,r)**

이다.

--------------------

[위키백과 참고](https://ko.wikipedia.org/wiki/%EC%A1%B0%ED%95%A9)

[참고 블로그](https://st-lab.tistory.com/159)

### 조합(Combination)

조합론에서 조합(combination)은 집합에서 서로 다른 n개의 원소 중에서 순서에 상관없이 k 개를 선택하는 것이다.
그 경우의 수는 이항계수이다.

------------------

[위키백과 참고](https://ko.wikipedia.org/wiki/%EC%9D%B4%ED%95%AD_%EA%B3%84%EC%88%98)

[참고블로그](https://rh-tn.tistory.com/32)

### 이항계수

n 개의 원소를 가지는 집합에서 k개의 부분집합을 고르는 조합의 수를 이항계수라고 한다.

![수식](http://latex.codecogs.com/gif.latex?nCk)
,
![수식](http://latex.codecogs.com/gif.latex?^nCk)
,
![수식](http://latex.codecogs.com/gif.latex?Cn,k)

등으로 나타낼 수 있다.

<br/>

**이항계수** 는 **이항식**을 이항정리로 전개했을 때 각 항의 계수를 나타낸다.

![수식](http://latex.codecogs.com/gif.latex?(x+y)^2=x^2+2xy+y^2)

이 때 위의 전개식에서 각 항의 계수인 **1 2 1** 이 이항계수이다.

### 이항계수의 성질

<img style="width: 200px; height: 200px;" src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Pascal%27s_triangle_5.svg/1280px-Pascal%27s_triangle_5.svg.png"/>

>**파스칼의 삼각형**
> 
> 이항 계수의 값을 삼각형 모양으로 나열한 표

1. 파스칼의 삼각형에서 세번째 줄 두번째 칸에 있는 2는 두번째 줄 첫번째 칸의 1과 두번째 줄 두번째 칸의 2를 더한 값이다.
이러한 성질을 수식으로 표현하면 다음과 같다.

<img src="https://latex.codecogs.com/svg.image?_{n&plus;1}\mathrm{C}_{r&plus;1}=_{n}\mathrm{C}_{r}&plus;_{n}\mathrm{C}_{r&plus;1}" title="_{n+1}\mathrm{C}_{r+1}=_{n}\mathrm{C}_{r}+_{n}\mathrm{C}_{r+1}" />

그리고 위 수식은 다음과 같이 쓸 수 있는데,

<img src="https://latex.codecogs.com/svg.image?\binom{n&plus;1}{r&plus;1}=\binom{n}{r}&plus;\binom{n}{r&plus;1}" title="\binom{n+1}{r+1}=\binom{n}{r}+\binom{n}{r+1}" />

다음 식으로도 쓸 수 있으며

<img src="https://latex.codecogs.com/svg.image?\binom{n}{r}=\binom{n-1}{r-1}&plus;\binom{n-1}{r}" title="\binom{n}{r}=\binom{n-1}{r-1}+\binom{n-1}{r}" />

위 점화식을 **파스칼의 법칙** 이라고 한다.

2. 파스칼의 삼각형에서 어떤 줄의 첫번째 값과 마지막 값은 1인데, 수식으로 표현하면 다음과 같다.

<img src="https://latex.codecogs.com/svg.image?_{n}\mathrm{C}_{0}=_{n}\mathrm{C}_{n}=1" title="_{n}\mathrm{C}_{0}=_{n}\mathrm{C}_{n}=1" />

간단하게 아래와 같이 표현할 수도 있다.

<img src="https://latex.codecogs.com/svg.image?\binom{n}{0}=\binom{n}{r}=1" title="\binom{n}{0}=\binom{n}{r}=1" />

------

[참고 블로그](https://st-lab.tistory.com/162)

### 모듈러 연산의 활용

> a mod m = r 과 a % m = r 은 같은 의미다.
> 
> 모듈러 = 나머지

**-> m 으로 나눈 나머지 r에 대하여 a는 유일하지 않다.**

**-> a = km + r (여기서 k는 a를 m으로 나눴을 때의 몫)**

이렇게 m에 대한 배수(k) + 나머지(r) 로 a 값을 구할 수 있다.

### 모듈러 연산의 성질


