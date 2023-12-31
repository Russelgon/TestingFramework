package asana.e2e.integration.models.api.project;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

@JsonAutoDetect(
        fieldVisibility = Visibility.NONE,
        getterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE
)
@JsonInclude(Include.NON_NULL)
public class ProjectResponse {

    @JsonProperty(value = "data")
    private Data data;

    public Data getData() {
        return data;
    }

    public ProjectResponse setData(Data data) {
        this.data = data;
        return this;
    }

    @JsonProperty(value = "errors")
    private Errors[] errors;

    public Errors[] getErrors() {
        return errors;
    }

    public ProjectResponse setErrors(Errors[] errors) {
        this.errors = errors;
        return this;
    }

    @JsonInclude(Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
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

        @JsonProperty(value = "resource_type")
        private String resourceType;

        public String getResourceType() {
            return resourceType;
        }

        public Data setResourceType(String resourceType) {
            this.resourceType = resourceType;
            return this;
        }

        @JsonProperty(value = "created_at")
        private Date createdAt;

        public Data setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        @JsonProperty(value = "modified_at")
        private Date modifiedAt;

        public Data setModifiedAt(Date modifiedAt) {
            this.modifiedAt = modifiedAt;
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

        @JsonProperty(value = "owner")
        private Owner owner;

        public Owner getOwner() {
            return owner;
        }

        public Data setOwner(Owner owner) {
            this.owner = owner;
            return this;
        }

        @JsonProperty(value = "workspace")
        private Workspace workspace;

        public Workspace getWorkspace() {
            return workspace;
        }

        public Data setWorkspace(Workspace workspace) {
            this.workspace = workspace;
            return this;
        }


        public static class Owner {

            @JsonProperty(value = "gid")
            private String gid;

            public String getGid() {
                return gid;
            }

            public Owner setGid(String gid) {
                this.gid = gid;
                return this;
            }

            @JsonProperty(value = "name")
            private String name;

            public String getName() {
                return name;
            }

            public Owner setName(String name) {
                this.name = name;
                return this;
            }

            @JsonProperty(value = "resource_type")
            private String resourceType;

            public String getResourceType() {
                return resourceType;
            }

            public Owner setResourceType(String resourceType) {
                this.resourceType = resourceType;
                return this;
            }
        }

        public static class Workspace {

            @JsonProperty(value = "gid")
            private String gid;

            public String getGid() {
                return gid;
            }

            public Workspace setGid(String gid) {
                this.gid = gid;
                return this;
            }

            @JsonProperty(value = "name")
            private String name;

            public String getName() {
                return name;
            }

            public Workspace setName(String name) {
                this.name = name;
                return this;
            }

            @JsonProperty(value = "resource_type")
            private String resourceType;

            public String getResourceType() {
                return resourceType;
            }

            public Workspace setResourceType(String resourceType) {
                this.resourceType = resourceType;
                return this;
            }
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Errors {

        @JsonProperty(value = "message")
        private String message;

        public String getMessage() {
            return message;
        }

        public Errors setMessage(String message) {
            this.message = message;
            return this;
        }

        @JsonProperty(value = "help")
        private String help;

        public String getHelp() {
            return help;
        }

        public Errors setHelp(String help) {
            this.help = help;
            return this;
        }

        @JsonProperty(value = "phrase")
        private String phrase;

        public String getPhrase() {
            return phrase;
        }

        public Errors setPhrase(String phrase) {
            this.phrase = phrase;
            return this;
        }
    }
}
