/*
    Выведите разложение натурального числа n > 1 на простые множители. 
    Простые множители должны быть упорядочены по возрастанию и разделены пробелами.
    Sample Input:
    75
    Sample Output:
    3 5 5 
 */
package stepic.algorithmsdatastructures.m1.l0102;

public class Ex01Factorization {

    private static final int INTEGER_OVERFLOW_FLAG = -1;

    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        int num = in.nextInt();
        factorization(num);
        in.close();
    }
    
    static void factorization(int num){
        int denominator = 2;
        while(denominator <= num){
            if(num % denominator == 0){
                num = num / denominator;
                System.out.print(denominator + " ");
            }else{
                denominator++;
            }
        }
    }
    
    static void factorization2(int number) {
        int primaryDenominator = 2;
        while (number > 0) {
            int r = number / primaryDenominator;
            if (number % primaryDenominator == 0) {
                System.out.print(primaryDenominator + " ");
                number = r;
                if (r == 1) {
                    break;
                }
            } else {
                while (primaryDenominator > 0) {
                    primaryDenominator++;
                    int pd = 2;
                    int pm = -1;
                    while (pd * pd <= primaryDenominator) {
                        pm = primaryDenominator % pd;
                        if (pm == 0) {
                            break; // not primary
                        }
                        pd++;
                    }
                    if (pm != 0) {  // primary
                        break;
                    }
                }
            }
        }
        System.out.println();
    }

    static void factorization1(int a) {
        int d = 2;
        while (a > 0) {
            int r = a / d;
            int m = a % d;
            if (m == 0) {
                System.out.print(d + " ");
                a = r;
                if (r == 1) {
                    break;
                }
            } else {
                d = nextPrimary(d);
                if (d == INTEGER_OVERFLOW_FLAG) {
                    break;
                }
            }
        }
        System.out.println();
    }

    private static int nextPrimary(int d) {
        while (d > 0) {
            if (isPrimary(++d)) {
                return d;
            }
        }
        return INTEGER_OVERFLOW_FLAG;
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
