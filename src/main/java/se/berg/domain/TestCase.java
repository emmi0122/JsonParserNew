package se.berg.domain;

import java.util.*;

/**
 * Represents a signle test case consisting of a name and a list of test steps.
 * A {@code TestCase} defines a sequence of actions that form a logical test unit.
 */

public class TestCase {
    private String name;
    private final List<TestStep> steps;

    /**
     * Constructs a new {@code TestCase} with the given name and steps.
     * 
     * @param name the na,e of the test case
     * @param steps the list of steps, or {@code null} to create an empty test case.
     */

    public TestCase(String name, List<TestStep> steps) {
        this.name = name;
        this.steps = steps != null ? new ArrayList<>(steps) : new ArrayList<>();
    }

    /**
     * Returns the name of this test case.
     * 
     * @return the test case name
     */

    public String getName() {
        return name;
    }

    /**
     * Returns an unmodifiable view of all steps in this test case.
     * 
     * @return the list of test steps
     */

    public List<TestStep> getSteps() {
        return Collections.unmodifiableList(steps);
    }

    /**
     * Adds a single step to this test case.
     * 
     * @param step the test step to add
     */

    public void addStep(TestStep step) {
        this.steps.add(step);
    }

    /**
     * Returns the total number of steps in this test case
     * 
     * @return number of steps
     */

    public int getStepCount() {
        return steps.size();
    }

    /**
     * Returns a formatted string representation of the test case and its steps.
     * 
     * @return a formatted string
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