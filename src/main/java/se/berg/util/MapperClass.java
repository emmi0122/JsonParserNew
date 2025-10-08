package se.berg.util;

public class MapperClass {
        public static String mapTargetAddress(Integer targetAddress) {
        if (targetAddress == null) {
            return "Unknown";
        }

        return switch (targetAddress) {
            case 0 -> "ECR";
            case 1 -> "Bridge Panel 1";
            case 2 -> "Bridge Panel 2";
            case 3 -> "Bridge Panel 3";
            case 14, 15 -> "Central Unit";
            default -> "Unknown (" + targetAddress + ")";
        };
    }

    public static String mapCmdType(String cmdTypeName) {
        if (cmdTypeName == null) {
            return "Unknown";
        }

        return switch (cmdTypeName.toLowerCase()) {
            case "set" -> "Set";
            case "get" -> "Observe";
            case "subscribe" -> "Subscribe";
            default -> cmdTypeName;
        };
    }

    public static String mapCmdTypeDescription(String cmdTypeName) {
        if (cmdTypeName == null) {
            return "Unknown operation";
        }

        return switch (cmdTypeName.toLowerCase()) {
            case "set" -> "The user should perform an action";
            case "get" -> "The user should observe that something has happened";
            case "subscribe" -> "Subscribe to changes";
            default -> cmdTypeName;
        };
    }
}
