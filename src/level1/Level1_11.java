package level1;

import java.util.Scanner;

/**
 * 2588.
 *      (세 자리 수)x(세 자리 수)는 다음과 같은 과정을 통하여 이루어진다.
 *            4 7 2   > (1)
 *          x 3 8 5   > (2)
 *      -----------
 *          2 3 6 0   > (3)
 *        3 7 7 6     > (4)
 *      1 4 1 6       > (5)
 *      -----------
 *      1 8 1 7 2 0   > (6)
 *      (1)과 (2)위치에 들어갈 세 자리 자연수가 주어질 때 (3), (4), (5), (6)위치에 들어갈 값을 구하는 프로그램을 작성하시오.
 */
public class Level1_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(a * ((b / 1) % 10));
        System.out.println(a * ((b / 10) % 10));
        System.out.println(a * ((b / 100) % 10));
        System.out.println(a * b);
    }
}
