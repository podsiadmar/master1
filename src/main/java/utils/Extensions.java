package utils;

import java.util.UUID;

@SuppressWarnings("unused")
public class Extensions {

    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public static String generateRandomNumber() {
        String formatUUID = generateUUID()
                .replaceAll("[^0-9.]", "")
                .replaceFirst("^0", "");
        return formatUUID
                .substring(0, Math.min(formatUUID.length(), 9));
    }
}