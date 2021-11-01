package level20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  11444. 피보나치 수 6
 *      피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
 *      이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
 *      n=17일때 까지 피보나치 수를 써보면 다음과 같다.
 *      0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
 *      n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
 *
 *      첫째 줄에 n이 주어진다. n은 1,000,000,000,000,000,000보다 작거나 같은 자연수이다.
 *
 *      첫째 줄에 n번째 피보나치 수를 1,000,000,007으로 나눈 나머지를 출력한다.
 */
public class Level20_8 {
    public static final int P = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(bufferedReader.readLine());
        long[][] basic = {
                {1 , 1},
                {1 , 0}
        };

        long result = pow(basic, n-1)[0][0];

        System.out.println(result);
    }

    //행렬 제곱하는 메소드
    public static long[][] pow(long[][] matrix, long expo) {
        if(expo == 0 || expo == 1) {
            return matrix;
        }

        long[][] result = pow(matrix, expo / 2);

        result = multiplyMatrix(result, result);

        return (expo % 2 == 1L ? multiplyMatrix(result, matrix) : result);
    }

    //행렬 곱하는 메소드
    public static long[][] multiplyMatrix(long[][] m1, long[][] m2) {
        int n = m1.length;
        int m = m2[0].length;
        long[][] result = new long[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = 0; k < m1[0].length; k++) {
                    result[i][j] += m1[i][k] * m2[k][j];
                    result[i][j] %= P;
                }
            }
        }

        return result;
    }
}
