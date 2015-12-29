package stepic.algorithmsdatastructures.m1.l0102;

import java.util.Scanner;

public class Primary {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = in.nextInt();
        System.out.printf("%d is primary: %s%n", n, isPrimary(n));
        in.close();
        
//        for (int i = 1; i <= 17; i++) {
//            System.out.printf("%2d %s%n", i, Boolean.toString(isPrimary(i)));
//        }
    }

    private static boolean isPrimary(int n) {
        if (n == 1) {
            return false;
        }
        for (int d = 2; d * d <= n; d++) {
            if (n % d == 0) {
                return false;
            }
        }
        return true;
    }
}
