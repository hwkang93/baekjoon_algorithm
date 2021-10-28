package level20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Level20_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int aN = Integer.parseInt(stringTokenizer.nextToken());
        int aM = Integer.parseInt(stringTokenizer.nextToken());

        int[][] a = new int[aN][aM];

        for(int i = 0; i < aN; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            for(int j = 0; j < aM; j++) {
                a[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int bN = Integer.parseInt(stringTokenizer.nextToken());
        int bM = Integer.parseInt(stringTokenizer.nextToken());

        int[][] b = new int[bN][bM];

        for(int i = 0; i < bN; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            for(int j = 0; j < bM; j++) {
                b[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }



    }
}
