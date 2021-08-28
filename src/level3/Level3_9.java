package level3;

import java.util.Scanner;

/**
 *  2438. 별찍기
 *      - 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
 */
public class Level3_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j=0; j<=i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
