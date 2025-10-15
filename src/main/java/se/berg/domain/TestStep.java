package se.berg.domain;

import se.berg.util.MapperClass;

/**
 * Represents a single step in a test case.
 * A TestStep contains a command and an expected result.
 */
public class TestStep {
    private TestCommand command;
    private ExpectedResult expectedResult;
    private CommandParams commandParams;

    /**
     * Constructs a TestStep
     * 
     * @param command        the command details for this step
     * @param expectedResult the expected result description
     */
    public TestStep(TestCommand command, ExpectedResult expectedResult, CommandParams commandParams) {
        this.command = command;
        this.expectedResult = expectedResult;
        this.commandParams = commandParams;
    }

    public TestCommand getCommand() {
        return command;
    }

    public ExpectedResult getExpectedResult() {
        return expectedResult;
    }

    public CommandParams getCommandParams() {
        return commandParams;
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
        Integer targetAddress = command.getTargetAddress();
        String constantName = command.getConstantName();
        Integer constantValue = command.getConstantValue();
        String cmdTypeDescription = MapperClass.mapCmdType(command.getCmdTypeName());
        String displayUnit = command.getDisplayUnit();

        String expectedResultName = expectedResult.getName();
        Integer expectedResultMin = expectedResult.getMin();
        Integer expectedResultMax = expectedResult.getMax();

        String inOutId = commandParams.getInOutId();
        Integer value = commandParams.getValue();
        String indicatorLabel = commandParams.getIndicatorLabel();
        String buttonLabel = commandParams.getButtonLabel();
        String frameLabel = commandParams.getFrameLabel();
        String esmTypeName = commandParams.getEsmTypeName();
        String branchName = commandParams.getBranchName();
        String engineType = commandParams.getEngineType();

        // Special case for ESMActivation
        if ("ESMActivation".equals(action)) {
            if (esmTypeName != null && !esmTypeName.isEmpty()) {
                String stateText = commandParams.isEsmState() ? "Start " : "Stop ";
                sb.append(stateText).append(MapperClass.splitCamelCase(esmTypeName)).append(" (").append(engineType).append(")");
            }
            return sb.append("\n").toString();
        }

        //Special case for cable break/heal
        if ("CableBreak".equals(action)) {
            if (branchName != null && !branchName.isEmpty()) {
                String stateText = commandParams.isCableStatus() ? "Heal " : "Break ";
                sb.append(stateText).append("com bus ").append(branchName);
            }
            return sb.append("\n").toString();
        }

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

        // Special case for text indicators
        if ("TextIndicatorColor".equals(action)) {
            sb.append("Check that text indicator ");
            if (indicatorLabel != null && !indicatorLabel.isEmpty()) {
                sb.append(indicatorLabel).append(" ").append("exists, AND is ");
            }
            if (expectedResultName != null && !expectedResultName.isEmpty()) {
                sb.append(expectedResultName).append(", ");
            }
            if (frameLabel != null && !frameLabel.isEmpty()) {
                sb.append("in frame ").append(frameLabel).append(" ");
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