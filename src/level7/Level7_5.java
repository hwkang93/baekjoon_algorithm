package level7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *  1157. 단어 공부
 *      알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오.
 *      단, 대문자와 소문자를 구분하지 않는다.
 */
public class Level7_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next().toUpperCase();

        Map<Character, Integer> map = new HashMap<>();
        int maxValue = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            int count = map.containsKey(c) ? map.get(c) +1 : 1;
            map.put(c, count);

            maxValue = count > maxValue ? count : maxValue;
        }

        char result = '?';
        int maxCount = 0;

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() == maxValue) {
                result = entry.getKey();
                maxCount ++;
            }
        }

        System.out.println(maxCount > 1 ? '?' : result);
    }
}
