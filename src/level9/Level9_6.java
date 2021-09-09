package level9;


import java.util.Scanner;

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
