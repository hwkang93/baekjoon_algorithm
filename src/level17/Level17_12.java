package level17;

import java.util.Scanner;

/**
 *  2004. 조합 0의 개수
 *      nCm의 끝자리 0의 개수를 출력하는 프로그램을 작성하시오.
 *
 *      첫째 줄에 정수 n,m(0 <= m <= n <= 2,000,000,000, n != 0)이 들어온다.
 *
 *      첫째 줄에 nCm의 끝자리 0의 개수를 출력한다.
 */
public class Level17_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();

        int count5 = get5Count(n) - get5Count(m) - get5Count(n-m);
        int count2 = get2Count(n) - get2Count(m) - get2Count(n-m);
        System.out.println(Math.min(count5, count2));
    }

    //5의 개수
    static int get5Count(long n) {
        int count = 0;

        while(n >= 5) {
            count += n / 5;
            n = n / 5;
        }

        return count;
    }

    static int get2Count(long n) {
        int count = 0;

        while (n >= 2) {
            count += n / 2;
            n = n / 2;
        }

        return count;
    }
}
