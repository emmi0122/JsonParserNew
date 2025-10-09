package se.berg.domain;

import se.berg.util.MapperClass;

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

    public TestStep(String cmdTypeName, String action, String inOutId, Integer value, Integer targetAddress,
            String buttonLabel, String frameLabel, String constantname, Integer constantValue,
            String indicatorLabel, String expectedResultName) {
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
    }

    public String getCmdTypeName() {
        return cmdTypeName;
    }

    public String getAction() {
        return action;
    }

    public String getInOutId() {
        return inOutId;
    }

    public Integer getValue() {
        return value;
    }

    public Integer getTargetAddress() {
        return targetAddress;
    }

    public String getButtonLabel() {
        return buttonLabel;
    }

    public String getFrameLabel() {
        return frameLabel;
    }

    public String getConstantName() {
        return constantName;
    }

    public Integer getConstantValue() {
        return constantValue;
    }

    public String getIndicatorLabel() {
        return indicatorLabel;
    }

    public String getExpectedResultName() {
        return expectedResultName;
    }

    public String getFormattedAction() {
        return MapperClass.mapAction(action);
    }

    public String getFormattedInOutId() {
        if (inOutId == null || inOutId.isEmpty()) {
            return "";
        }

        String result = inOutId.replaceAll("([a-z])([A-Z])", "$1 $2");
        return result;
    }

    public String getTargetAddressName() {
        return MapperClass.mapTargetAddress(targetAddress);
    }

    public String getCmdTypeDescription() {
        return MapperClass.mapCmdType(cmdTypeName);
    }

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