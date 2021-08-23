package level1;

import java.util.Scanner;

/**
 * 10998. 두 정수 A와 B를 입력받은 다음, AxB를 출력하는 프로그램을 작성하시오.
 */
public class Level1_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(a * b);
    }
}
