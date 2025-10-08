package se.berg.util;

public class TargetAddressMapper {

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
}