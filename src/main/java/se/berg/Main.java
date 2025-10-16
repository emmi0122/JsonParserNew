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
        if (args.length == 0) {
            System.err.println("Please specify a JSON file as an argument");
            System.exit(1);
        }

        String filePath = args[0];

        try {
            TestSequence seq = JsonParser.parseTestSequence(filePath);
            Files.writeString(Paths.get("parsed_json.txt"), seq.toString());
            System.out.println("Parsing done. Result can be seen in parsed_json.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}