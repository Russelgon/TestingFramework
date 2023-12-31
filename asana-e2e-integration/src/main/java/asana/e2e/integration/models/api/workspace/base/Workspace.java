package asana.e2e.integration.models.api.workspace.base;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(
        fieldVisibility = Visibility.NONE,
        getterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE
        )
@JsonInclude(Include.NON_NULL)
public class Workspace {

    @JsonProperty(value = "data")
    private Data data;

    public Data getData() {
        return data;
    }

    public Workspace setData(Data data) {
        this.data = data;
        return this;
    }

    public static class Data {

        @JsonProperty(value = "gid")
        private String gid;

        public String getGid() {
            return gid;
        }

        public Data setGid(String gid) {
            this.gid = gid;
            return this;
        }

        @JsonProperty(value = "name")
        private String name;

        public String getName() {
            return name;
        }

        public Data setName(String name) {
            this.name = name;
            return this;
        }

        @JsonProperty(value = "resource_type")
        private String resourceType;

        public String getResourceType() {
            return resourceType;
        }

        public Data setResourceType(String resourceType) {
            this.resourceType = resourceType;
            return this;
        }

    }
}
