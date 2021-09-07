# 에라토스테네스의 체

'특정 범위 내의 소수' 를 판정하는 데에 효율적인 알고리즘

에라토스테네스의 체를 이요해 1~n 까지의 소수를 알고 싶다면, n까지 모든 수의 배수를 다 나눠볼 필요는 없다. 
만약 어떤 수 m = ab 라면, a와 b중 적어도 하나는 루트n 이하이다.

> 예를 들어, m = 16의 경우 a와 b로 들어갈 수 있는 값은 a=1 b=16 , a=2 b=8 , a=4 b=4 , a=8 b=2 , a=16 b=1 이 있는데, 
> 이는 제곱근을 기준으로 대칭을 이루기 때문이다.

즉 n보다 작은 합성수 m은 루트n 보다 작은 수의 배수만 체크해도 전부 지워진다는 의이므로, 
루트n 이하의 배수만 지우면 된다. 

<br/>

### 예제 소스코드
[참고 블로그(너무너무 좋다. 모르는 알고리즘은 여기 들어가서 참고하기)](https://st-lab.tistory.com/81)

```java
public class Prime {
    public static void main(String[] args) {
        /**
         * 20 이하의 소수들을 출력하시오. 
         */
        
        final int N = 20;
        
        boolean prime[] = new boolean[N+1];
        for(int i=2; i<=Math.sqrt(prime.length); i++) {
            
            //이미 확인된 배열은 제외
            if(prime[i]) {
                continue;
            }
            
            //i의 배수는 제외
            for(int j= i*i; j <prime.length; j++) {
                prime[j] = true;
            }
        }

        for (int i = 0; i < prime.length; i++) {
            if(!prime[i]) {
                System.out.println(i);
            }
        }
    }
}
```




