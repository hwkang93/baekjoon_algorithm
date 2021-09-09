package level10;

public class Level10_3 {
    public static void main(String[] args) {
        int n = 9;



    }

    public void check(int n) {
        if(n == 1) {
            return;
        }

        int[][] star = new int[n][n];

        int min = n/3;
        int max = n/3 * 2 -1;

        for(int i=0; i<star.length; i++) {
            for(int j=0; j<star[i].length; j++) {

            }
        }

        check(n/3);
    }

    public int[][] check(int[][] star) {
        //최초에는 star.length = 27
        int n = star.length;
        int min = n/3;
        int max = n/3 * 2 -1;
        for(int i = 0 ; i < star.length; i ++ ) {
            for ( int j = 0 ; j < star[i].length; j ++) {
                if((i >= min || i <= max) && (j >= min || j <= max)) {
                    star[i][j] = 0;
                }
            }
        }

        return null;
    }

}
