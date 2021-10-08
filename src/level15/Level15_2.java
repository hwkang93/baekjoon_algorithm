package level15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  9184. 신나는 함수 실행
 *      재귀 호출만 생각하면 신이 난다! 아닌가요?
 *      다음과 같은 재귀함수 w(a, b, c)가 있다.
 *          if a <= 0 or b <= 0 or c <= 0, then w(a, b, c) returns:
 *              1
 *          if a > 20 or b > 20 or c > 20, then w(a, b, c) returns:
 *              w(20, 20, 20)
 *          if a < b and b < c, then w(a, b, c) returns:
 *              w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
 *          otherwise it returns:
 *              w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
 *      위의 함수를 구현하는 것은 매우 쉽다. 하지만, 그대로 구현하면 값을 구하는데 매우 오랜 시간이 걸린다. (예를 들면, a=15, b=15, c=15)
 *      a, b, c가 주어졌을 때, w(a, b, c)를 출력하는 프로그램을 작성하시오.
 *
 *      입력은 세 정수 a, b, c로 이루어져 있으며, 한 줄에 하나씩 주어진다. 입력의 마지막은 -1 -1 -1로 나타내며,
 *      세 정수가 모두 -1인 경우는 입력의 마지막을 제외하면 없다.
 *
 *      입력으로 주어진 각각의 a, b, c에 대해서, w(a, b, c)를 출력한다.
 */
public class Level15_2 {
    //0~50 -> 51개
    //-50 ~ -1까지 50개
    public static Integer dp[][][] = new Integer[101][101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1 && c == -1) {
                break;
            }

            int refineA = a + 50;
            int refineB = b + 50;
            int refineC = c + 50;

            int result = w(refineA, refineB, refineC);
            stringBuilder.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(result).append('\n');
        }
        System.out.println(stringBuilder);
    }

    public static int w(int a, int b , int c) {
        if(dp[a][b][c] != null) {
            return dp[a][b][c];
        }

        if(a <= 50 || b <= 50 || c <= 50) {
            dp[a][b][c] = 1;
        }
        else if (a > 70 || b > 70 || c > 70) {
            dp[a][b][c] = w(70, 70, 70);
        }
        else if (a < b && b < c) {
            dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        } else {
            dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        }

        return dp[a][b][c];
    }
}
