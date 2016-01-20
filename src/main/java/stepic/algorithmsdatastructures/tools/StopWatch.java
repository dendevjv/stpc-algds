package stepic.algorithmsdatastructures.tools;

public class StopWatch {
    private long startTime;
    private long elapsedTime;
    
    public void start() {
        startTime = System.currentTimeMillis();
    }
    
    public long stop() {
        elapsedTime = System.currentTimeMillis() - startTime;
        return elapsedTime;
    }
    
    public long getElapsedTime() { return elapsedTime; }
}
