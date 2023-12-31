package asana.e2e.core.baseTech.logger;

import static asana.e2e.core.api.tech.http.HttpMapper.objectMapper;
import static asana.e2e.core.api.tech.http.HttpMapper.objectWriter;

import asana.e2e.core.api.tech.http.HttpMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import lombok.SneakyThrows;
import org.junit.jupiter.api.ClassOrderer.ClassName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerMapper {

    public static final Logger LOGGER = LoggerFactory.getLogger(ClassName.class);

    @SneakyThrows
    public static void httpLogger(HttpResponse<String> response, HttpRequest request,
            String bodyValue) {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        LOGGER.info("Request method:\t" + request.method());
        LOGGER.info("Request URI:\t" + request.uri());
        Map<String, List<String>> headers = request.headers().map();
        LOGGER.info("Headers:");
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            LOGGER.info("\t\t\t" + entry.getKey() + "=" + entry.getValue());
        }
        if (bodyValue != null) {
            LOGGER.info("Request body:\n" + objectWriter.writeValueAsString(
                    objectMapper.readTree(bodyValue)));
        }
        LOGGER.info("Response body:\n" + objectWriter.writeValueAsString(
                objectMapper.readTree(response.body())));
    }

    @SneakyThrows
    public static void httpLogger(HttpResponse<String> response, HttpRequest request) {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        LOGGER.info("Request method:\t" + request.method());
        LOGGER.info("Request URI:\t" + request.uri());
        Map<String, List<String>> headers = request.headers().map();
        LOGGER.info("Headers:");
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            LOGGER.info("\t\t\t" + entry.getKey() + "=" + entry.getValue());
        }
        LOGGER.info("Response body:\n" + objectWriter.writeValueAsString(
                objectMapper.readTree(response.body())));
    }

}
