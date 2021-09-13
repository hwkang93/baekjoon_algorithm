package level11;


/**
 *  2231. 분해합
 */
public class Level11_2 {
    public static void main(String[] args) {
        int n = 216;

        //System.out.println((2167 / 1000) % 10);
        //System.out.println((2167 / 100) % 10);
        //System.out.println((2167 / 10) % 10);
        //System.out.println((2167 / 1) % 10);

        //n의 자릿수 구하기
        /*
        int length = (int)Math.log10(n) +1;
        int digitSum = 0;
        for(int i = length -1; i >= 0; i--) {
            int tenSquared = (int)Math.pow(10, i);
            digitSum += (n / tenSquared) % 10;
        }

        System.out.println("n : " + n + " , n의 각 자리 합 : " + digitSum);
        */

        int result = decomposition(n);
        System.out.println("result : " + result);
    }

    public static int decomposition(int n) {
        int result = 0;

        while (true) {
            int length = (int)Math.log10(n) +1; //n의 자릿수 ex) 216 = 3자리 / 1234 = 4
            int sum = result;   //어떤 수와 그 수의 각 자리 합
            for(int i = length -1; i >= 0; i--) {
                int tenSquared = (int)Math.pow(10, i);  //각 자릿수 값 구하기
                sum += (sum / tenSquared) % 10;
            }


            //어떤 수와 그 수의 각 자리 합이 n과 같을 때 어떤 수를 리턴한다.
            if(sum == n) {
                break;

            //생성자가 없는 경우 0 리턴한다.
            } else if (result > n) {
                result = 0;
                break;
            }

            result ++;
        }


        return result;
    }
}
