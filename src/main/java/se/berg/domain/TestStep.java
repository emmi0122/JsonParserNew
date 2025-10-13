package se.berg.domain;

import se.berg.util.MapperClass;

/**
 * Represents a single step in a test case.
 * A {@code TestStep} defines a specific action or validation to perform,
 * including command type, parameters, and excpected results.
 */

public class TestStep {
    private String cmdTypeName;
    private String action;
    private String inOutId;
    private Integer value;
    private Integer targetAddress;
    private String buttonLabel;
    private String frameLabel;
    private String constantName;
    private Integer constantValue;
    private String indicatorLabel;
    private String expectedResultName;
    private String displayUnit;
    
    /**
     * Creates a new {@code TestStep} with the specified parameters.
     * 
     * @param cmdTypeName the command type name
     * @param action the action to perform
     * @param inOutId the input/output identifier
     * @param value the value to be used in the command
     * @param targetAddress the target address for the command
     * @param buttonLabel the label of a button, if applicable
     * @param frameLabel the label of a frame, if applicable
     * @param constantname the name of a constant, if applicable
     * @param constantValue the value of a constant, if applicable
     * @param indicatorLabel the label of an indicator, if applicable
     * @param expectedResultName the expected result name, if any
     * @param displayUnit the name of unit, if any
     */

    public TestStep(String cmdTypeName, String action, String inOutId, Integer value, Integer targetAddress,
            String buttonLabel, String frameLabel, String constantname, Integer constantValue,
            String indicatorLabel, String expectedResultName, String displayUnit) {
        this.cmdTypeName = cmdTypeName;
        this.action = action;
        this.inOutId = inOutId;
        this.value = value;
        this.targetAddress = targetAddress;
        this.buttonLabel = buttonLabel;
        this.frameLabel = frameLabel;
        this.constantName = constantname;
        this.constantValue = constantValue;
        this.indicatorLabel = indicatorLabel;
        this.expectedResultName = expectedResultName;
        this.displayUnit = displayUnit;
    }

    //Getters with concise docs

    /** @return the command type name */ public String getCmdTypeName() { return cmdTypeName; }
    /** @return the action to perform */ public String getAction() { return action; }
    /** @return the input/output identifier */ public String getInOutId() { return inOutId; }
    /** @return the command value */ public Integer getValue() { return value; }
    /** @return the target address */ public Integer getTargetAddress() { return targetAddress; }
    /** @return the button label */ public String getButtonLabel() { return buttonLabel; }
    /** @return the frame label */ public String getFrameLabel() { return frameLabel; }
    /** @return the constant name */ public String getConstantName() { return constantName; }
    /** @return the constant value */ public Integer getConstantValue() { return constantValue; }
    /** @return the indicator label */ public String getIndicatorLabel() { return indicatorLabel; }
    /** @return the expected result name */ public String getExpectedResultName() { return expectedResultName; }
    /** @return the expected display name */ public String getDIsplayunit() { return displayUnit; }

    /**
     * Returns a human-readable version of the action using {@link MapperClass#mapAction(String)}
     * 
     * @return a formatted action name
     */

    public String getFormattedAction() {
        return MapperClass.mapAction(action);
    }

    /**
     * Returns a formatted version of the I/O identifier, splitting camel case
     * 
     * @return a formatted InOutId string
     */

    public String getFormattedInOutId() {
        if (inOutId == null || inOutId.isEmpty()) {
            return "";
        }

        String result = inOutId.replaceAll("([a-z])([A-Z])", "$1 $2");
        return result;
    }

    /**
     * Returns a readable name for the target address using {@link MapperClass#mapTargetAddress(Integer)}
     * 
     * @return a mapped target address name
     */

    public String getTargetAddressName() {
        return MapperClass.mapTargetAddress(targetAddress);
    }

    /**
     * Returns a human-readable description of the command type using {@link MapperClass#mapCmdType(String)}
     * 
     * @return a mapped command type description
     */

    public String getCmdTypeDescription() {
        return MapperClass.mapCmdType(cmdTypeName);
    }

    /**
     * Returns a formatted string representation describing this test step and its parameters.
     * 
     * @return a human-readable representation of the test step
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if ("SelectButton".equals(action)) {
            sb.append("Select GUI button");
            if (buttonLabel != null && !buttonLabel.isEmpty()) sb.append(" ").append(buttonLabel);
            if (frameLabel != null && !frameLabel.isEmpty()) sb.append(" in frame ").append(frameLabel);
            if (targetAddress != null) sb.append(" at ").append(getTargetAddressName());
            return sb.append("\n").toString();
        }

        if ("TextIndicatorColor".equals(action)) {
            sb.append("Check that text indicator ");
            if (indicatorLabel != null && !indicatorLabel.isEmpty()) sb.append(indicatorLabel).append(" ");
            if (frameLabel != null && !frameLabel.isEmpty()) sb.append("in frame ").append(frameLabel).append(" ");
            sb.append("is ");
            if (expectedResultName != null && !expectedResultName.isEmpty()) sb.append(expectedResultName).append(" ");
            if (targetAddress != null) sb.append("at ").append(getTargetAddressName());
            return sb.append("\n").toString();
        }

        if (constantName != null) sb.append("Set Constant ").append(constantName).append(" ");
        if (constantValue != null) sb.append("== ").append(constantValue).append(" ");
        if (getCmdTypeDescription() != null) sb.append(getCmdTypeDescription()).append(" ");
        if (action != null && !action.isEmpty()) sb.append(getFormattedAction()).append(" ");
        if (inOutId != null && !inOutId.isEmpty()) sb.append(getFormattedInOutId()).append(" ");
        if (value != null) sb.append("= ").append(value).append(" ");
        if (targetAddress != null) sb.append("at ").append(getTargetAddressName());
        return sb.append("\n").toString();
    }
}