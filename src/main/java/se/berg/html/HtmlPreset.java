package se.berg.html;

public class HtmlPreset {
    private String generateHeader;

    public HtmlPreset(String generateHeader) {
        this.generateHeader = generateHeader;
    }

    public static String getGenerateHeader() {
        return """
                <div class="header">
                    <img src="images/berg-propulsion.png" alt="Berg Propulsion logo">
                    <div class="title">
                        <h2>MPC800M</h2>
                        <h2>FACTORY ACCEPTANCE TEST</h2>
                    </div>
                </div>
                """;
    }

    @Override
    public String toString() {
        return generateHeader;
    }
}