package se.berg.domain;

import java.util.*;

public class TestCase {
    private String name;
    private final List<TestStep> steps;

    public TestCase(String name, List<TestStep> steps) {
        this.name = name;
        this.steps = steps != null ? new ArrayList<>(steps) : new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<TestStep> getSteps() {
        return Collections.unmodifiableList(steps);
    }

    public void addStep(TestStep step) {
        this.steps.add(step);
    }

    public int getStepCount() {
        return steps.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name).append("\n");
        for (TestStep step : steps) {
            sb.append("   ").append("   ").append(step);
        }

        return sb.toString();
    }
}