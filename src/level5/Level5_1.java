package level5;

import java.util.Scanner;

/**
 *  10818. N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
 */
public class Level5_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = 1000000;
        int max = -1000000;
        int n = scanner.nextInt();

        for(int i=0; i<n; i++) {
            int a = scanner.nextInt();
            if(a > max) {
                max = a;
            }
            if(a < min) {
                min = a;
            }
        }

        System.out.println(min + " " + max);
    }
}
