package level7;

import java.util.Scanner;

/**
 *  10809. 알파벳 찾기
 *      알파벳 소문자로만 이루어진 단어 S가 주어진다. 각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를,
 *      포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.
 */
public class Level7_3 {
    public static void main(String[] args) {
        final String[] alphabets = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        for(String alphabet : alphabets) {
            boolean has = false;    //문자열을 가지고 있는 지 여부

            for(int i=0; i<s.length(); i++) {
                if(alphabet.equals(String.valueOf(s.charAt(i)))) {
                    System.out.print(i + " ");
                    has = true;
                    break;
                }
            }
            if(!has) {
                System.out.print("-1 ");
            }
        }
    }
}
