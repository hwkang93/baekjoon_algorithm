package level20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  10830. 행렬 제곱
 *      크기가 N*N인 행렬 A가 주어진다. 이때, A의 B제곱을 구하는 프로그램을 작성하시오.
 *      수가 매우 커질 수 있으니, A^B의 각 원소를 1,000으로 나눈 나머지를 출력한다.
 *
 *      첫째 줄에 행렬의 크기 N과 B가 주어진다. (2 ≤ N ≤  5, 1 ≤ B ≤ 100,000,000,000)
 *      둘째 줄부터 N개의 줄에 행렬의 각 원소가 주어진다. 행렬의 각 원소는 1,000보다 작거나 같은 자연수 또는 0이다.
 *
 *      첫째 줄부터 N개의 줄에 걸쳐 행렬 A를 B제곱한 결과를 출력한다.
 */
public class Level20_7 {
    public static int P = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //입력값 세팅
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        int n = Integer.parseInt(stringTokenizer.nextToken());
        long b = Long.parseLong(stringTokenizer.nextToken());

        int[][] matrix = new int[n][n];

        for(int i=0; i<n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

            for(int j=0; j<n; j++) {
                matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken()) % P;
            }
        }

        //연산
        int[][] result = pow(matrix, b);

        //결과 출력
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                stringBuilder.append(result[i][j]).append(' ');
            }

            stringBuilder.append('\n');
        }

        System.out.println(stringBuilder);
    }

    /**
     * 행렬 거듭 제곱
     * @param matrix 행렬
     * @param exponent 지수
     * @return 결과 행렬
     */
    public static int[][] pow(int[][] matrix, long exponent) {
        if(exponent == 1) {

            return matrix;
        }

        int[][] result = pow(matrix, exponent / 2);

        result = multiplyMatrix(result, result);

        //홀수면 result * matrix
        //ex) matrix^5 = matrix^2 * matrix^2 * matrix
        if(exponent % 2 == 1) {
            result = multiplyMatrix(result, matrix);
        }

        return result;
    }

    /**
     * 행렬 곱셈
     * @param m1 행렬 1
     * @param m2 행렬 2
     * @return 결과 행렬
     */
    public static int[][] multiplyMatrix(int[][] m1, int[][] m2) {
        int length = m1.length;
        int[][] result = new int[length][length];

        //캐싱을 위한 행렬 곱셈 방식 적용
        //참고 블로그 https://st-lab.tistory.com/251
        //TODO 이부분 이해가 잘 안되니 다시 공부하기
        int r;

        for(int k = 0; k < length; k++) {
            for(int i = 0; i < length; i++) {
                r = m1[i][k];
                for(int j = 0; j < length; j++) {
                    result[i][j] += r * m2[k][j];
                    result[i][j] %= P;
                }
            }
        }

        return result;
    }
}
