package level3;

import java.util.Scanner;

/**
 *  2739. 구구단
 *      - N을 입력받은 뒤, 구구단 N단을 출력하는 프로그램을 작성하시오.
 */
public class Level3_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i=1; i<=9; i++) {
            System.out.println(n + " * " + i + " = " + n * i);
        }
    }
}
