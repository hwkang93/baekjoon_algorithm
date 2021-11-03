### 이분 탐색(Binary Search)
[참고 블로그](https://st-lab.tistory.com/261)

- 어떤 문제를 두 부분으로 나눠가며 값을 찾아가는 방식
- = 이진 탐색(Binary 공학적으로는 가 0과 1을 의미하므로 이진과 이분은 같은 뜻으로 간주함)
- 이분 탐색의 가장 적절한 예시로는 Up & Down 게임이 있음
> 1~50 까지의 수 중 17을 정답으로 정했다고 하자.
> 
> 정답을 맞추는 사람은 대게 1 ~ 50의 가운데 수인 25를 먼저 물을 것이다.
> 그리고 정답자가 Down 이라고 하면 25의 절반인 12 혹은 13을 말할 것이고,
> 정답을 맞추는 사람은 그렇게 수의 범위를 점점 줄여가며 답을 찾아간다.

- **이분 탐색을 하기 위해서는 반드시 값이 정렬되어 있어야 한다.**
- 이진 트리 형태의 경우 대다수가 O(logN)의 시간복잡도를 갖는다.

#### 이진 트리의 시간 복잡도 증명

N 개의 요소를 가지고 있는 리스트를 이분탐색한다고 했을 때,

<img src="https://latex.codecogs.com/svg.image?case1\Rightarrow\frac{1}{2}*N" title="case1\Rightarrow\frac{1}{2}*N" />

<br/>

<img src="https://latex.codecogs.com/svg.image?case2\Rightarrow\frac{1}{2}*\frac{1}{2}*N" title="case2\Rightarrow\frac{1}{2}*\frac{1}{2}*N" />

<br/>

<img src="https://latex.codecogs.com/svg.image?case3\Rightarrow\frac{1}{2}*\frac{1}{2}*\frac{1}{2}*n" title="case3\Rightarrow\frac{1}{2}*\frac{1}{2}*\frac{1}{2}*n" />


...

<img src="https://latex.codecogs.com/svg.image?caseT\Rightarrow\frac{1}{2}^{T}*N" title="caseT\Rightarrow \frac{1}{2}^{T}\times N" />

K 번 반복한다고 했을 때,
<img src="https://latex.codecogs.com/svg.image?\frac{1}{2}^{T}*N" title="\frac{1}{2}^{T}\times N" />
가 된다.

K번 반복 했을 때 쪼개진 크기 (남은 배열의 크기) 가 1이라고 가정한다면,
(최악의 경우를 가정)

<img src="https://latex.codecogs.com/svg.image?\frac{1}{2}^{T}*N=1" title="\frac{1}{2}^{T}*N=1" />
<br/><br/>
<img src="https://latex.codecogs.com/svg.image?2^{T}*\frac{1}{2}^{T}*N=2^{T}" title="2^{T}*\frac{1}{2}^{T}*N=2^{T}" />
<br/><br/>
<img src="https://latex.codecogs.com/svg.image?N=2^{T}" title="N=2^{T}" />
<br/><br/>
<img src="https://latex.codecogs.com/svg.image?log_{2}*N=log_{2}2^{T}" title="log_{2}*N=log_{2}2^{T}" />
<br/><br/>
<img src="https://latex.codecogs.com/svg.image?T=log_{2}N" title="T=log_{2}N" />

