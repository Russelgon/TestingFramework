package asana.e2e.core.baseTech;

import java.util.concurrent.ThreadLocalRandom;

public class RandomValueGenerator {

    public static final String rus = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    public static final String RUS = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    public static final String Rus = rus + RUS;

    public static final String num = "1234567890";

    public static final String eng = "abcdefghijklmnopqrstuvwxyz";
    public static final String ENG = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String Eng = eng + ENG;

    public static String randomLengthString(int minLength, int maxLength, String alphabet) {
        return fixedLengthString(ThreadLocalRandom.current().nextInt(minLength, maxLength + 1),
                alphabet);
    }

    public static String fixedLengthString(int length, String alphabet) {
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(randomChar(alphabet));
        }
        return sb.toString();
    }

    public static char randomChar(CharSequence chars) {
        return chars.charAt(ThreadLocalRandom.current().nextInt(chars.length()));
    }

    public static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static int randomInt(int max) {
        return ThreadLocalRandom.current().nextInt(max, max + 1);
    }
}

