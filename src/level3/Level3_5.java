package level3;

import java.io.*;

/**
 *  2741. 자연수 N이 주어졌을 때, 1부터 N까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
 */
public class Level3_5 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int n = Integer.parseInt(br.readLine());

            for(int i = 1; i <= n; i++) {
                bw.write(i + "\n");
            }

            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
