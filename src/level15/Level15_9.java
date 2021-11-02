package level15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  10844. 쉬운 계단 수
 *      45656이란 수를 보자.
 *      이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.
 *      N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구해보자. 0으로 시작하는 수는 계단수가 아니다.
 *
 *      첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.
 *
 *      첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.
 */
public class Level15_9 {
    public static final int P = 1000000000;
    //[자릿수][자릿값]
    public static Long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //자릿수
        int n = Integer.parseInt(bufferedReader.readLine());

        dp = new Long[n+1][10];

        /*
            dp[1][n] 은 1의 자리 수로
            경우의 수가 한 개 뿐임
            ex) ____3 => 3으로 1가지 수
         */
        for(int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        long result = 0;

        for(int i = 1; i <= 9; i++) {
            result += solve(n, i);
        }

        //마지막에도 모듈러 연산 해줘야 함,,,
        System.out.println(result % P);
    }

    /**
     *
     * @param digit 자릿수
     * @param val 자릿값
     */
    public static long solve(int digit, int val) {

        //digit == 1인 경우는 이미 초기화 돼있으므로 그냥 리턴
        if(digit == 1) {
            return dp[digit][val];
        }

        if(dp[digit][val] == null) {
            //_0____ 일 경우 0 다음에 올 수는 1 밖에 없음
            if(val == 0) {
                dp[digit][val] = solve(digit-1, 1);
            }
            //_9____ 일 경우 9 다음에 올 수는 8 밖에 없음
            else if(val == 9) {
                dp[digit][val] = solve(digit-1, 8);
            }
            //그 외의 경우 +1 , -1 이 올 수 있음
            else {
                dp[digit][val] = solve(digit -1, val -1) + solve(digit -1, val +1);
            }

        }

        return dp[digit][val] % P;
    }
}
