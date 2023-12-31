package asana.e2e.core.api.tech.constructors;

import asana.e2e.core.api.tech.http.HttpMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ArrayConstructors extends HttpMapper {

    public List<String> getAllGidsConstructor(HttpResponse<String> response)
            throws IOException {

        List<String> gidValues = new ArrayList<>();
        JsonNode jsonNode = objectMapper.readTree(response.body());
        JsonNode dataArray = jsonNode.get("data");

        for (JsonNode project : dataArray) {
            String gid = project.get("gid").asText();
            gidValues.add(gid);
        }
        return gidValues;
    }
}
