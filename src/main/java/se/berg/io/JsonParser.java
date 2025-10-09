package se.berg.io;

import org.json.*;

import se.berg.domain.*;

import java.nio.file.*;
import java.util.*;

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
        if (stepsJson == null) return steps;

        for (int j = 0; j < stepsJson.length(); j++) {
            JSONObject stepObj = stepsJson.getJSONObject(j);

            JSONObject cmd = stepObj.getJSONObject("command");
            JSONObject cmdType = cmd.getJSONObject("cmd_type");
            JSONObject params = cmd.optJSONObject("params");

            String cmdTypeName = cmdType.optString("name", "");
            String action = cmd.optString("action", "");
            String inOutId = params != null ? params.optString("InOutId", null) : null;
            Integer value = (params != null && params.has("Value")) ? params.optInt("Value") : null;
            String buttonLabel = params != null ? params.optString("ButtonLabel", null) : null;
            String frameLabel = params != null ? params.optString("FrameLabel", null) : null;
            String indicatorLabel = params != null ? params.optString("IndicatorLabel", null) : null;

            Integer targetAddress = cmd.has("target_address") && !cmd.isNull("target_address")
                                    ? cmd.getInt("target_address")
                                    : null;
            String constantName = stepObj.optString("constantname", null);
            Integer constantValue = stepObj.has("value") && !stepObj.isNull("value")
                                    ? stepObj.getInt("value")
                                    : null;

            String expectedResultName = null;
            if (stepObj.has("expected_result") && !stepObj.isNull("expected_result")) {
                Object expectedResult = stepObj.get("expected_result");

                if (expectedResult instanceof JSONObject) {
                    JSONObject expectedResultObj = (JSONObject) expectedResult;
                    expectedResultName = expectedResultObj.optString("name", null);
                }
            }

            steps.add(new TestStep(                    
                cmdTypeName,
                action,
                inOutId,
                value,
                targetAddress,
                buttonLabel,
                frameLabel,
                constantName,
                constantValue, 
                indicatorLabel, 
                expectedResultName
            ));
        }

        return steps;
    }
}