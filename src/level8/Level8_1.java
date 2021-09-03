package level8;

import java.util.Scanner;

public class Level8_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        /*
        a + bn > cn
        bn - cn > -a
        (b-c)n > -a
        n > -a/(b-c)

        n > a/(c-b) (a,b,c,n > 0)
        => c-b가 반드시 양수여야 함
        => 음수이면 손익분기점이 안생김

        int n = 0;
        if(c-b <= 0) {
            n = -1;
        } else {
            n = -a/(b-c) + 1;
        }
        */

        int n = (c-b <= 0 ? -1 : -a/(b-c) +1);

        System.out.println("n = " + n);
    }
}
