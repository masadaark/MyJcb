package utility;

import java.util.concurrent.ThreadLocalRandom;
public class ToolsGenerate {
    private static final String DIGITS = "0123456789";
    public static String randomStringNumber(int lenOfChar) {
        StringBuilder idCard = new StringBuilder(lenOfChar);
        ThreadLocalRandom random = ThreadLocalRandom.current();
        idCard.append(DIGITS.charAt(random.nextInt(1, 9)));
        for (int i = 1; i < lenOfChar; i++) {
            idCard.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        }
        return idCard.toString();
    }
}