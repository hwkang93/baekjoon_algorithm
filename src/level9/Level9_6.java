package level9;


import java.util.Scanner;

/**
 *  9020. 골드바흐의 추측
 *      1보다 큰 자연수 중에서  1과 자기 자신을 제외한 약수가 없는 자연수를 소수라고 한다.
 *      예를 들어, 5는 1과 5를 제외한 약수가 없기 때문에 소수이다. 하지만, 6은 6 = 2 × 3 이기 때문에 소수가 아니다.
 *      골드바흐의 추측은 유명한 정수론의 미해결 문제로, 2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다는 것이다.
 *      이러한 수를 골드바흐 수라고 한다. 또, 짝수를 두 소수의 합으로 나타내는 표현을 그 수의 골드바흐 파티션이라고 한다.
 *      예를 들면, 4 = 2 + 2, 6 = 3 + 3, 8 = 3 + 5, 10 = 5 + 5, 12 = 5 + 7, 14 = 3 + 11, 14 = 7 + 7이다.
 *      10000보다 작거나 같은 모든 짝수 n에 대한 골드바흐 파티션은 존재한다.
 *
 *      2보다 큰 짝수 n이 주어졌을 때, n의 골드바흐 파티션을 출력하는 프로그램을 작성하시오.
 *      만약 가능한 n의 골드바흐 파티션이 여러 가지인 경우에는 두 소수의 차이가 가장 작은 것을 출력한다.
 */
public class Level9_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        boolean[] prime = primeList();

        for(int i = 0 ;i < prime.length; i++) {
            System.out.println(i + " " + !prime[i]);
        }

        for(int i = 0; i < t; i ++) {
            int n = scanner.nextInt();
            int a = n / 2;  //작은값
            int b = n / 2;  //큰값

            while(true) {
                if(!prime[a] && !prime[b]) {
                    System.out.println(a + " " + b);
                    break;
                }
                a--;
                b++;
            }
        }
    }

    //m 부터 n 까지 소수 리스트
    public static boolean[] primeList() {
        boolean[] primes = new boolean[10001];    //true : 소수 X    false : 소수 O
        primes[0] = primes[1] = true;   //0, 1 은 소수가 아님

        for(int i = 0; i <= Math.sqrt(primes.length); i++) {
            //소수가 아닌 수들은 패스!
            if(primes[i]) {
                continue;
            }

            //소수의 배수들은 소수가 아님
            for(int j = i * i; j < primes.length; j += i) {
                primes[j] = true;
            }
        }

        return primes;
    }
}
