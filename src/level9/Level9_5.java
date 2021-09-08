package level9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *  4948. 베르트랑 공준
 *      베르트랑 공준은 임의의 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재한다는 내용을 담고 있다.
 *      이 명제는 조제프 베르트랑이 1845년에 추측했고, 파프누티 체비쇼프가 1850년에 증명했다.
 *      예를 들어, 10보다 크고, 20보다 작거나 같은 소수는 4개가 있다. (11, 13, 17, 19)
 *      또, 14보다 크고, 28보다 작거나 같은 소수는 3개가 있다. (17,19, 23)
 *      자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오.
 */
public class Level9_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> resultList = new ArrayList<>();

        while(true) {
            int n = scanner.nextInt();
            if(n == 0) {
                break;
            }

            resultList.add(primeList(n + 1, 2 * n).size());
        }

        resultList.forEach(System.out::println);
    }

    //m~n 까지 소수 목록
    public static List<Integer> primeList(int m, int n) {
        List<Integer> resultList = new ArrayList<>();
        //true : 소수 X , false : 소수 O
        boolean[] prime = new boolean[n+1];
        //0, 1은 소수 아님
        prime[0] = prime[1] = true;

        for (int i = 0; i < Math.sqrt(prime.length); i++) {
            //이미 소수가 아니라고 결정된 경우 패스
            if(prime[i]) {
                continue;
            }

            //i의 배수는 소수가 아님
            for(int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }

        for(int i = m; i < prime.length; i++) {
            if(!prime[i]) {
                resultList.add(i);
            }
        }

        return resultList;
    }
}
