package stepic.algorithmsdatastructures.tools;

import java.util.Random;

/**
 * Generator of random strings containing character 'a'...'z'.
 */
public class RandomStringGenerator {
    private static final int DEFAULT_MAX_LENGTH = 100;
    private static final char STARTING_CHAR = 'a';
    private static final char ENDING_CHAR = 'z';
    private static final int NUM_LETTERS = ENDING_CHAR - STARTING_CHAR + 1;
    
    private Random rnd = new Random();
    private int maxLength;
    
    public RandomStringGenerator() {
        this(DEFAULT_MAX_LENGTH);
    }
    
    public RandomStringGenerator(int maxLength) {
        this.maxLength = maxLength;
    }
    
    public String next() {
        int length = rnd.nextInt(maxLength) + 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append((char)(STARTING_CHAR + rnd.nextInt(NUM_LETTERS)));
        }
        return sb.toString();
    }
}