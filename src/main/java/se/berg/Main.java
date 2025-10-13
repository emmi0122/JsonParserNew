package se.berg;

import java.nio.file.Files;
import java.nio.file.Paths;

import se.berg.domain.TestSequence;
import se.berg.io.JsonParser;

/**
 * Main entry for running the test sequence parser.
 */
public class Main {
    public static void main(String[] args) {
        try {
            //TestSequence seq = JsonParser.parseTestSequence("01_ENGINGE_SAFETY_SIGNLE_800M.JSON.json");
            TestSequence seq = JsonParser.parseTestSequence("01_FIRST_ENGINE_RULES_SINGLE_800M.json");
            Files.writeString(Paths.get("parsed_json.txt"), seq.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}