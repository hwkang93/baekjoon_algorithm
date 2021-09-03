package level7;

import java.util.Scanner;

/**
 *  2941. 크로아티아 알파벳
 *
 *      크로아티아 알파벳	변경
 *              č	    c=
 *              ć   	c-
 *              dž  	dz=
 *              đ   	d-
 *              lj  	lj
 *              nj  	nj
 *              š   	s=
 *              ž	    z=
 *      예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다. 단어가 주어졌을 때,
 *      몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
 *      dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다. lj와 nj도 마찬가지이다.
 *      위 목록에 없는 알파벳은 한 글자씩 센다.
 */
public class Level7_9 {
    public static void main(String[] args) {
        /**
         * 여기서 중요한 점
         *  dz=가 z=보다 앞에 있어야 함
         *  croatiaAlphabets 로 for 루프를 돌아야 하는데
         *  만약 z=가 먼저 있을 경우 dz= 라는 문자열이 파라미터로 들어오면
         *  z= 소거 후 d 문자열이 남기 때문에 1이 리턴되지 않고 2가 리턴됨.
         */
        final String[] croatiaAlphabets = {"dz=", "z=", "c=", "c-", "d-", "lj", "nj", "s="};

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        //크로아티아 문자열이 포함되면 빈 칸 문자열로 치환
        for(String croatiaAlphabet : croatiaAlphabets) {
            if(str.contains(croatiaAlphabet)) {
                str = str.replace(croatiaAlphabet, " ");
            }
        }

        //문자열 개수 출력
        System.out.println(str.length());
    }
}
