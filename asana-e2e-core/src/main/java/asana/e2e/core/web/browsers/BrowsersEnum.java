package asana.e2e.core.web.browsers;

public enum BrowsersEnum {
    // Local browsers (version is not required if there is only one version of each installed)
    LOCAL_CHROME(BrowsersType.CHROME, null),
    LOCAL_FIREFOX(BrowsersType.FIREFOX, null),
    LOCAL_SAFARI(BrowsersType.SAFARI, null),

    // Selenoid browsers
    CHROME119(BrowsersType.CHROME, "119.0");

    private BrowsersType type;

    public BrowsersType getType() {
        return type;
    }

    private String version;

    public String getVersion() {
        return version;
    }

    BrowsersEnum(BrowsersType type, String version) {
        this.type = type;
        this.version = version;
    }


    /**
     * Creates BrowserEnum from browserName passed as string
     *
     * @param browserName Browser name (one of the specified in enum)
     * @return BrowserEnum
     */
    public static BrowsersEnum parse(String browserName) {
        try {
            return BrowsersEnum.valueOf(browserName);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("Unknown value of browser.name in file " +
                    "Please use one of the specified in web.browsers.BrowserEnum.");
        }
    }
}

