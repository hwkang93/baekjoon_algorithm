package level9;

public class Level9_11 {
    public static void main(String[] args) {
        int result = 0;

        int x1 = 1;
        int y1 = 1;
        int r1 = 1;

        int x2 = 1;
        int y2 = 1;
        int r2 = 5;

        if((x1 == x2) && (y1 == y2)) {
            result = -1;
        }

        double length = getLength(x1,x2,y1,y2);

        //r1 + r2 < length => result = 0;

        if(r1 + r2 == length) {
            result = 1;
        }
        else if(r1 + r2 > length) {
            result = 2;
        }

        System.out.println(result);
    }

    public static double getLength(int x1, int x2, int y1, int y2) {
        if(x1 == x2 || y1 == y2) {
            int x = Math.abs(x1 - x2);
            int y = Math.abs(y1 - y2);

            return x+y;
        }
        else {
            return Math.sqrt(((x2-x1) * (x2-x1)) + ((y2-y1) * (y2-y1)));
        }
    }
}
