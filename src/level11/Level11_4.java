package level11;

import java.util.Scanner;

/**
 *  1018. 체스판 다시 칠하기
 *      지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M*N 크기의 보드를 찾았다.
 *      어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다. 지민이는 이 보드를 잘라서 8*8 크기의 체스판으로 만들려고 한다.
 *      체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다. 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고,
 *      변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다. 따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다.
 *      하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.
 *      보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8*8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다.
 *      당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.
 */
public class Level11_4 {

    public static boolean[][] arr;
    public static int min = 64;         //체스판은 8x8이기 때문에 다시 칠해야 하는 체스 블록 개수는 64개

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        arr = new boolean[n][m];
        
        /*
         * Scanner 의 경우 공백자로 구분하다가
         * 개행으로 입력되면 스트림에 개행이 남아있어서
         * 의도와 달리 첫 번째 String 입력은 개행이 저장된다.
         * 그렇기 때문에 nextLine() 을 통해
         * 문자열 입력 전의 int와 String 입력 사이의 개행을 없애주도록 한다.
         */
        scanner.nextLine();
        
        for(int i = 0; i < n; i++) {
            String s = scanner.nextLine().trim();
            
            for(int j = 0; j < m; j++) {
                if(s.charAt(j) == 'W') {
                    arr[i][j] = true;       //W => true
                } else {
                    arr[i][j] = false;      //B => false
                }
            }
        }
        
        //8x8 체스판으로 만들기 위해
        int nCount = n-7;
        int mCount = m-7;
        
        for(int i = 0; i < nCount; i++) {
            for(int j = 0; j < mCount; j++) {
                find(i,j);
            }
        }

        System.out.println(min);
    }
    
    public static void find(int x, int y) {
        int xEnd = x + 8;
        int yEnd = y + 8;
        int count = 0;
        
        boolean tf = arr[x][y];     //첫 번째 칸의 색
        
        for(int i = x; i < xEnd; i++) {
            for(int j = y; j < yEnd; j++) {
                
                //올바른 색이 아닐 경우 count 1 증가
                if(arr[i][j] != tf) {
                    count++;
                }
                
                //다음칸에 색이 바뀌어야 함
                tf = !tf;
            }
            
            tf = !tf;
        }

        /**
         *  첫 번째 칸이 W(true)인 경우 개수와
         *  첫 번째 칸이 B(false)인 경우 개수 비교해서
         *  더 작은 값을 count 변수에 할당
         */
        count = Math.min(count, 64 - count);
        
        /**
         *  최소값 갱신
         */
        min = Math.min(min, count);
    }
}