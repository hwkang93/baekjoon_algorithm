package level2;

import java.util.Scanner;

/**
 *  1330. 두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램을 작성하시오.
 *   - A가 B보다 큰 경우에는 '>'를 출력한다.
 *   - A가 B보다 작은 경우에는 '<'를 출력한다.
 *   - A와 B가 같은 경우에는 '=='를 출력한다.
 */
public class Level2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        String result = a > b ? ">" : a < b ? "<" : "==";

        System.out.println(result);
    }
}
