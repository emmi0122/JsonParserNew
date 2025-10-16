package se.berg.domain;

import se.berg.util.MapperClass;

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

    public String getFormattedAction() {
        return MapperClass.mapAction(action);
    }

    public String getTargetAddressName() {
        return MapperClass.mapTargetAddress(targetAddress);
    }

    public String getCmdTypeDescription() {
        return MapperClass.mapCmdType(cmdTypeName);
    }
}