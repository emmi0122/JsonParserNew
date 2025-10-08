package se.berg.domain;

import se.berg.util.MapperClass;

public class TestStep {
    // private String type;
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

    public String getFormattedInOutId() {
        if (inOutId == null || inOutId.isEmpty()) {
            return "";
        }

        String[] knownPrefixes = { "DigInPort", "AnalogInput", "Button", "TextIndicatorColor", "PWM", "SelectButton", "DigOutPort" };
        for (String prefix : knownPrefixes) {
            if (inOutId.startsWith(prefix)) {
                String rest = inOutId.substring(prefix.length());
                rest = rest.replaceAll("([a-z])([A-Z])", "$1 $2");
                return prefix + (rest.isEmpty() ? "" : " " + rest.trim());
            }
        }

        return inOutId.replaceAll("([a-z])([A-Z])", "$1 $2");
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

        sb.append(getCmdTypeDescription()).append(" ");

        if (action != null && !action.isEmpty()) {
            sb.append(action).append(" ");
        }

        if (inOutId != null) {
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