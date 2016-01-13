package stepic.algorithmsdatastructures.tools;

public class ArrayTester {
    public static boolean isNonDecreasing(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                return false;
            }
        }
        return true;
    }
}
