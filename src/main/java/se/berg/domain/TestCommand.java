package se.berg.domain;

import se.berg.util.MapperClass;

/**
 * Represents a command with all relevant parameters for a test step.
 */
public class TestCommand {
    private String cmdTypeName;
    private String action;
    private Integer targetAddress;
    private String constantName;
    private Integer constantValue;
    private String displayUnit;

    public TestCommand(String cmdTypeName, String action, Integer targetAddress,
                       String constantName, Integer constantValue, String displayUnit) {
        this.cmdTypeName = cmdTypeName;
        this.action = action;
        this.targetAddress = targetAddress;
        this.constantName = constantName;
        this.constantValue = constantValue;
        this.displayUnit = displayUnit;
    }

    public String getCmdTypeName() {
        return cmdTypeName;
    }

    public String getAction() {
        return action;
    }

    public Integer getTargetAddress() {
        return targetAddress;
    }

    public String getConstantName() {
        return constantName;
    }

    public Integer getConstantValue() {
        return constantValue;
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