package level10;

import java.util.Scanner;

public class Level10_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = fibonacci(n);

        System.out.println(result);
    }

    // 0 <= n <= 20
    public static int fibonacci(int n) {

        if(n == 0 || n == 1) {
            return n;
        }

        return fibonacci(n-2) + fibonacci(n-1);
    }
}
