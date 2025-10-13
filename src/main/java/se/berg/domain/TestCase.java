package se.berg.domain;

import java.util.*;

/**
 * Represents a test case consisting of a name and a list of test steps.
 */
public class TestCase {
    private String name;
    private final List<TestStep> steps;

    /**
     * Constructs a new Test Case.
     * 
     * @param name  the name of the test case
     * @param steps the list of steps, or null for empty
     */
    public TestCase(String name, List<TestStep> steps) {
        this.name = name;
        this.steps = steps != null ? new ArrayList<>(steps) : new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    /**
     * @returnan an unmofifiable list of steps
     */
    public List<TestStep> getSteps() {
        return Collections.unmodifiableList(steps);
    }

    /**
     * @param step adds a single test step to this test case
     */
    public void addStep(TestStep step) {
        this.steps.add(step);
    }

    /**
     * @return number of steps
     */
    public int getStepCount() {
        return steps.size();
    }

    /**
     * @return a formatted string representation
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name).append("\n");
        for (TestStep step : steps) {
            sb.append("   ").append("   ").append(step);
        }

        return sb.toString();
    }
}