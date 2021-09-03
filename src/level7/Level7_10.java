package level7;

import java.util.Scanner;

/**
 *  1316. 그룹 단어 체커
 *      그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
 *      예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만,
 *      aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
 *      단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
 */
public class Level7_10 {
    public static void main(String[] args) {
        int result = 0;

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i=0; i<n; i++) {
            String str = scanner.next();
            result += groupWordChecker(str);
        }

        System.out.println(result);
    }

    /**
     *  0. 문자열 StringBuffer에 담음 (특정 위치 문자열 쉽게 변경하기 위해)
     *
     *  1. 연속된 문자열 공백 문자열(" ")으로 치환
     *  2. 공백 문자열 모두 소거
     *  3. 문자열들 서로 비교하면서 중복된 문자열 있는지 확인
     *  4. 중복된 문자열이 없으면 1, 있으면 0 리턴
     */
    public static int groupWordChecker(String str) {
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        /**
         *  i번째와 i+1번째의 문자열이 같을 경우 i번째의 문자열을 공백 문자열로 치환.
         *  이유는 i+1번째 문자열과 i+2번째 문자열이 같은지 또 비교해야 하기 떄문
         *
         *  만약 i+1번째를 공백으로 치환하는 경우를 ppp로 예로 들면
         *  ppp -> p가 되어야 하는데
         *  ppp -> p p 가 됨
         *
         *  또한 공백 문자열로 하는 이유는 빈 문자열로 하게되면 인덱스를 잘못 타게 되는데,
         *  ppp를 예로 들면
         *  1. 0번째 1번째 비교 후 소거 - ppp -> pp
         *  2. 1번째 2번째 비교 후 소거 - pp 문자열에는 2번째 문자열(0,1,2니까 실제로는 3번째)이 없으므로 잘못된 결과물이 출력됨
         */
        for(int i=0; i<sb.length() -1; i++) {
            if(sb.charAt(i) == sb.charAt(i+1)) {
                sb.replace(i, i+1, " ");
            }
        }

        //공백 문자열 모두 소거
        String refinedStr = sb.toString().replaceAll(" ", "");

        //중복 문자열 비교
        boolean hasSame = false;
        for(int i=0; i<refinedStr.length(); i++) {
            char c = refinedStr.charAt(i);

            for(int j = i+1; j < refinedStr.length(); j++) {
                char compareC = refinedStr.charAt(j);
                if(c == compareC) {
                    hasSame = true;
                    break;
                }
            }
        }

        //중복 문자열이 있으면 0, 없으면 1 리턴
        return hasSame ? 0 : 1;
    }
}
