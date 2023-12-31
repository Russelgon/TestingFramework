package asana.e2e.core.web.browsers;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

public enum BrowsersType {
    FIREFOX("firefox", ffSpecificOptions()),
    CHROME("chrome", chromeSpecificOptions()),
    SAFARI("safari", safariSpecificOptions());

    private String name;

    public String getName() {
        return name;
    }

    private MutableCapabilities capabilities;

    public MutableCapabilities getCapabilities() {
        return capabilities;
    }

    BrowsersType(String name, MutableCapabilities capabilities) {
        this.name = name;
        this.capabilities = capabilities;
    }

    private static MutableCapabilities chromeSpecificOptions() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 1); //1-Allow, 2-Block, 0-default
        prefs.put("profile.managed_default_content_settings.media_stream", 1);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("test-type");
        options.setExperimentalOption("prefs", prefs);
        options.setAcceptInsecureCerts(true);
        return options;
    }

    private static MutableCapabilities ffSpecificOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);
        return options;
    }


    private static MutableCapabilities safariSpecificOptions() {
        SafariOptions options = new SafariOptions();
        return options;
    }
}
