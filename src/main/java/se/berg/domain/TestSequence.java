package se.berg.domain;

import java.util.ArrayList;
import java.util.List;

public class TestSequence {
    private String name;
    private List<TestCase> testCases;

    // Konstruktor med namn och testfall
    public TestSequence(String name, List<TestCase> testCases) {
        this.name = name;
        this.testCases = testCases != null ? new ArrayList<>(testCases) : new ArrayList<>();
    }

    // Konstruktor med bara testfall (sätter default-namn)
    public TestSequence(List<TestCase> testCases) {
        this("Test Sequence", testCases);
    }

    // Konstruktor med bara namn
    public TestSequence(String name) {
        this.name = name;
        this.testCases = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<TestCase> getTestCases() {
        return new ArrayList<>(testCases);
    }

    public void addTestCase(TestCase testCase) {
        this.testCases.add(testCase);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("\n");
        for (TestCase testCase : testCases) {
            sb.append("    ").append(testCase.toString()).append("\n");
        }
        return sb.toString();

    }
}