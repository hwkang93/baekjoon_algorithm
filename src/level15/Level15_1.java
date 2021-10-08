package level15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  1003. 피보나치 함수
 *      다음 소스는 N번째 피보나치 수를 구하는 C++ 함수이다.
 *          int fibonacci(int n) {
 *              if (n == 0) {
 *                  printf("0");
 *                  return 0;
 *              } else if (n == 1) {
 *                  printf("1");
 *                  return 1;
 *              } else {
 *                  return fibonacci(n‐1) + fibonacci(n‐2);
 *              }
 *          }
 *      fibonacci(3)을 호출하면 다음과 같은 일이 일어난다.
 *          - fibonacci(3)은 fibonacci(2)와 fibonacci(1) (첫 번째 호출)을 호출한다.
 *          - fibonacci(2)는 fibonacci(1) (두 번째 호출)과 fibonacci(0)을 호출한다.
 *          - 두 번째 호출한 fibonacci(1)은 1을 출력하고 1을 리턴한다.
 *          - fibonacci(0)은 0을 출력하고, 0을 리턴한다.
 *          - fibonacci(2)는 fibonacci(1)과 fibonacci(0)의 결과를 얻고, 1을 리턴한다.
 *          - 첫 번째 호출한 fibonacci(1)은 1을 출력하고, 1을 리턴한다.
 *          - fibonacci(3)은 fibonacci(2)와 fibonacci(1)의 결과를 얻고, 2를 리턴한다.
 *      1은 2번 출력되고, 0은 1번 출력된다. N이 주어졌을 때, fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오.
 *
 *      첫째 줄에 테스트 케이스의 개수 T가 주어진다.
 *      각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.
 *
 *      각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.
 */
public class Level15_1 {

    /*
        new Integer[41][2] 에서 41 은 N의 최대값 40 + 1 (배열은 0부터 시작하므로)
                                2 는 0과 1일 담길 칸
     */
    public static Integer[][] dp = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        //테스트 개수
        int t = Integer.parseInt(bufferedReader.readLine());

        //dp 에 디폴드 값 할당
        dp[0][0] = 1;   //n=0 일 때 0의 개수
        dp[0][1] = 0;   //n=0 일 때 1의 개수
        dp[1][0] = 0;   //n=1 일 때 0의 개수
        dp[1][1] = 1;   //n=1 일 때 1의 개수

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            fibonacci(n);

            stringBuilder.append(dp[n][0]).append(" ").append(dp[n][1]).append('\n');
        }

        System.out.println(stringBuilder);
    }

    public static Integer[] fibonacci(int n) {
        /*
            피보나치 수에서,
                f(3) = f(2) + f(1)
                     = f(1) + f(0) + f(1)
            이다.
            그럼 f(3)일 때 0의 개수를 구해보면
            f(3)의 0의 개수
                = f(2)의 0의 개수 + f(1)의 0의 개수
                = f(1)의 0의 개수 + f(0)의 0의 개수 + f(1)의 0의 개수
            로 표현할 수 있다.
            위의 main 함수에서 f(1)의 0의 개수와 f(0)의 0의 개수를 정의해놨으므로
            아래와 같이 구현이 가능하다.
         */
        if(dp[n][0] == null || dp[n][1] == null) {
            //n의 0의 개수 = fibonacci(n-1)의 0의 개수 + fibonacci(n-2)의 0의 개수
            dp[n][0] = fibonacci(n-1)[0] + fibonacci(n-2)[0];

            //n의 1의 개수 = fibonacci(n-1)의 1의 개수 + fibonacci(n-2)의 1의 개수
            dp[n][1] = fibonacci(n-1)[1] + fibonacci(n-2)[1];
        }

        return dp[n];
    }
}
