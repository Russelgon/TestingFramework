package asana.e2e.core.web.asserts;

import static asana.e2e.core.baseTech.logger.LoggerMapper.LOGGER;
import static com.jayway.awaitility.Awaitility.await;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;

public class AssertsUi {

    //************** AUTHORIZATION PAGE ASSET *******************************************************************

    public static void assertMessage(String successMessage, String expectedMessage) {
        try {
            assertThat(successMessage, (equalTo(expectedMessage)));
            LOGGER.info("Text value is: {}", successMessage);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Test failed due to an exception: " + e.getMessage());
        }
    }

    public static void softAssertMessage(String successMessage, String expectedMessage) {
        try {
            await().atMost(5, TimeUnit.SECONDS).pollInterval(1, TimeUnit.SECONDS)
                    .until(() -> {
                        LOGGER.info("Current value is: {}", successMessage);
                        return successMessage;
                    }, equalTo(expectedMessage));
            LOGGER.info("Text value is: {}", successMessage);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Test failed due to an exception: " + e.getMessage());
        }
    }
}
