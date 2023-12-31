package asana.e2e.core.api.tech.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class HttpMapper {

    public static final ObjectMapper objectMapper = new ObjectMapper();
    public static final ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();

}
