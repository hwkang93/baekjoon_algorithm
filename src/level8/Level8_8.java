package level8;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *  10757. 큰 수 A+B
 *      두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 */
public class Level8_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String strA = scanner.next();
        String strB = scanner.next();

        BigInteger a = new BigInteger(strA);
        BigInteger b = new BigInteger(strB);

        System.out.println(a.add(b));

    }
}
