package level15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  11053. 가장 긴 증가하는 부분 수열
 *      수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
 *      예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.
 *
 *      첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.
 *      둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)
 *
 *      첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
 */
public class Level15_11 {
    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++) {
            lis(i);
        }

        int max = 0;
        for(int i=0; i<n; i++) {
            max = dp[i] > max ? dp[i] : max;
        }

        System.out.println(max);
    }

    public static int lis(int n) {
        if(dp[n] == null) {
            //최소값으로 초기화. 1이 최솟값
            dp[n] = 1;

            //top-down
            for(int i=n-1; i>=0; i--) {
                if(arr[i] < arr[n]) {
                    /*
                        lis(i) +1 에서 +1 을 하는 이유
                        i = n-1 = dp[n-1] 이다.
                        dp[n-1] 값에서 수열 하나의 원소가 추가된 값과 비교해야 하므로 +1을 해줘야 한다.
                         (이전 부분 수열에 N 번째 원소가 추가되었다는 의미)
                     */
                    dp[n] = Math.max(dp[n], lis(i) +1);
                }
            }
        }

        return dp[n];
    }
}
