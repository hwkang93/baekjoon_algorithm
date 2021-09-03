package level7;

import java.util.Scanner;

/**
 *  2675. 문자열 반복
 *      문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.
 *      즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. S에는 QR Code "alphanumeric" 문자만 들어있다.
 *      QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.
 */
public class Level7_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        for(int i=0; i<l; i++) {
            int r = scanner.nextInt();
            String s = scanner.next();

            for(int j=0; j<s.length(); j++) {
                String str = String.valueOf(s.charAt(j));
                for(int k=0; k<r; k++) {
                    System.out.print(str);
                }
            }

            System.out.println();
        }
    }
}
