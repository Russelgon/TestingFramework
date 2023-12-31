package asana.e2e.core.api.tech.enums;

public enum StatusCodes {
    CODES2XX(200, 201, 202, 204),

    CODES3XX(300, 301, 302, 304),

    CODES4XX(400, 401, 402, 403, 404),

    CODES5XX(500, 501, 502, 503, 504);

    private final int[] codes;

    StatusCodes(int... codes) {
        this.codes = codes;
    }

    public int[] getCodes() {
        return codes;
    }
}
