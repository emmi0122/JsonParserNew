package se.berg.domain;

import se.berg.util.MapperClass;

/**
 * Represents a command with all relevant parameters for a test step.
 */
public class TestCommand {
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
    private String displayUnit;

    public TestCommand(String cmdTypeName, String action, String inOutId, Integer value,
            Integer targetAddress, String buttonLabel, String frameLabel,
            String constantName, Integer constantValue, String indicatorLabel, String displayUnit) {
        this.cmdTypeName = cmdTypeName;
        this.action = action;
        this.inOutId = inOutId;
        this.value = value;
        this.targetAddress = targetAddress;
        this.buttonLabel = buttonLabel;
        this.frameLabel = frameLabel;
        this.constantName = constantName;
        this.constantValue = constantValue;
        this.indicatorLabel = indicatorLabel;
        this.displayUnit = displayUnit;
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

    public String getDisplayUnit() {
        return displayUnit;
    }

    /**
     * Returns a human-readable version of the action using
     * {@link MapperClass#mapAction(String)}
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
     * Returns a readable name for the target address using
     * {@link MapperClass#mapTargetAddress(Integer)}
     * 
     * @return a mapped target address name
     */
    public String getTargetAddressName() {
        return MapperClass.mapTargetAddress(targetAddress);
    }

    /**
     * Returns a human-readable description of the command type using
     * {@link MapperClass#mapCmdType(String)}
     * 
     * @return a mapped command type description
     */
    public String getCmdTypeDescription() {
        return MapperClass.mapCmdType(cmdTypeName);
    }
}