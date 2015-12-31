package stepic.algorithmsdatastructures.m1.l0103;

public class BinarySearch {
    /**
     * Searches for first occurrence of the element.
     */
    static int searchFirst(double[] arr, double element) {
        int first = 0;
        int last = arr.length; // element at index last is not used
        while (first < last) {
            int mid = first + (last - first) / 2;
            if (element <= arr[mid]) {
                last = mid;
            } else {
                first = mid + 1;
            }
        }
        // All elements to the left of first are less than element
        if (first == arr.length || arr[first] != element) {
            return -1;
        } else {
            return first;
        }
    }
    
    /**
     * Searches for any occurrence of the element.
     */
    static int searchAny(double[] arr, double element) {
        int lo = 0;
        int hi = arr.length - 1;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (arr[mid] == element) {
                return mid;
            } else if (element < arr[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }

}
