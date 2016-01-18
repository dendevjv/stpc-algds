package stepic.algorithmsdatastructures.m3.l0302;

public class Ex10CodeForStepic {

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
        KPHeap heap = new KPHeap(numSubArrays);
        
        int[] nextIndexes = new int[numSubArrays];
        KPPointer p;
        for (int i = 0; i < numSubArrays; i++) {
            p = createPointer(data, numSubArrays, i, 0);
            heap.add(p);
            nextIndexes[i] = 1;
        }
        
        KPPointer min;
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

    private static KPPointer createPointer(int[] data, int numSubArrays, int arrayIdx, int valueIdx) {
        return new KPPointer(data, numSubArrays, arrayIdx, valueIdx);
        
    }
    
    private static class KPHeap {
        private int size;
        private KPPointer[] pointers;
        
        public KPHeap(int capacity) {
            pointers = new KPPointer[capacity];
            size = 0;
        }
        
        public KPPointer getMin() {
            KPPointer min = pointers[0];
            
            // move last to top
            int last = size - 1;
            if (last > 0) {
                pointers[0] = pointers[last];
                siftDown(0);
            }
            size--;
            
            return min;
        }

        public void add(KPPointer p) {
            if (size == pointers.length) {
                throw new IllegalStateException("This instance of pointer heap is full, cannot add any pointers");
            }
            
            pointers[size] = p;
            size++;
            siftUp(size - 1);
        }

        private void siftDown(int i) {
            int left = i * 2 + 1;
            if (left < size) {
                int lesser = left;
                int right = i * 2 + 2;
                if (right < size) {
                    if (pointers[right].compareTo(pointers[left]) < 0) {
                        lesser = right;
                    }
                }
                if (pointers[i].compareTo(pointers[lesser]) > 0) {
                    swap(i, lesser);
                    siftDown(lesser);
                }
            }
        }
        
        private void swap(int i, int j) {
            KPPointer tmp = pointers[j];
            pointers[j] = pointers[i];
            pointers[i] = tmp;
        }

        private void siftUp(int i) {
            int p = (i - 1) / 2;
            if (p >= 0) {
                if (pointers[p].compareTo(pointers[i]) > 0) {
                    swap(p, i);
                    if (p > 0) {
                        siftUp(p);
                    }
                }
            }
        }
    }
    
    private static class KPPointer implements Comparable<KPPointer>{
        private int[] data;
        private int numSubArrays;
        private int subArrayIndex;
        private int subArrayValueIndex;
        
        KPPointer(int[] data, int numSubArrays, int subArrayIndex, int subArrayValueIndex) {
            this.data = data;
            this.numSubArrays = numSubArrays;
            this.subArrayIndex = subArrayIndex;
            this.subArrayValueIndex = subArrayValueIndex;
        }

        @Override
        public int compareTo(KPPointer o) {
            return Integer.compare(getValue(), o.getValue());
        }

        public int getSubArrayIndex() {
            return subArrayIndex;
        }

        public int getSubArrayValueIndex() {
            return subArrayValueIndex;
        }

        public int getValue() {
            return data[getRealIndex()];
        }

        public boolean isValid() {
            int last = data.length / numSubArrays * numSubArrays  + subArrayIndex; 
            if (last >= data.length) {
                last -= numSubArrays;
            }
            return getRealIndex() <= last;
        }

        public int getRealIndex() {
            return subArrayValueIndex * numSubArrays + subArrayIndex;
        }
        
    }
}
