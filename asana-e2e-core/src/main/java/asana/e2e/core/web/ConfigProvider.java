package asana.e2e.core.web;

import static asana.e2e.core.baseTech.readers.FileReader.readValueFromFile;

public class ConfigProvider {

  private static final String FILE_NAME = "E:\\porgrams\\IntelliJ IDEA Community Edition 2023.3.1\\asana-e2e\\data\\browser.properties";


  public static class AppProperties {

    private static final String asanaName = "app.name";
    private static final String asanaUrl = "app.asanaUrl";
    private static final String authUsername = "app.auth.username";
    private static final String authPassword = "app.auth.password";

    public static String getAsanaName() {
      return readValueFromFile(asanaName, FILE_NAME);
    }

    public static String getAsanaUrl() {
      return readValueFromFile(asanaUrl, FILE_NAME);
    }

    public static String getAuthPassword() {
      return readValueFromFile(authPassword, FILE_NAME);
    }

    public static String getAuthUsername() {
      return readValueFromFile(authUsername, FILE_NAME);
    }
  }

  public static class SelenoidProperties {

    private static final String selenoidEnabled = "selenoid.enabled";
    private static final String recordEnabled = "selenoid.recordEnabled";

    private static final String vnc = "selenoid.vnc";
    private static final String loggingEnabled = "selenoid.loggingEnabled";
    private static final String selenoidUrl = "selenoid.url";

    public static Boolean getVnc() {
      return Boolean.getBoolean(readValueFromFile(vnc, FILE_NAME));
    }

    public static Boolean getLoggingEnabled() {
      return Boolean.getBoolean(readValueFromFile(loggingEnabled, FILE_NAME));
    }

    public static Boolean getRecordEnabled() {
      return Boolean.getBoolean(readValueFromFile(recordEnabled, FILE_NAME));
    }

    public static Boolean getSelenoidEnabled() {
      return Boolean.getBoolean(readValueFromFile(selenoidEnabled, FILE_NAME));
    }

    public static String getSelenoidUrl() {
      return readValueFromFile(selenoidUrl, FILE_NAME);
    }
  }

  public static class BrowserProperties {


    private static final String windowSize = "browser.windowSize";

    private static final String reportsFolder = "browser.reportsFolder";

    private static final String downloadsFolder = "browser.downloadsFolder";

    private static final String browser = "browser.name";

    private static final String browserVersion = "browser.version";

    private static final String proxyEnabled = "browser.proxyEnabled";

    public static String getBrowser() {
      return readValueFromFile(browser, FILE_NAME);
    }

    public static String getDownloadsFolder() {
      return readValueFromFile(downloadsFolder, FILE_NAME);
    }

    public static Boolean getProxyEnabled() {
      return Boolean.getBoolean(readValueFromFile(proxyEnabled, FILE_NAME));
    }

    public static String getBrowserVersion() {
      return readValueFromFile(browserVersion, FILE_NAME);
    }

    public static String getReportsFolder() {
      return readValueFromFile(reportsFolder, FILE_NAME);
    }

    public static String getWindowSize() {
      return readValueFromFile(windowSize, FILE_NAME);
    }
  }

}
