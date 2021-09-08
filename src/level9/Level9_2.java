package level9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *  2581. 소수
 *      자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.
 *      예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 소수는 61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로,
 *      이들 소수의 합은 620이고, 최솟값은 61이 된다.
 */
public class Level9_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> primeList = primeList(m,  n);

        //첫째 줄에 합
        int sum = primeList.stream().mapToInt(Integer::intValue).sum();
        if(sum > 0) {
            System.out.println(sum);
        }

        //둘째 줄에 최소값
        //int sum = primeList.get(0);
        int min = primeList.stream().min(Integer::compareTo).orElse(-1);

        System.out.println(min);
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
