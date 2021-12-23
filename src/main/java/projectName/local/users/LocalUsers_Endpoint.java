package projectName.local.users;

import common.BaseEndpoint;
import common.IEndpoint;
import projectName.local.users.dataModel.LocalUsers;
import projectName.local.users.dataModel.LocalUsers_Datamodel;

public class LocalUsers_Endpoint extends BaseEndpoint implements IEndpoint {

    private final Class<LocalUsers_Datamodel[]> classType = LocalUsers_Datamodel[].class;

    public final String path = "/users";

    public LocalUsers_Endpoint() {
        super.initRequestBody(classType, "projectName/local/local.json");
    }

    public void convertResponseToDataModel(String response) {
        super.convertJsonToDataModelArray(response, classType);
    }

    public String getEmail() {
        return super.getValueFromField("email", super.getDataModelAsArray(classType)[0]);
    }

    public String getFirstName() {
        return super.getValueFromField("first_name", super.getDataModelAsArray(classType)[0]);
    }

    public String getLastName() {
        return super.getValueFromField("last_name", super.getDataModelAsArray(classType)[0]);
    }

    public String getJob() {
        return super.getValueFromField("job", super.getDataModelAsArray(classType)[0]);
    }

    public String getId() {
        return super.getValueFromField("id", super.getDataModelAsArray(classType)[0]);
    }

    public void setUserDataByKeyName(String key, String value) {
        super.setValueOfField(key, value, super.getDataModelAsArray(classType)[0]);
    }

    public LocalUsers_Datamodel getUserDataModel() {return super.getDataModelAsArray(classType)[0];}


    public LocalUsers getResultsFromModelData(){
        LocalUsers_Datamodel localUsers_datamodel = super.getDataModelAsArray(classType)[0];
        LocalUsers localUsers = new LocalUsers();
        localUsers.setEmail(localUsers_datamodel.getEmail());
        localUsers.setFirst_name(localUsers_datamodel.getFirst_name());
        localUsers.setLast_name(localUsers_datamodel.getLast_name());
        localUsers.setJob(localUsers_datamodel.getJob());
        localUsers.setId(Integer.parseInt(localUsers_datamodel.getId()));
        return localUsers;
    }

    public LocalUsers getUserResultByID(int id){
        for (LocalUsers localUsers : super.getDataModelAsArray(classType)[0].getUsers()) {
            if (localUsers.getId() == id) {
                return localUsers;
            }
        }
//        super.getDataModelAsArray(classType)[0].getData().stream()
        return null;
    }





}
