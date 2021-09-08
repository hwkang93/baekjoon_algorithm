package level9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *  11653. 소인수분해
 *      정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.
 */
public class Level9_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        //n == 1 일때는 아무것도 출력하지 않는다.
        if(n != 1) {
            List<Integer> primeList = primeList(n);
            int i = 0;
            while(true) {
                if(n % primeList.get(i) == 0) {
                    n = n / primeList.get(i);
                    System.out.println(primeList.get(i));
                } else {
                    i++;
                }

                //n = 1 될때까지 소인수분해
                if(n == 1) {
                    break;
                }
            }
        }
    }

    public static List<Integer> primeList(int n) {
        List<Integer> resultList = new ArrayList<>();
        //TRUE : 소수 X    FALSE : 소수 O
        boolean[] prime = new boolean[n+1];

        prime[0] = prime[1] = true;
        for (int i = 0; i < Math.sqrt(prime.length); i++) {
            if(prime[i]) {
                continue;
            }

            for(int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }

        for (int i = 0; i < prime.length; i++) {
            if(!prime[i]) {
                resultList.add(i);
            }
        }

        return resultList;
    }
}
