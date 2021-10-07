package level17;

import java.util.Scanner;

/**
 *  1676. 팩토리얼 0의 개수
 *      N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.
 *
 *      첫째 줄에 N이 주어진다.(0 <= N <= 500)
 *
 *      첫째 줄에 구한 0의 개수를 출력한다.
 */
public class Level17_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int result = 0;
        while (n >= 5) {
            result += n/5;
            n = n/5;
        }

        System.out.println(result);
    }
}
