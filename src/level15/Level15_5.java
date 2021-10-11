package level15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  1149. RGB거리
 *      RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.
 *      집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때,
 *      아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.
 *          - 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
 *          - N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
 *          - i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
 *
 *      첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다.
 *      집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.
 *
 *      첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.
 */
public class Level15_5 {

    public static int[][] dp;
    public static int[][] cost;

    public static final int RED = 0;
    public static final int GREEN = 1;
    public static final int BLUE = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer;

        int n = Integer.parseInt(bufferedReader.readLine());

        dp = new int[n][3];
        cost = new int[n][3];

        for(int i=0; i<n; i++) {
            stringTokenizer= new StringTokenizer(bufferedReader.readLine(), " ");

            cost[i][RED] = Integer.parseInt(stringTokenizer.nextToken());
            cost[i][GREEN] = Integer.parseInt(stringTokenizer.nextToken());
            cost[i][BLUE] = Integer.parseInt(stringTokenizer.nextToken());
        }

        dp[0][RED] = cost[0][RED];
        dp[0][GREEN] = cost[0][GREEN];
        dp[0][BLUE] = cost[0][BLUE];

        int minOfRedAndGreen = Math.min(find(n-1, RED), find(n-1,GREEN));
        int result = Math.min(minOfRedAndGreen, find(n-1, BLUE));

        System.out.println(result);
    }

    public static int find(int index, int color) {
        if(dp[index][color] == 0) {
            if(color == RED) {
                dp[index][RED] = Math.min(find(index-1, GREEN), find(index-1, BLUE)) + cost[index][RED];
            }
            else if (color == GREEN) {
                dp[index][GREEN] = Math.min(find(index-1, RED), find(index-1, BLUE)) + cost[index][GREEN];
            }
            else {
                dp[index][BLUE] = Math.min(find(index-1, RED), find(index-1, GREEN)) + cost[index][BLUE];
            }
        }

        return dp[index][color];
    }
}
