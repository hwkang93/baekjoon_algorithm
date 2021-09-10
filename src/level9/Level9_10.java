package level9;

import java.util.Scanner;

public class Level9_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println(String.format("%.6f", Math.PI * n * n));
        System.out.println(String.format("%.6f", (double)n * n * 2));
    }
}
