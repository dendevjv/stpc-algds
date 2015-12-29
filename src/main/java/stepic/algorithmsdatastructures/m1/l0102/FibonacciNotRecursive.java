package stepic.algorithmsdatastructures.m1.l0102;

public class FibonacciNotRecursive {

    public static void main(String[] args) {
        printFibonacci(10);
    }
    
    private static void printFibonacci(int n) {
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(fibNonRecursive(i));
        }
        System.out.println();
    }

    private static int fibNonRecursive(int n) {
        if (n == 0) {
            return 1;
        }
        int prev = 1;
        int current = 1;
        for (int i = 2; i <= n; i++) {
            current = current + prev;
            prev = current - prev;
        }
        return current;
    }
}
