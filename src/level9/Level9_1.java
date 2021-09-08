package level9;

import java.util.Scanner;

/**
 *  1978. 소수찾기
 *      주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 */
public class Level9_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int primeCount = 0;

        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) {
            if(isPrime(scanner.nextInt())) {
                primeCount += 1;
            }
        }

        System.out.println(primeCount);
    }

    static boolean isPrime(int n) {
        if(n < 2) {
            return false;
        }

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
