package se.berg.io;

import org.json.*;

import se.berg.domain.*;

import java.nio.file.*;
import java.util.*;

/**
 * Utility for parsing JSON files to domain objects.
 */
public class JsonParser {
    public static TestSequence parseTestSequence(String filePath) throws Exception {
        String content = Files.readString(Paths.get(filePath));
        JSONObject rootObj = new JSONObject(content);

        JSONArray testCasesJson = rootObj.getJSONArray("test_cases");
        List<TestCase> testCases = new ArrayList<>();

        for (int i = 0; i < testCasesJson.length(); i++) {
            JSONObject testCaseObj = testCasesJson.getJSONObject(i);
            String testName = testCaseObj.getString("name");
            JSONArray stepsJson = testCaseObj.getJSONArray("steps");

            List<TestStep> steps = parseStepsArray(stepsJson);
            testCases.add(new TestCase(testName, steps));
        }

        return new TestSequence(testCases);
    }

    private static List<TestStep> parseStepsArray(JSONArray stepsJson) {
        List<TestStep> steps = new ArrayList<>();
        if (stepsJson == null)
            return steps;

        for (int j = 0; j < stepsJson.length(); j++) {
            JSONObject stepObj = stepsJson.getJSONObject(j);

            // Parse command part
            JSONObject cmdObj = stepObj.getJSONObject("command");
            JSONObject cmdTypeObj = cmdObj.getJSONObject("cmd_type");
            JSONObject params = cmdObj.optJSONObject("params");

            TestCommand command = new TestCommand(
                    cmdTypeObj.optString("name", null),
                    cmdObj.optString("action", null),
                    params != null ? params.optString("InOutId", null) : null,
                    (params != null && params.has("Value")) ? params.optInt("Value") : null,
                    cmdObj.has("target_address") && !cmdObj.isNull("target_address")
                            ? cmdObj.getInt("target_address")
                            : null,
                    params != null ? params.optString("ButtonLabel", null) : null,
                    params != null ? params.optString("FrameLabel", null) : null,
                    stepObj.optString("constantname", null),
                    stepObj.has("value") && !stepObj.isNull("value")
                            ? stepObj.getInt("value")
                            : null,
                    params != null ? params.optString("IndicatorLabel", null) : null,
                    stepObj.optString("display_unit", null));

            // Parse expected result
            String expectedResultName = null;
            Integer expectedResultMin = null;
            Integer expectedResultMax = null;

            if (stepObj.has("expected_result") && !stepObj.isNull("expected_result")) {
                Object ex = stepObj.get("expected_result");

                if (ex instanceof JSONObject obj) {
                    expectedResultName = obj.optString("name", null);
                } else if (ex instanceof JSONArray arr) {
                    if (arr.length() >= 2) {
                        expectedResultMin = arr.getInt(0);
                        expectedResultMax = arr.getInt(1);
                    }
                }
            }

            ExpectedResult expectedResult = new ExpectedResult(expectedResultName, expectedResultMin,
                    expectedResultMax);

            steps.add(new TestStep(command, expectedResult));
        }

        return steps;
    }
}