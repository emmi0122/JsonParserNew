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

        JSONArray testCasesJson = obj.getJSONArray("test_cases");
        List<TestCase> testCases = new ArrayList<>();

        // Go through all test cases in the json file
        for (int i = 0; i < testCasesJson.length(); i++) {
            JSONObject testCase = testCasesJson.getJSONObject(i);
            //Get the name of the test sequence
            String testName = testCase.getString("name");
            //Look through the array of test sequences
            JSONArray steps = testCase.getJSONArray("steps");

            List<TestStep> testSteps = new ArrayList<>();

            // Get all steps and loop through each one
            for (int j = 0; j < steps.length(); j++) {
                JSONObject step = steps.getJSONObject(j);

                JSONObject cmd = step.getJSONObject("command");
                JSONObject cmdType = cmd.getJSONObject("cmd_type");
                JSONObject params = cmd.getJSONObject("params");

                String cmdTypeName = cmdType.getString("name"); //Får antingen set eller get, måste skrivas om och hitta mönster
                String action = cmd.getString("action"); //Säger just nu inte så mycket, konfigureras senare från config filen
                String inOutId = params.optString("InOutId", null); //Säger just nu inte så mycket, konfigureras senare från config filen 
                Integer value = params.has("Value") ? params.getInt("Value") : null; //Säger hur man ska flytta på lever, ska ändras till procent värden tillslut

                Integer targetAddress = null; //Checks if its null
                if (cmd.has("target_address") && !cmd.isNull("target_address")) {
                    targetAddress = cmd.getInt("target_address");
                }
                
                testSteps.add(new TestStep(cmdTypeName, action, inOutId, value, targetAddress));
            }

            testCases.add(new TestCase(testName, testSteps));
        }

        // Return a test sequence with all test cases
        return new TestSequence(testCases);
    }
}