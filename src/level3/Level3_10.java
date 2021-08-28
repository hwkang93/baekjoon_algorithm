package level3;

import java.util.Scanner;

/**
 *  2439. 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
 *      - 오른쪽 정렬하기
 */
public class Level3_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i = 1; i <= n; i ++) {
            for(int j = n; j > i; j--) {
                System.out.print(" ");
            }

            for(int j = 0; j < i; j ++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
