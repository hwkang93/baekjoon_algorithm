package level17;

import java.util.Scanner;

/**
 *  2609. 최대공약수와 최소공배수
 *      두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
 *
 *      첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.
 *
 *      첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
 */
public class Level17_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(gcd(a, b));
        System.out.println(lmc(a, b));
    }

    //최대공약수
    public static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    //최소공배수
    public static int lmc(int a, int b) {
        //두 수의 곱 / 두 수의 최대공약수
        return a * b / gcd(a, b);
    }
}
