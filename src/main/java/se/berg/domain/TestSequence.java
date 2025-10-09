package se.berg.domain;

import java.util.*;

public class TestSequence {
    private String name;
    private final List<TestCase> testCases;

    public TestSequence(String name, List<TestCase> testCases) {
        this.name = name;
        this.testCases = testCases != null ? new ArrayList<>(testCases) : new ArrayList<>();
    }

    public TestSequence(List<TestCase> testCases) {
        this("Test Sequence", testCases);
    }

    public TestSequence(String name) {
        this(name, null);
    }

    public String getName() {
        return name;
    }

    public List<TestCase> getTestCases() {
        return Collections.unmodifiableList(testCases);
    }

    public void addTestCase(TestCase testCase) {
        this.testCases.add(testCase);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name).append("\n");
        for (TestCase testCase : testCases) {
            sb.append("   ").append(testCase).append("\n");
        }
        
        return sb.toString();
    }
}