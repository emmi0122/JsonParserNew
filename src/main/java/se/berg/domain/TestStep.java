package se.berg.domain;

public class TestStep {
    //private String type;
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

    @Override
    public String toString() {
        return //"\n  TestStep {\n}" +
               "    cmdTypeName = " + cmdTypeName + "\n" +
               "    action = " + action + " \n" +
               "    inOutId = " + inOutId + " \n" +
               "    value = " + value + "\n" +
               "    target_address = " + targetAddress + "\n";
               //"    }";
    }
}