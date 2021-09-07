# Level7_6.java

## 1152. 단어의 개수

- **내가 짰던 소스코드**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next().trim();

        System.out.println(str.split(" ").length);
    }
}
```

예제로 주어진 문자열들의 테스트는 모두 성공을 했다. 하지만 결과는 실패

<br/>

- **실패한 이유**

**str = ""** 인 경우를 고려 못함.

String class 의 trim 메소드를 살펴보면,
```
// (2335 line) If no match was found, return this
if (off == 0)
return new String[]{this};
```

값이 없는 경우 스트링 배열에 ```this```를 담아 리턴하도록 되어있는데,

여기서 ```this```는 파라미터로 받았던 빈 문자열을 의미한다.

0번째 원소가 공백 문자열인 스트링 배열이 리턴되고 값이 0이 아닌 1이 출력된다.

출제자의 의도에 따르면 빈 문자열의 리턴값은 1이 아닌 0으로 나와야 하는데 이부분까지 고려 못했기 때문에 틀렸다.

<br/>

- **마무리**

결국 이번 문제는 구글의 도움을 어느정도 받아 틀린 이유를 찾을 수 있었고, 원인을 해결하려고 하다 보니
결과가 그렇게 썩 좋지 못한 코드가 나왔다.

하지만 다른 사람이 해결한 방법을 따라하는 것은 본래 내가 공부하고자 하는 방향이 아니므로 50단계까지 진행한 후
다시 풀어봐야지 !
