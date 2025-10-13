package se.berg.domain;

import java.util.*;

/**
 * Represents a sequence of test cases grouped under a common name.
 */
public class TestSequence {
    private String name;
    private final List<TestCase> testCases;

    /**
     * Creates a new TestSequence.
     * 
     * @param name      the name of the test sequence
     * @param testCases the list of test cases, or null for empty
     */
    public TestSequence(String name, List<TestCase> testCases) {
        this.name = name;
        this.testCases = testCases != null ? new ArrayList<>(testCases) : new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    /**
     * @return an unmodifiable view of all test cases
     */
    public List<TestCase> getTestCases() {
        return Collections.unmodifiableList(testCases);
    }

    /**
     * Created a new TestSequence with default name.
     * }
     * 
     * @param testCases the list of test cases
     */
    public TestSequence(List<TestCase> testCases) {
        this("Test Sequence", testCases);
    }

    /**
     * Created an empty TestSequence with the given name
     * 
     * @param name the name of the test sequence
     */
    public TestSequence(String name) {
        this(name, null);
    }

    public void addTestCase(TestCase testCase) {
        this.testCases.add(testCase);
    }

    /**
     * @return a formatted string representation
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name).append("\n");
        for (TestCase testCase : testCases) {
            sb.append("   ").append(testCase).append("\n");
        }

        return sb.toString();
    }
}