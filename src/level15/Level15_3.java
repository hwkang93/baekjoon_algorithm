package level15;

import java.util.Scanner;

/**
 *  1904. 01타일
 *      지원이에게 2진 수열을 가르쳐 주기 위해, 지원이 아버지는 그에게 타일들을 선물해주셨다. 그리고 이 각각의 타일들은 0 또는 1이 쓰여 있는 낱장의 타일들이다.
 *      어느 날 짓궂은 동주가 지원이의 공부를 방해하기 위해 0이 쓰여진 낱장의 타일들을 붙여서 한 쌍으로 이루어진 00 타일들을 만들었다.
 *      결국 현재 1 하나만으로 이루어진 타일 또는 0타일을 두 개 붙인 한 쌍의 00타일들만이 남게 되었다.
 *      그러므로 지원이는 타일로 더 이상 크기가 N인 모든 2진 수열을 만들 수 없게 되었다. 예를 들어, N=1일 때 1만 만들 수 있고, N=2일 때는 00, 11을 만들 수 있다.
 *      (01, 10은 만들 수 없게 되었다.) 또한 N=4일 때는 0011, 0000, 1001, 1100, 1111 등 총 5개의 2진 수열을 만들 수 있다.
 *      우리의 목표는 N이 주어졌을 때 지원이가 만들 수 있는 모든 가짓수를 세는 것이다. 단 타일들은 무한히 많은 것으로 가정하자.
 *
 *      첫 번째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 1,000,000)
 *
 *      첫 번째 줄에 지원이가 만들 수 있는 길이가 N인 모든 2진 수열의 개수를 15746으로 나눈 나머지를 출력한다.
 */
public class Level15_3 {
    //TODO IDE 에서 n = 1,000,000 일 경우 테스트를 해봤는데, StackOverflowError 발생함.
    //TODO IDE 에서 잡고 있는 스택 영역이 작아서 그러지 않을까 생각해봄. 시간나면 확인해봐야지!
    public static Integer[] dp = new Integer[1000001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        /**
         *  int[] 로 선언하면 배열의 기본값이 0임
         *  나머지가 0일 가능성이 있어 배열의 기본값을 -1로 초기화해주는 작업이 필요한데,
         *  Integer[] 로 선언하면 배열의 기본값이 null 이기 때문에 기본값 초기화해주는 작업이 필요 없음.
         */
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        int result = tile(n);

        System.out.println(result);
    }

    public static int tile(int n) {
        if(dp[n] != null) {
            return dp[n];
        }

        dp[n] = (tile(n-1) + tile(n-2)) % 15746;

        return dp[n];
    }
}
