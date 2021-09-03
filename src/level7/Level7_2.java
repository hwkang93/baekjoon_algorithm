package level7;

import java.util.Scanner;

/**
 *  11720. 숫자의 합
 *      N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
 */
public class Level7_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();

        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            sum += Integer.parseInt(String.valueOf(c));
        }

        System.out.println(sum);
    }
}
