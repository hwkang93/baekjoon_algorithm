package level15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Level15_7 {

    static Integer[] dp;
    static Integer[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        arr = new Integer[n+1];
        dp = new Integer[n+1];

        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }

        dp[0] = arr[0];
        dp[1] = arr[1];

        if(n > 1) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(find(n));
    }

    public static int find(int n) {
        if(dp[n] == null) {
            dp[n] = Math.max(find(n-2), find(n-3) + arr[n-1]) + arr[n];
        }

        return dp[n];
    }
}
