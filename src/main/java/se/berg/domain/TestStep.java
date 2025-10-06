package se.berg.domain;

public class TestStep {
    private String type;
    private String cmdTypeName;
    private String action;
    private String inOutId;
    private Integer value;

    // Enkel konstruktor (för kompatibilitet med befintlig kod)
    public TestStep(String type) {
        this.type = type;
    }

    // Konstruktor utan value (när value är optional)
    public TestStep(String type, String cmdTypeName, String action, String inOutId) {
        this.type = type;
        this.cmdTypeName = cmdTypeName;
        this.action = action;
        this.inOutId = inOutId;
        this.value = null;
    }

    // Fullständig konstruktor för TestStepStimuli
    public TestStep(String type, String cmdTypeName, String action, String inOutId, Integer value) {
        this.type = type;
        this.cmdTypeName = cmdTypeName;
        this.action = action;
        this.inOutId = inOutId;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCmdTypeName() {
        return cmdTypeName;
    }

    public void setCmdTypeName(String cmdTypeName) {
        this.cmdTypeName = cmdTypeName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getInOutId() {
        return inOutId;
    }

    public void setInOutId(String inOutId) {
        this.inOutId = inOutId;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public boolean hasValue() {
        return value != null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TestStep[type=").append(type);
        
        if (cmdTypeName != null) {
            sb.append(", cmdType=").append(cmdTypeName);
        }
        if (action != null) {
            sb.append(", action=").append(action);
        }
        if (inOutId != null) {
            sb.append(", inOutId=").append(inOutId);
        }
        if (value != null) {
            sb.append(", value=").append(value);
        }
        
        sb.append("]");
        return sb.toString();
    }
}