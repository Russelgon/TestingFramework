package asana.e2e.integration.models.api.project;

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
public class ProjectRequest {

    @JsonProperty(value = "data")
    private Data data;

    public Data getData() {
        return data;
    }

    public ProjectRequest setData(Data data) {
        this.data = data;
        return this;
    }

    @JsonInclude(Include.NON_NULL)
    public static class Data {

        @JsonProperty(value = "name")
        private String name;

        public String getName() {
            return name;
        }

        public Data setName(String name) {
            this.name = name;
            return this;
        }

        @JsonProperty(value = "archived")
        private Boolean archived;

        public Boolean getArchived() {
            return archived;
        }

        public Data setArchived(Boolean archived) {
            this.archived = archived;
            return this;
        }

        @JsonProperty(value = "color")
        private String color;

        public String getColor() {
            return color;
        }

        public Data setColor(String color) {
            this.color = color;
            return this;
        }

        @JsonProperty(value = "current_status")
        private String currentStatus;

        public String getCurrentStatus() {
            return currentStatus;
        }

        public Data setCurrentStatus(String currentStatus) {
            this.currentStatus = currentStatus;
            return this;
        }

        @JsonProperty(value = "workspace")
        private String workspace;

        public String getWorkspace() {
            return workspace;
        }

        public Data setWorkspace(String workspace) {
            this.workspace = workspace;
            return this;
        }
    }
}


