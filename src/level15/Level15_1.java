package level15;

import java.util.Scanner;

public class Level15_1 {

    static Integer[][] dp = new Integer[41][2];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        dp[0][0] = 1;   //n=0일때 0 호출 횟수
        dp[0][1] = 1;   //n=0일때 1 호출 횟수
        dp[1][0] = 1;   //n=1일때 0 호출 횟수
        dp[1][1] = 1;   //n=1일때 1 호출 횟수

        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            fibonacci(n);

            System.out.println(dp[n][0] + " " + dp[n][1]);
        }

    }

    public static Integer[] fibonacci(int n) {
        //int 면 == null 안됨
        if(dp[n][0] == null || dp[n][1] == null) {
            dp[n][0] = fibonacci(n-1)[0] + fibonacci(n-2)[0];
            dp[n][1] = fibonacci(n-1)[0] + fibonacci(n-2)[1];
        }

        return dp[n];
    }
}
