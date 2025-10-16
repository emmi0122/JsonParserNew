package se.berg.domain;

public class CommandParams {
    private String inOutId;
    private Integer value;
    private String buttonLabel;
    private String frameLabel;
    private String indicatorLabel;
    private String esmTypeName;
    private boolean esmState;
    private boolean cableStatus;
    private String branchName;
    private String engineType;
    private Integer buttonOccurence;

    public CommandParams(String inOutId, Integer value, String buttonLabel, String frameLabel, String indicatorLabel,
            String esmTypeName, boolean esmState, boolean cableStatus, String branchname, String engineType,
            Integer buttonOccurence) {
        this.inOutId = inOutId;
        this.value = value;
        this.buttonLabel = buttonLabel;
        this.frameLabel = frameLabel;
        this.indicatorLabel = indicatorLabel;
        this.esmTypeName = esmTypeName;
        this.esmState = esmState;
        this.cableStatus = cableStatus;
        this.branchName = branchname;
        this.engineType = engineType;
        this.buttonOccurence = buttonOccurence;
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

    public boolean isEsmState() {
        return esmState;
    }

    public boolean isCableStatus() {
        return cableStatus;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getEngineType() {
        return engineType;
    }

    public Integer getButtonOccurence() {
        return buttonOccurence;
    }
}