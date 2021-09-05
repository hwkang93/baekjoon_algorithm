package level8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  2869. 달팽이는 올라가고 싶다.
 *      땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
 *      달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.
 *      달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.
 */
public class Level8_4 {
    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            /*
            n일 동안 올라갈 수 있는 높이의 결과 : (a-b) * n = v
            n일 동안 올라갈 수 있는 최대 높이(a만큼 올라갔다가 b만큼 내려가기 전) :
                (a-b) * n + b >= v
                (a-b) * n = v-b
                n = (v-b) / (a-b)

            여기서 n은 "며칠" 이므로, 양의 정수여야 함
            그래서 n값에 나머지가 생기는 경우에는 n의 몫에 +1을 해줘야 함
            */
            int n = (v-b) / (a-b);
            if((v-b) % (a-b) != 0) {
                n ++;
            }

            System.out.println(n);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
