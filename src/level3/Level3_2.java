package level3;

import java.util.Scanner;

/**
 * 10950. 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 */
public class Level3_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        int[] results = new int[t];
        for(int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            results[i] = a + b;
        }

        for(int i=0; i< results.length; i++) {
            System.out.println(results[i]);
        }
    }
}
