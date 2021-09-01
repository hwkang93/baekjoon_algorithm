package level6;

import java.util.Scanner;

/**
 *  1065. 어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다.
 *      N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.
 */
public class Level6_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println(arithmeticSequence(n));
    }

    public static int arithmeticSequence(int n) {
        /**
         *  n < 100이면 무조건 등차수열
         *  ex) 13(1,3,5,7...), 57(5,7,8,9...), 72(7,2,-3,-8...), 75(7,5,3,1...), 88(8,8,8,8...), 97(9,7,5,3...) ..
         */
        if(n < 100) {
            return n;
        }
        else {
            //100 <= n <= 1000
            //1000은 절대 등차수열이 아니므로 999로 치환
            n = (n == 1000 ? 999 : n);

            int count = 0;
            for(int i = 100; i <= n; i++) {
                int hundred = (i / 100) % 10;
                int ten = (i / 10) % 10;
                int one = (i % 10);

                if((hundred - ten) == (ten - one)) {
                    count += 1;
                }
            }

            //여기서 99 = 1~99까지 (1자리, 2자리 자연수는 모두 등차수열이므로)
            return 99 + count;
        }
    }
}
