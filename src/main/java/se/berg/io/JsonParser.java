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

            //If a step cannot be parsed for some reason
            if (!stepObj.has("command")) {
                System.out.println("Missing command in step: " + stepObj);
                continue;
            }
            // Parse command part
            JSONObject cmdObj = stepObj.getJSONObject("command");
            JSONObject cmdTypeObj = cmdObj.getJSONObject("cmd_type");
            JSONObject params = cmdObj.optJSONObject("params");
            JSONObject esmParams = params.optJSONObject("ESMParams");

            // Extract all values
            String cmdTypeName = cmdTypeObj.optString("name", null);
            String action = cmdObj.optString("action", null);
            Integer targetAddress = cmdObj.has("target_address") && !cmdObj.isNull("target_address")
                    ? cmdObj.getInt("target_address")
                    : null;
            String constantName = stepObj.optString("constantname", null);
            Integer constantValue = stepObj.has("value") && !stepObj.isNull("value")
                    ? stepObj.getInt("value")
                    : null;
            String displayUnit = stepObj.optString("display_unit", null);

            // Create TestCommand
            TestCommand command = new TestCommand(
                    cmdTypeName,
                    action,
                    targetAddress,
                    constantName,
                    constantValue,
                    displayUnit);

            // Extract parameters for CommandParams
            String inOutId = params != null ? params.optString("InOutId", null) : null;
            Integer value = null;

            // Case 1: Read value from params:
            if (params != null && params.has("Value") && !params.isNull("Value")) {
                value = params.getInt("Value");
            }
            //Case 2: Read value from "expected_result"
            else if (stepObj.has("expected_result") && stepObj.get("expected_result") instanceof Number) {
                value = stepObj.getInt("expected_result");
            }

            String buttonLabel = params != null ? params.optString("ButtonLabel", null) : null;
            String frameLabel = params != null ? params.optString("FrameLabel", null) : null;
            String indicatorLabel = params != null ? params.optString("IndicatorLabel", null) : null;
            String esmTypeName = params != null ? params.optString("ESMTypeName", null) : null;
            boolean esmState = params != null ? params.optBoolean("NewESMState") : null;
            boolean cableStatus = params != null ? params.optBoolean("CableIntactStatus") : null;
            String branchName = params != null ? params.optString("BranchName", null) : null;
            String engineType = esmParams != null ? params.optString("Engine type", null) : null;

            // Extract CommandParams
            CommandParams commandParams = new CommandParams(
                    inOutId,
                    value,
                    buttonLabel,
                    frameLabel,
                    indicatorLabel,
                    esmTypeName,
                    esmState, 
                    cableStatus,
                    branchName,
                    engineType);

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

            ExpectedResult expectedResult = new ExpectedResult(
                    expectedResultName,
                    expectedResultMin,
                    expectedResultMax);

            steps.add(new TestStep(command, expectedResult, commandParams));
        }

        return steps;
    }
}