package stepic.algorithmsdatastructures.m1.l0102;

public class FibonacciRecursive {
    private int count = 0;

    public static void main(String[] args) {
        printFibonacci(10);
    }

    private int fibRecursive(int n) {
        count++;
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return fibRecursive(n - 2) + fibRecursive(n - 1);
        }
    }
    
    private int getCount() { return count; }
    
    private static void printFibonacci(int n) {
        for (int i = 1; i <= n; i++) {
            FibonacciRecursive fibCalculator = new FibonacciRecursive();
            System.out.printf("%3d : %d calls%n", fibCalculator.fibRecursive(i), fibCalculator.getCount());
        }
    }
}
