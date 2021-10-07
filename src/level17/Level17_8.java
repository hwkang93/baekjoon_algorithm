package level17;

import java.util.Scanner;

/**
 *  11051. 이항 계수 2
 *      자연수 N과 정수 K가 주어졌을 때 이항계수 nCk를 10,007로 나눈 나머지를 구하는 프로그램을 작성하시오.
 *
 *      첫째 줄에 N과 K가 주어진다. (1 <= N 1,000 , 0 <= K <= N)
 *
 *      nCk를 10,007로 나눈 나머지를 출력한다.
 */
public class Level17_8 {
    public static int dp[][];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        dp = new int[n+1][k+1];

        System.out.println(binomial(n, k));
    }

    //N의 범위가 커서(N<=1000 이면 최대 시간복잡도 = 1000!) 동적계획법으로 구현
    public static int binomial(int n, int k) {
        if(dp[n][k] > 0) {
            return dp[n][k];
        }
        if(k == 0 || n == k) {
            return 1;
        }

        dp[n][k] = (binomial(n-1, k-1) + binomial(n-1, k)) % 10007;

        return dp[n][k];
    }
}
