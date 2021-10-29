package level20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  2740. 행렬 곱셈
 *      N*M크기의 행렬 A와 M*K크기의 행렬 B가 주어졌을 때, 두 행렬을 곱하는 프로그램을 작성하시오.
 *
 *      첫째 줄에 행렬 A의 크기 N 과 M이 주어진다. 둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 순서대로 주어진다.
 *      그 다음 줄에는 행렬 B의 크기 M과 K가 주어진다. 이어서 M개의 줄에 행렬 B의 원소 K개가 차례대로 주어진다.
 *      N과 M, 그리고 K는 100보다 작거나 같고, 행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.
 *
 *      첫째 줄부터 N개의 줄에 행렬 A와 B를 곱한 행렬을 출력한다. 행렬의 각 원소는 공백으로 구분한다.
 */
public class Level20_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        int aN = Integer.parseInt(stringTokenizer.nextToken());
        int aM = Integer.parseInt(stringTokenizer.nextToken());

        int[][] a = new int[aN][aM];

        for(int i = 0; i < aN; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            for(int j = 0; j < aM; j++) {
                a[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        int bN = Integer.parseInt(stringTokenizer.nextToken());
        int bM = Integer.parseInt(stringTokenizer.nextToken());

        int[][] b = new int[bN][bM];

        for(int i = 0; i < bN; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            for(int j = 0; j < bM; j++) {
                b[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < aN; i++) {
            for(int j=0; j < bM; j++) {
                int sum = 0;
                //aM = bN
                for(int k = 0; k < aM; k++) {
                    sum += a[i][k] * b[k][j];
                }

                stringBuilder.append(sum).append(' ');
            }
            stringBuilder.append('\n');
        }

        System.out.println(stringBuilder);
    }
}
