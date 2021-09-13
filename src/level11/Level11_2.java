package level11;


import java.util.Scanner;

/**
 *  2231. 분해합
 *      어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다.
 *      어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다. 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다.
 *      따라서 245는 256의 생성자가 된다. 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다.
 *      반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
 *      자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오. 생성자가 없는 경우에는 0을 출력한다.
 */
public class Level11_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println(decomposition(n));
    }

    public static int decomposition(int n) {
        int result = 0;
        int length = (int)Math.log10(n) +1;         //n의 자릿수 ex) 216 = 3자리 / 1234 = 4


        while (true) {
            int sum = result;                           //어떤 수와 그 수의 각 자리 합
            for(int i = length -1; i >= 0; i--) {
                int tenSquared = (int)Math.pow(10, i);  //각 자릿수 값 구하기
                sum += (result / tenSquared) % 10;
            }

            //어떤 수와 그 수의 각 자리 합이 n과 같을 때 어떤 수를 리턴한다.
            if(sum == n) {
                break;

            //생성자가 없는 경우 0 리턴한다.
            } else if (result > n) {
                result = 0;
                break;
            }

            result ++;
        }

        return result;
    }
}
