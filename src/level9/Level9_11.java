package level9;

import java.util.Scanner;

public class Level9_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for(int i=0; i<t; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int r1 = scanner.nextInt();

            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            int r2 = scanner.nextInt();

            System.out.println(getCount(x1, y1, r1, x2, y2, r2));
        }
    }

    public static int getCount(int x1, int y1, int r1, int x2, int y2, int r2) {

        int distance_pow = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        if(x1 == x2 && y1 == y2 && r1 == r2) {
            return -1;
        }
        else if(distance_pow > Math.pow(r1 + r2, 2)) {
            return 0;
        }
        else if(distance_pow < Math.pow(r2 - r1, 2)) {
            return 0;
        }
        else if(distance_pow == Math.pow(r2 - r1, 2)) {
            return 1;
        }
        else if(distance_pow == Math.pow(r1 + r2, 2)) {
            return 1;
        }
        else {
            return 2;
        }
    }
}
