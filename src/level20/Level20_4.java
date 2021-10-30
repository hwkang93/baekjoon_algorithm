package level20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *   1629. 곱셈
 *      자연수 A를 B번 곱한 수를 알고 싶다. 단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.
 *
 *      첫째 줄에 A, B, C가 빈 칸을 사이에 두고 순서대로 주어진다. A, B, C는 모두 2,147,483,647 이하의 자연수이다.
 *
 *      첫째 줄에 A를 B번 곱한 수를 C로 나눈 나머지를 출력한다.
 */
public class Level20_4 {
    public static long c;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        long a = Long.parseLong(stringTokenizer.nextToken());
        long b = Long.parseLong(stringTokenizer.nextToken());
        c = Long.parseLong(stringTokenizer.nextToken());

        System.out.println(pow(a,b));
    }

    public static long pow(long base, long expo) {
        if(expo == 1) {
            return base % c;
        }

        long temp = pow(base, expo / 2);

        if(expo % 2 == 1) {
            return (temp * temp % c) * base % c;
        }

        return temp * temp % c;
    }
}
