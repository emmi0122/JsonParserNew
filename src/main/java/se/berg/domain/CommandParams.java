package se.berg.domain;

public class CommandParams {
    private String inOutId;
    private Integer value;
    private String buttonLabel;
    private String frameLabel;
    private String indicatorLabel;
    private String esmTypeName;
    private boolean esmState;

    public CommandParams(String inOutId, Integer value, String buttonLabel, String frameLabel, String indicatorLabel, String esmTypeName, boolean esmState) {
        this.inOutId = inOutId;
        this.value = value;
        this.buttonLabel = buttonLabel;
        this.frameLabel = frameLabel;
        this.indicatorLabel = indicatorLabel;
        this.esmTypeName = esmTypeName;
        this.esmState = esmState;
    }

    public String getInOutId() {
        return inOutId;
    }

    public Integer getValue() {
        return value;
    }

    public String getButtonLabel() {
        return buttonLabel;
    }

    public String getFrameLabel() {
        return frameLabel;
    }

    public String getIndicatorLabel() {
        return indicatorLabel;
    }

    public String getEsmTypeName() {
        return esmTypeName;
    }

    public boolean getEsmState() {
        return esmState;
    }
}