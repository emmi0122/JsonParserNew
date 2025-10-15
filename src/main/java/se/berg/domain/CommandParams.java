package se.berg.domain;

public class CommandParams {
    private String inOutId;
    private Integer value;
    private String buttonLabel;
    private String frameLabel;
    private String indicatorLabel;

    public CommandParams(String inOutId, Integer value, String buttonLabel, String frameLabel, String indicatorLabel) {
        this.inOutId = inOutId;
        this.value = value;
        this.buttonLabel = buttonLabel;
        this.frameLabel = frameLabel;
        this.indicatorLabel = indicatorLabel;
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
}