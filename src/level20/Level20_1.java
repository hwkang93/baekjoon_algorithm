package level20;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Level20_1 {

    public static final int BLUE = 1;
    public static final int WHITE = 0;

    public static int blueCount = 0;
    public static int whiteCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        int[][] confetti = new int[n][n];
        StringTokenizer stringTokenizer;

        for(int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            for(int j = 0; j < n; j++) {
                confetti[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

    }

    public static void check(int start, int end, int startColor) {


    }
}
