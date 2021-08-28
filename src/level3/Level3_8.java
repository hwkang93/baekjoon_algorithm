package level3;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  11022. 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 *      - 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
 *      - 각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
 *      - 각 테스트 케이스마다 "Case #x: A + B = C" 형식으로 출력한다. x는 테스트 케이스 번호이고 1부터 시작하며, C는 A+B이다.
 */
public class Level3_8 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int t = Integer.parseInt(br.readLine());

            for(int i = 1; i <= t; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = a + b ;
                String message = "Case #" + i + ": " + a + " + " + b + " = " + c + "\n";

                bw.write(message);
            }

            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
