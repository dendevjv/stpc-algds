package stepic.algorithmsdatastructures.m3.l0302;

public interface KPathPointer extends Comparable<KPathPointer> {
    int getSubArrayIndex();
    int getSubArrayValueIndex();
    int getRealIndex();
    int getValue();
    boolean isValid();
}
