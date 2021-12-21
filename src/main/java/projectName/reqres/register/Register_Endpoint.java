package projectName.reqres.register;

import common.BaseEndpoint;
import common.IEndpoint;
import projectName.reqres.register.dataModel.Register_Datamodel;


public class Register_Endpoint extends BaseEndpoint implements IEndpoint {

    private final Class<Register_Datamodel[]> classType = Register_Datamodel[].class;

    public final String path = "/register";

    public Register_Endpoint() {super.initRequestBody(classType, "projectName/reqres/register/register.json");}

    public void convertResponseToDataModel(String response) {super.convertJsonToDataModelArray(response, classType);}

    public String getId(){return super.getValueFromField("id", super.getDataModelAsArray(classType)[0]);}

    public String getToken(){return super.getValueFromField("token", super.getDataModelAsArray(classType)[0]);}

}
