package projectName.local.users;

import common.BaseEndpoint;
import common.IEndpoint;
import projectName.local.users.dataModel.LocalUsers_Datamodel;

public class LocalUsers_Endpoint extends BaseEndpoint implements IEndpoint {

    private final Class<LocalUsers_Datamodel[]> classType = LocalUsers_Datamodel[].class;

    public final String path = "/users";

    public LocalUsers_Endpoint(){super.initRequestBody(classType, "projectName/local/local.json");}

    public void convertResponseToDataModel(String response) {super.convertJsonToDataModelArray(response, classType);}

    public String getEmail(){return super.getValueFromField("email", super.getDataModelAsArray(classType)[0]);}

    public String getFirstName(){return super.getValueFromField("first_name", super.getDataModelAsArray(classType)[0]);}

    public String getLastName(){return super.getValueFromField("last_name", super.getDataModelAsArray(classType)[0]);}

    public String getJob(){return super.getValueFromField("job", super.getDataModelAsArray(classType)[0]);}

    public String getId(){return super.getValueFromField("id", super.getDataModelAsArray(classType)[0]);}

}
