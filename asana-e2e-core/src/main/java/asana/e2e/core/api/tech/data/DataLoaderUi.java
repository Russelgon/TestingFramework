package asana.e2e.core.api.tech.data;

import static asana.e2e.core.baseTech.readers.FileReader.readValueFromFile;

import asana.e2e.core.baseTech.RandomValueGenerator;
import asana.e2e.core.api.tech.data.user.UserUi;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataLoaderUi {

    private static final String FILE_NAME = "E:\\porgrams\\IntelliJ IDEA Community Edition 2023.3.1\\asana-e2e\\data\\data.properties";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";

    public static UserUi projectPositiveUser() {
        return new UserUi()
                .setMail(readValueFromFile(EMAIL, FILE_NAME))
                .setPassword(readValueFromFile(PASSWORD, FILE_NAME));
    }

    public static UserUi projectNegativeUser() {
        return new UserUi()
                .setMail(RandomValueGenerator.randomLengthString(5, 10, RandomValueGenerator.Eng))
                .setPassword(
                        (RandomValueGenerator.randomLengthString(5, 10, RandomValueGenerator.Eng)));
    }
}
