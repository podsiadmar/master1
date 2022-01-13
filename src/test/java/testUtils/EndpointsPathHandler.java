package testUtils;

@SuppressWarnings("unused")
public class EndpointsPathHandler {
    public static String getPathWithNameParameter(String path, String id) {
        if (id.equals("")) {
            return path.replace("/{id}", "");
        } else {
            return path.replace("{id}", id);
        }
    }

    public static String getPathWithNameParameter(String path, String id, String parameter) {
        if (id.equals("")) {
            path.replace("/{id}", "");
        } else {
            path.replace("{id}", id);
        }

        if (parameter.equals("")) {
            path.replace("/{parameter}", "");
        } else {
            path.replace("{parameter}", parameter);
        }

        return path;
    }

}
