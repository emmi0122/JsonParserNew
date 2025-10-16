package se.berg.html;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import se.berg.domain.TestCase;

public class HtmlRender {
    public void render(List<TestCase> testCases, String outputFile) throws Exception {
        StringBuilder html = new StringBuilder();

        html.append("<!DOCTYPE html>\n");
        html.append("<html lang=\"en\">\n");
        html.append("<head>\n");
        html.append("    <meta charset=\"UTF-8\">\n");
        html.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        html.append("    <title>Factory Acceptance Test</title>\n");
        html.append("    <style>\n");
        html.append(CssRender.getCss());
        html.append("    </style>\n");
        html.append("</head>\n");
        html.append("<body>\n");

        html.append(HtmlPreset.getGenerateHeader());
        //html.append("</body>\n");
        //html.append("</html>\n");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(html.toString());
        }
    }
}
