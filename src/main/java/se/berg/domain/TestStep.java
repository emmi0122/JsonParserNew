package se.berg.domain;

import se.berg.util.MapperClass;

/**
 * Represents a single step in a test case.
 * A TestStep contains a command and an expected result.
 */
public class TestStep {
    private TestCommand command;
    private ExpectedResult expectedResult;

    /**
     * Constructs a TestStep
     * 
     * @param command        the command details for this step
     * @param expectedResult the expected result description
     */
    public TestStep(TestCommand command, ExpectedResult expectedResult) {
        this.command = command;
        this.expectedResult = expectedResult;
    }

    public TestCommand getCommand() {
        return command;
    }

    public ExpectedResult getExpectedResult() {
        return expectedResult;
    }

    /**
     * Returns a formatted string representation describing this test step and its
     * parameters.
     * 
     * @return a human-readable representation of the test step
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        String action = command.getAction();
        String buttonLabel = command.getButtonLabel();
        String frameLabel = command.getFrameLabel();
        Integer targetAddress = command.getTargetAddress();
        String indicatorLabel = command.getIndicatorLabel();
        String constantName = command.getConstantName();
        Integer constantValue = command.getConstantValue();
        String cmdTypeDescription = MapperClass.mapCmdType(command.getCmdTypeName());
        String inOutId = command.getInOutId();
        Integer value = command.getValue();
        String displayUnit = command.getDisplayUnit();

        String expectedResultName = expectedResult.getName();
        Integer expectedResultMin = expectedResult.getMin();
        Integer expectedResultMax = expectedResult.getMax();

        // Special case for selecting buttons
        if ("SelectButton".equals(action)) {
            sb.append("Select GUI button");
            if (buttonLabel != null && !buttonLabel.isEmpty()) {
                sb.append(" ").append(buttonLabel);
            }
            if (frameLabel != null && !frameLabel.isEmpty()) {
                sb.append(" in frame ").append(frameLabel);
            }
            if (targetAddress != null) {
                sb.append(" at ").append(MapperClass.mapTargetAddress(targetAddress));
                return sb.append("\n").toString();
            }
        }

        // Special case for text indivators
        if ("TextIndicatorColor".equals(action)) {
            sb.append("Check that text indicator ");
            if (indicatorLabel != null && !indicatorLabel.isEmpty()) {
                sb.append(indicatorLabel).append(" ");
            }
            if (frameLabel != null && !frameLabel.isEmpty()) {
                sb.append("in frame ").append(frameLabel).append(" ");
                sb.append("is ");
            }
            if (expectedResultName != null && !expectedResultName.isEmpty()) {
                sb.append(expectedResultName).append(" ");
            }
            if (targetAddress != null) {
                sb.append("at ").append(MapperClass.mapTargetAddress(targetAddress));
                return sb.append("\n").toString();
            }
        }

        // General format
        if (constantName != null) {
            sb.append("Set constant ").append(constantName).append(" ");
        }
        if (constantValue != null) {
            sb.append("== ").append(constantValue).append(" ");
        }
        if (action != null && !action.isEmpty()) {
            if (cmdTypeDescription != null) {
                sb.append(cmdTypeDescription).append(" ");
            }
            sb.append(MapperClass.mapAction(action)).append(" ");
        }
        if (inOutId != null && !inOutId.isEmpty()) {
            sb.append(MapperClass.splitCamelCase(inOutId)).append(" ");
        }

        if (expectedResultMin != null && expectedResultMax != null) {
            sb.append("is between ").append(expectedResultMin);
            if (displayUnit != null && !displayUnit.isEmpty()) {
                sb.append(displayUnit);
            }

            sb.append(" and ").append(expectedResultMax);
            if (displayUnit != null && !displayUnit.isEmpty()) {
                sb.append(displayUnit);
            }

            sb.append(" ");
        } else if (value != null) {
            sb.append("= ").append(value);
            if (displayUnit != null && !displayUnit.isEmpty()) {
                sb.append(displayUnit);
            }

            sb.append(" ");
        }

        if (targetAddress != null) {
            sb.append("at ").append(MapperClass.mapTargetAddress(targetAddress));
        }

        return sb.append("\n").toString();
    }
}