package stepic.algorithmsdatastructures.m3.l0302;

class SubArrayValuePointer implements KPathPointer {
    private int[] data;
    private int numSubArrays;
    private int subArrayIndex;
    private int subArrayValueIndex;
    
    SubArrayValuePointer(int[] data, int numSubArrays, int subArrayIndex, int subArrayValueIndex) {
        this.data = data;
        this.numSubArrays = numSubArrays;
        this.subArrayIndex = subArrayIndex;
        this.subArrayValueIndex = subArrayValueIndex;
    }

    @Override
    public int compareTo(KPathPointer o) {
        return Integer.compare(getValue(), o.getValue());
    }

    @Override
    public int getSubArrayIndex() {
        return subArrayIndex;
    }

    @Override
    public int getSubArrayValueIndex() {
        return subArrayValueIndex;
    }

    @Override
    public int getValue() {
        return data[getRealIndex()];
    }

    @Override
    public boolean isValid() {
        int last = data.length / numSubArrays * numSubArrays  + subArrayIndex; 
        if (last >= data.length) {
            last -= numSubArrays;
        }
        return getRealIndex() <= last;
    }

    @Override
    public int getRealIndex() {
        return subArrayValueIndex * numSubArrays + subArrayIndex;
    }
    
}