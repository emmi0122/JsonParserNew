package se.berg.util;

/**
 * Utility class for mapping and converting names/values in the test domain.
 */
public class MapperClass {
    public static String mapTargetAddress(Integer targetAddress) {
        if (targetAddress == null)
            return "Unknown";

        return switch (targetAddress) {
            case 0 -> "ECR";
            case 1 -> "Bridge Panel 1";
            case 2 -> "Bridge Panel 2";
            case 3 -> "Bridge Panel 3";
            case 4 -> "Panel 4";
            case 5 -> "Panel 5";
            case 14, 15 -> "Central Unit";
            default -> "Unknown (" + targetAddress + ")";
        };
    }

    public static String mapCmdType(String cmdTypeName) {
        if (cmdTypeName == null || cmdTypeName.isBlank()) {
            return "Unknown";
        }

        return switch (cmdTypeName.toLowerCase()) {
            case "set" -> "Put";
            case "get" -> "Check that";
            default -> splitCamelCase(cmdTypeName);
        };
    }

    public static String splitCamelCase(String text) {
        return (text == null || text.isEmpty())
                ? ""
                : text.replaceAll("([a-z])([A-Z])", "$1 $2");
    }

    public static String mapAction(String action) {
        if (action == null || action.isBlank()) {
            return "Unknown";
        }

        return switch (action) {
            case "DigInPort" -> "Digital Input Port";
            case "DigOutPort" -> "Digital Output Port";
            case "AnalogInput" -> "Analog Input";
            case "TextIndicatorColor" -> "Text Indicator Color";
            default -> splitCamelCase(action);
        };
    }
}
