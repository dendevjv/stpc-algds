/* Быстрое возведение в степень. */
package stepic.algorithmsdatastructures.m1.l0102;

import java.util.Scanner;

public class QuickPower {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Enter number and power: ");
            int a = in.nextInt();
            int n = in.nextInt();
            if (a < 0 || n < 0) {
                break;
            }
            int r = pow(a, n);
            System.out.printf("%d ^ %d = %d%n", a, n, r);
        } while (true);
        in.close();
    }
    
    /**
     * Raise number to the specified power.
     * @param a number
     * @param n power (non-negative)
     * @return
     */
    private static int pow(int a, int n) {
        int result = 1;
        int aInDegreeOfTwo = a;
        while (n > 0) {
            if ((n & 1) == 1) {
                result *= aInDegreeOfTwo;
            }
            n >>= 1;
            aInDegreeOfTwo *= aInDegreeOfTwo;
        }
        return result;
    }

}
