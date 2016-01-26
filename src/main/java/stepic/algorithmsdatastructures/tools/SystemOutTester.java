package stepic.algorithmsdatastructures.tools;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SystemOutTester implements AutoCloseable {
    private ByteArrayOutputStream buffer;
    private PrintStream savedOut;
    
    public SystemOutTester() {
        buffer = new ByteArrayOutputStream();
        savedOut = System.out;
        System.setOut(new PrintStream(buffer));
    }
    
    public String getOutput() {
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        System.setOut(savedOut);
    }
    
}
