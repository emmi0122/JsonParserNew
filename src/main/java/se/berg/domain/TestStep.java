package se.berg.domain;

import se.berg.util.MapperClass;

public class TestStep {
    private String cmdTypeName;
    private String action;
    private String inOutId;
    private Integer value;
    private Integer targetAddress;

    public TestStep(String cmdTypeName, String action, String inOutId, Integer value, Integer targetAddress) {
        this.cmdTypeName = cmdTypeName;
        this.action = action;
        this.inOutId = inOutId;
        this.value = value;
        this.targetAddress = targetAddress;
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

        String cmdDesc = getCmdTypeDescription();
        if (!cmdDesc.isEmpty()) {
            sb.append(cmdDesc).append(" ");
        }

        if (action != null && !action.isEmpty()) {
            sb.append(getFormattedAction()).append(" ");
        }

        if (inOutId != null && !inOutId.isEmpty()) {
            sb.append(getFormattedInOutId()).append(" ");
        }

        if (value != null) {
            sb.append("= ").append(value).append(" ");
        }

        if (targetAddress != null) {
            sb.append("at ").append(getTargetAddressName());
        }

        sb.append("\n");
        return sb.toString();
    }
}