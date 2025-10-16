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
            TestSequence seq = JsonParser.parseTestSequence("01_ENGINGE_SAFETY_SIGNLE_800M.JSON.json");
            //TestSequence seq = JsonParser.parseTestSequence("01_FIRST_ENGINE_RULES_SINGLE_800M.json");
            //TestSequence seq = JsonParser.parseTestSequence("01_ALARMS_AND_FAILURE_HANDLING_800M.json");
            //TestSequence seq = JsonParser.parseTestSequence("01_COMMAND_TRANSFER_800M.json");
            //TestSequence seq = JsonParser.parseTestSequence("01_LOAD_CONTROL_SINGLE_800M.json");
            //TestSequence seq = JsonParser.parseTestSequence("01_SHAFT_GENERATOR_OPERATION_SINGLE_800M.json");
            //TestSequence seq = JsonParser.parseTestSequence("01_DP_OPERATION_SINGLE_800M.json");
            //TestSequence seq = JsonParser.parseTestSequence("15_ENGINE_START_STOP_SINGLE_800M.json");
            //TestSequence seq = JsonParser.parseTestSequence("01_FIFI_OPERATION_SINGLE_800M.json");
            //TestSequence seq = JsonParser.parseTestSequence("01_SHAFT_BRAKE_SINGLE_800M.json");
            //TestSequence seq = JsonParser.parseTestSequence("26_OPERATING_MODE_FIX_PITCH_800M.json");
            //TestSequence seq = JsonParser.parseTestSequence("00_ENG_NO_HANDSHAKE_SINGLE_800M.json");
            //TestSequence seq = JsonParser.parseTestSequence("19_PTH_START_STOP_AND_MAIN_CLUTCH_SINGLE_800M.json");
            //TestSequence seq = JsonParser.parseTestSequence("20_GUI_TEST_NO_SHUTDOWN_GOVERNOR_HEALTHY_SINGLE_800M.json");
            //TestSequence seq = JsonParser.parseTestSequence("22_DD_SINGLE_800M.json");
            Files.writeString(Paths.get("parsed_json.txt"), seq.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}