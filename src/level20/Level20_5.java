package level20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Level20_5 {

    public static final long P = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        long n = Long.parseLong(stringTokenizer.nextToken());
        long k = Long.parseLong(stringTokenizer.nextToken());

        long numerator = factorial(n);
        long denominator = factorial(k) * factorial(n - k) % P;

        System.out.println(numerator * pow(denominator, P-2) % P);
    }

    public static long factorial(long n) {
        long result = 1;

        for(int i=2; i<=n; i++) {
            result = result * i;
        }

        return result;
    }

    //base^expo
    public static long pow(long base, long expo) {
        //expo == 1 이면 base^expo = base^1 = base
        if(expo == 1) {
            return base % P;
        }

        long temp = pow(base, expo / 2);

        if(expo % 2 == 1) {
            return (temp * temp % P) * base % P;
        }

        return temp * temp % P;
    }

}
