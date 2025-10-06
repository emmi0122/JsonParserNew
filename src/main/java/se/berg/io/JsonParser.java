package se.berg.io;

import org.json.JSONArray;
import org.json.JSONObject;

import se.berg.domain.TestCase;
import se.berg.domain.TestSequence;
import se.berg.domain.TestStep;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    public static TestSequence parseTestSequence(String filePath) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONObject obj = new JSONObject(content);

        // String seqName = obj.getString("name");
        JSONArray testCasesJson = obj.getJSONArray("test_cases");

        List<TestCase> testCases = new ArrayList<>();

        // Go through all test cases in the json file
        for (int i = 0; i < testCasesJson.length(); i++) {
            JSONObject testCase = testCasesJson.getJSONObject(i);
            String testName = testCase.getString("name");
            JSONArray steps = testCase.getJSONArray("steps");

            List<TestStep> testSteps = new ArrayList<>();

            // Get all steps and loop through each one
            for (int j = 0; j < steps.length(); j++) {
                JSONObject step = steps.getJSONObject(j);

                JSONObject cmd = step.getJSONObject("command");
                JSONObject cmdType = cmd.getJSONObject("cmd_type");
                JSONObject params = cmd.getJSONObject("params");

                String cmdTypeName = cmdType.getString("name");
                String action = cmd.getString("action");
                String inOutId = params.optString("InOutId", null);
                Integer value = params.has("Value") ? params.getInt("Value") : null;
                
                testSteps.add(new TestStep(cmdTypeName, action, inOutId, value));
            }

            testCases.add(new TestCase(testName, testSteps));
        }

        // Return a test sequence with all test cases
        return new TestSequence(testCases);
    }
}