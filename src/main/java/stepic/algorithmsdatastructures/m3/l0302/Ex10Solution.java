package stepic.algorithmsdatastructures.m3.l0302;

public class Ex10Solution {

    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);

        int n = in.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = in.nextInt();
        }
        int k = in.nextInt();
        in.close();
        
        sortAndPrint(values, k);
    }

    static void sortAndPrint(int[] data, int numSubArrays) {
        KPathPointerHeap heap = new KPathPointerHeap(numSubArrays);
        
        int[] nextIndexes = new int[numSubArrays];
        KPathPointer p;
        for (int i = 0; i < numSubArrays; i++) {
            p = createPointer(data, numSubArrays, i, 0);
            heap.add(p);
            nextIndexes[i] = 1;
        }
        
        KPathPointer min;
        int nextValueIdx;
        for (int j = 0; j < data.length; j++) {
            min = heap.getMin();
            System.out.print(min.getValue() + " ");
            
            nextValueIdx = min.getSubArrayValueIndex() + 1;
            p = createPointer(data, numSubArrays, min.getSubArrayIndex(), nextValueIdx);
            if (p.isValid()) {
                heap.add(p);
            }
        }
    }

    private static KPathPointer createPointer(int[] data, int numSubArrays, int arrayIdx, int valueIdx) {
        return new SubArrayValuePointer(data, numSubArrays, arrayIdx, valueIdx);
        
    }
}
