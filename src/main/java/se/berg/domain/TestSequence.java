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

    public void setName(String name) {
        this.name = name;
    }

    public List<TestCase> getTestCases() {
        return new ArrayList<>(testCases);
    }

    public void setTestCases(List<TestCase> testCases) {
        this.testCases = testCases != null ? new ArrayList<>(testCases) : new ArrayList<>();
    }

    public void addTestCase(TestCase testCase) {
        this.testCases.add(testCase);
    }

    public int getTestCaseCount() {
        return testCases.size();
    }

    public int getTotalStepCount() {
        int total = 0;
        for (TestCase tc : testCases) {
            total += tc.getStepCount();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TestSequence: ").append(name).append("\n");
        sb.append("Test Cases (").append(testCases.size()).append("):\n");
        for (int i = 0; i < testCases.size(); i++) {
            sb.append("\n").append(i + 1).append(". ").append(testCases.get(i).toString());
        }
        return sb.toString();
    }
}