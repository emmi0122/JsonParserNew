package se.berg.domain;

import java.util.*;

/**
 * Represents a sequence of test cases grouped under a common name.
 * A {@code TestSequence} can contain one or more {@link TestCase} objects.
 */

public class TestSequence {
    private String name;
    private final List<TestCase> testCases;

    /**
     * Creates a new {@code TestSequence} with the specified name and test cases.
     * 
     * @param name the name of the test sequence
     * @param testCases the list of test cases, or {@code null} for an empty sequence
     */

    public TestSequence(String name, List<TestCase> testCases) {
        this.name = name;
        this.testCases = testCases != null ? new ArrayList<>(testCases) : new ArrayList<>();
    }

    /**
     * Created a new {@code TestSequence with default name.
     * }
     * @param testCases the list of test cases
     */

    public TestSequence(List<TestCase> testCases) {
        this("Test Sequence", testCases);
    }

    /**
     * Created an empty {@code TestSequence} with the given name
     * 
     * @param name the name of the test sequence
     */

    public TestSequence(String name) {
        this(name, null);
    }

    /**
     * Returns the name of this test sequence.
     * 
     * @return the name
     */

    public String getName() {
        return name;
    }

    /**
     * Returns an unmodifiable view of all test cases in this sequence.
     * 
     * @return the list of test cases
     */

    public List<TestCase> getTestCases() {
        return Collections.unmodifiableList(testCases);
    }

    /**
     * Adds a single test case to the sequence
     * 
     * @param testCase test case to add
     */

    public void addTestCase(TestCase testCase) {
        this.testCases.add(testCase);
    }

    /**
     * Returns a formatted string representation of the test sequence and its test cases.
     * 
     * @return a formatted string
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