package level9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *  1929. 소수 구하기
 *      M이상 N 이하의 소수를 모두 출력하는 프로그램을 작성하시오.
 */
public class Level9_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        primeList(m, n).forEach(System.out::println);
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
