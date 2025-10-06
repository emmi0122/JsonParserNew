package se.berg.domain;

import java.util.ArrayList;
import java.util.List;

public class TestCase {
    private String name;
    private List<TestStep> steps;

    public TestCase(String name, List<TestStep> steps) {
        this.name = name;
        this.steps = steps != null ? new ArrayList<>(steps) : new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TestStep> getSteps() {
        return new ArrayList<>(steps);
    }

    public void setSteps(List<TestStep> steps) {
        this.steps = steps != null ? new ArrayList<>(steps) : new ArrayList<>();
    }

    public void addStep(TestStep step) {
        this.steps.add(step);
    }

    public int getStepCount() {
        return steps.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //sb.append("\n  TestCase {\n");
        sb.append("    name = ").append(name).append("\n");
        //sb.append("    steps=[");
        for (TestStep step : steps) {
            sb.append(step.toString()).append("\n");
        }
        //sb.append("    ]\n");
        //sb.append("  }");
        return sb.toString();
    }
}