package se.berg;

import java.nio.file.Files;
import java.nio.file.Paths;

import se.berg.domain.TestSequence;
import se.berg.io.JsonParser;

public class Main {
    public static void main(String[] args) {
        try {
            TestSequence seq = JsonParser.parseTestSequence("01_ENGINGE_SAFETY_SIGNLE_800M.JSON.json");
            Files.writeString(Paths.get("parsed_json.txt"), seq.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}