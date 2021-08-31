package level5;

import java.util.Scanner;

/**
 *  4344. 평균은 넘겠지
 *      대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.
 *      첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
 *      둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
 */
public class Level5_7 {
    public static void main(String[] args) {
        //테스트 케이스의 개수 c
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        String[] results = new String[c];

        for(int i=0; i<c; i++) {
            //학생 수 n
            int n = scanner.nextInt();

            //학생들의 점수 총 합 구하기
            int[] scores = new int[n];
            int sum = 0;
            for(int j=0; j<n; j++) {
                scores[j] = scanner.nextInt();
                sum += scores[j];
            }
            //점수 평균
            double avg = (double) sum / n;
            //평균보다 높은 점수를 받은 사람 수 구하기
            int overAvg = 0;
            for(int j=0; j<n; j++) {
                if(scores[j] > avg) {
                    overAvg += 1;
                }
            }

            //소수 셋째자리까지만 출력
           results[i] = String.format("%.3f", (double) overAvg / n * 100 );
        }

        //결과 출력력
       for(int i=0; i<results.length; i++) {
            System.out.println(results[i] + "%");
        }
    }
}
