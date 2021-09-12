package level10;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *  2447. 별 찍기 - 10
 *      재귀적인 패턴으로 별을 찍어 보자. N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양이다.
 *      크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.
 *      ***
 *      * *
 *      ***
 *      N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다.
 *      예를 들어 크기 27의 패턴은 예제 출력 1과 같다.
 *      첫째 줄에 N이 주어진다. N은 3의 거듭제곱이다. 즉 어떤 정수 k에 대해 N=3^k이며, 이때 1 ≤ k < 8이다.
 *      첫째 줄부터 N번째 줄까지 별을 출력한다.
 *
 *      예제 출력 1
 *      ***************************
 *      * ** ** ** ** ** ** ** ** *
 *      ***************************
 *      ***   ******   ******   ***
 *      * *   * ** *   * ** *   * *
 *      ***   ******   ******   ***
 *      ***************************
 *      * ** ** ** ** ** ** ** ** *
 *      ***************************
 *      *********         *********
 *      * ** ** *         * ** ** *
 *      *********         *********
 *      ***   ***         ***   ***
 *      * *   * *         * *   * *
 *      ***   ***         ***   ***
 *      *********         *********
 *      * ** ** *         * ** ** *
 *      *********         *********
 *      ***************************
 *      * ** ** ** ** ** ** ** ** *
 *      ***************************
 *      ***   ******   ******   ***
 *      * *   * ** *   * ** *   * *
 *      ***   ******   ******   ***
 *      ***************************
 *      * ** ** ** ** ** ** ** ** *
 *      ***************************
 */
public class Level10_3 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(br.readLine());
            String[][] result = check(new String[n][n], n);

            for(int i=0; i<result.length; i++) {
                for (int j= 0; j< result[i].length; j++) {
                    sb.append(result[i][j]);
                }

                sb.append("\n");
            }

            System.out.print(sb);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //27 그리고 9 그리고 3 그리기
    public static String[][] check(String[][] arr, int n) {
        int blankStartIndex = n / 3;                //1, 3, 9 ...
        int blankEndIndex = blankStartIndex * 2;    //2, 6, 18 ...

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                if(arr[i][j] == " ") {
                    continue;
                }

                if(i%n >= blankStartIndex && i%n < blankEndIndex && j%n >= blankStartIndex && j%n < blankEndIndex) {
                    arr[i][j] = " ";
                } else {
                    arr[i][j] = "*";
                }
            }
        }

        if(n == 3) {
            return arr;
        } else {
            return check(arr, n/3);
        }
    }
}
