package level14;

public class Level14_8 {
    public static int n = 6;
    public static int[][] arr = getData();
    public static boolean[] team = new boolean[n];
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        startAndLink(0, 0);
        System.out.println(min);
    }

    public static void startAndLink(int at, int depth) {
        if(n/2 == depth) {
            getMinDifference();
            return;
        }

        for(int i=at; i<n; i++) {
            if(team[i] == false) {
                team[i] = true;
                startAndLink(i+1, depth+1);
                team[i] = false;
            }
        }
    }

    public static void getMinDifference() {
        int start = 0;
        int link = 0;
        //이부분 잘 모르겠음...
        for(int i=0; i<team.length -1; i++) {
            for(int j=i+1; j<team.length; j++) {
                if(team[i] == true && team[j] == true) {
                    start += arr[i][j];
                    start += arr[j][i];
                } else if (team[i] == false && team[j] == false) {
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }
        }

        int difference = Math.abs(start - link);

        if(min > difference) {
            min = difference;
        }
    }

    public static int[][] getData() {
        int[][] result = new int[6][6];
        String[] sArr = new String[6];

        sArr[0] = "0 1 2 3 4 5";
        sArr[1] = "1 0 2 3 4 5";
        sArr[2] = "1 2 0 3 4 5";
        sArr[3] = "1 2 3 0 4 5";
        sArr[4] = "1 2 3 4 0 5";
        sArr[5] = "1 2 3 4 5 0";

        for(int i=0; i<sArr.length; i++) {
            String[] parts = sArr[i].split(" ");
            for(int j=0; j<parts.length; j++) {
                result[i][j] = Integer.parseInt(parts[j]);
            }
        }

        for(int i=0; i<result.length; i++) {
            for(int j=0; j<result.length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        return result;
    }
}
